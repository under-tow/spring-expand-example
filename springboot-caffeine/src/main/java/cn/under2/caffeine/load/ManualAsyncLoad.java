package cn.under2.caffeine.load;

import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;


public class ManualAsyncLoad {
    private static final Logger LOG = LoggerFactory.getLogger(ManualAsyncLoad.class);


    public static void main(String[] args) {

        AsyncCache<String, Object> cache = Caffeine.newBuilder()
                // 10s过期
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .maximumSize(10000)
                .buildAsync();
        CompletableFuture<Object> key1 = cache.getIfPresent("key1");
        cache.get("key",k->k.toUpperCase());

    }

}
