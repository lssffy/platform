package com.sp.demo.redis;

import redis.clients.jedis.Jedis;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/7 20:02
 */
public class HyperLogLogTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.223.137",6379);
        float size = 10000;
        for (int i = 0; i < size; i++) {
            jedis.pfadd("hll","hll"+i);
        }
        long total = jedis.pfcount("hll");
        System.out.printf("统计个数 ：%s",total);
        System.out.printf("正确率 :%s" , (total/size));
        System.out.printf("错误率 :%s" , 1-(total/size));
    }
}
