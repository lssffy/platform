package com.sp.demo.pubsub;

import com.sp.demo.pubsub.MyListener;
import redis.clients.jedis.Jedis;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/7 23:33
 */
public class ListenerTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.223.137",6379);
        final MyListener listener = new MyListener();
        jedis.psubscribe(listener,new String[]{"test-*"});
    }
}
