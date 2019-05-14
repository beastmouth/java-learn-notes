package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

/**
 * @author huang
 * @version 1.0
 * @date 2019/02/27 17:11
 **/

public class SimpleRateLimiter {
    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        Pipeline pipe = jedis.pipelined();
        //zadd redis有序集合
        //标记事务的开始
        pipe.multi();
        //key score member(元素) 将元素和他的分数加入到 key（名字为key的有序集） 中
        pipe.zadd(key, nowTs, "" + nowTs);
        //Redis Zremrangebyscore 命令用于移除有序集中，指定分数（score）区间内的所有成员
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        //zcard 计算集合中的元素
        Response<Long> count = pipe.zcard(key);
        pipe.expire(key, period + 1);
        pipe.sync();
        pipe.exec();
        try {
            pipe.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count.get() <= maxCount;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.99.100", 6379);
        SimpleRateLimiter simpleRateLimiter = new SimpleRateLimiter(jedis);
        for (int i = 0; i < 20; i++) {
            System.out.println(simpleRateLimiter.isActionAllowed("hbj", "reply", 60, 5));
        }
    }
}
