package cn.under2.caffeine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class CacheManager {

    protected static Cache<String, String> cache;

    static {
        cache = Caffeine.newBuilder()
                // 10s过期
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .maximumSize(10000)
                .build();
        cache.put("key1","val1");
        cache.put("key2","val2");
        cache.put("key3","val3");
        cache.put("key4","val4");
    }


    protected static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
