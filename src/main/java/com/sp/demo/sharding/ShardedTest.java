package com.sp.demo.sharding;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/10 17:13
 */
public class ShardedTest {

    public static void main(String[] args) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();

        JedisShardInfo jedisShardInfo1 = new JedisShardInfo("192.168.223.144",6379);
        JedisShardInfo jedisShardInfo2 = new JedisShardInfo("192.168.223.144",6379);
        ;
        List<JedisShardInfo> infoList = Arrays.asList(jedisShardInfo1, jedisShardInfo2);
        ShardedJedisPool jedisPool = new ShardedJedisPool(poolConfig, infoList);

        ShardedJedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            for (int i = 0; i < 100; i++) {
                jedis.set("k"+i,"" + i);
            }
            for (int i = 0; i < 100; i++) {
                Client client = jedis.getShard(""+i).getClient();
                System.out.println(jedis.get("k"+i) + "：  " + client.getHost() + ":" + client.getPort());
            }
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }
}
