package cn.under2.demo;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;

public class CacheExample {

    public static void main(String[] args) {
        TimedCache<Object, Object> timedCache = CacheUtil.newTimedCache(1);
    }
}
