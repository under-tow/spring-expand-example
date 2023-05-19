package cn.under2.caffeine.load;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;


public class ManualLoad {
    private static final Logger LOG = LoggerFactory.getLogger(ManualLoad.class);


    public static void main(String[] args) {

        Cache<String, String> cache = Caffeine.newBuilder()
                // 10s过期
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .maximumSize(10000)
                .build();
        cache.put("key1", "val1");
        cache.put("key2", "val2");
        cache.put("key3", "val3");
        cache.put("key4", "val4");

        // 睡眠11s后，缓存失效
//        Tool.sleep(11);
        // 移除一个缓存元素
//        cache.invalidate("key1");
        String val1 = cache.getIfPresent("key1");
        String val2 = cache.getIfPresent("key2");
        String val3 = cache.getIfPresent("key3");
        LOG.info("val1 = {} ", val1);
        LOG.info("val2 = {} ", val2);
        LOG.info("val3 = {} ", val3);


        // cache.get(k,function) 假如key存在直接返回，不存在则用function计算后返回(并放入缓存)，类似hashmap的computeIfAbsent
        String valGet = cache.get("key5", k -> {
            return "xxx" + k.toUpperCase();
        });
        LOG.info("valGet = {} ", valGet);
        String key5 = cache.getIfPresent("key5");
        LOG.info("key5 = {} ", key5);

        // 也可以使用Cache.asMap()所暴露出来的ConcurrentMap的方法对缓存进行操作
        ConcurrentMap<String, String> cacheMap = cache.asMap();
        cacheMap.put("key6", "val6");
        String key6 = cache.getIfPresent("key6");
        LOG.info("key6 = {} ", key6);
    }


}
