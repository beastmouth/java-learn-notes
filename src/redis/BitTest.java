package redis;

import redis.clients.jedis.Jedis;

/**
 * @author huang
 * @version 1.0
 * @date 2019/02/28 9:49
 **/

public class BitTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.99.100",6379);

    }
}
