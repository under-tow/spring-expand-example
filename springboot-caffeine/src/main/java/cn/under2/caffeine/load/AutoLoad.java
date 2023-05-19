package cn.under2.caffeine.load;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AutoLoad {


    /**
     * 自动加载
     */
    public static void main(String[] args) {

        // 这里是  LoadingCache
        LoadingCache<String, String> loadingCache = Caffeine.newBuilder()
                // 10s过期
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .maximumSize(10000)
                .build(key -> "autoLoad:" + key.toUpperCase());

        // 假如key不存在，自动通过 .build(key -> createVal(key)); 加载key
        System.out.println(loadingCache.get("key9"));
        System.out.println(loadingCache.getAll(List.of("key11", "key10")));
    }


}
