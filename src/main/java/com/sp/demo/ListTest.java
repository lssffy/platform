package com.sp.demo;

import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/7 21:08
 */
public class ListTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.223.137",6379);
        float size = 10;
        for (int i = 0; i < size; i++) {
            jedis.rpush("test","test:" + i);
        }
        while (jedis.lpop("test")!=null) {
            jedis.rpush("test","test:"+ UUID.randomUUID().toString());
            System.out.println(jedis.lpop("test"));
        }
    }
}
