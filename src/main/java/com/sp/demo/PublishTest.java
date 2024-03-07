package com.sp.demo;

import redis.clients.jedis.Jedis;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/7 23:30
 */
public class PublishTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.223.137",6379);
        jedis.publish("test-123","32131231");
        jedis.publish("test-abc","fdhdhdhd");
    }
}
