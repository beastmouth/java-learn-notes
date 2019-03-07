//package redis;
//
//import redis.clients.jedis.Jedis;
//
///**
// * @author huang
// * @version 1.0
// * @date 2019/02/24 16:39
// **/
//
//public class PfTest {
//    public static void main(String[] args) {
//        Jedis jedis = new Jedis("192.168.99.100",6379);
//
//        jedis.ping();
//        for (int i = 0; i < 100; i++) {
//            jedis.pfadd("testpf", "user" + i);
//            long total = jedis.pfcount("testpf");
//            if (total != i + 1) {
//                System.out.printf("%d %d\n", total, i + 1);
//                break;
//            }
//        }
//        jedis.close();
//    }
//}
