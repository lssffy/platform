package com.sp.demo.redis;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lssffy
 * @Description :
 * @date : 2024/3/7 19:07
 */
public class GeoTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.223.137",6379);
        Map<String, GeoCoordinate> geoMap = new HashMap<String, GeoCoordinate>();
        GeoCoordinate geoCoordinate = new GeoCoordinate(113.5,28.3);
        geoMap.put("jd",geoCoordinate);
        geoMap.put("tb",geoCoordinate);
        geoMap.put("pdd",geoCoordinate);
        jedis.geoadd("positions",geoMap);
        jedis.geohash("hjc","222","333","444","555");
        System.out.println(jedis.geopos("positions","jd","tb"));
        jedis.close();
    }
}
