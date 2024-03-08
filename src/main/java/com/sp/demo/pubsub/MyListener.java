package com.sp.demo.pubsub;

import redis.clients.jedis.JedisPubSub;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/7 23:30
 */
public class MyListener extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println(channel + ": " + message);
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(pattern + ": " + channel + ": " + message);
    }
}
