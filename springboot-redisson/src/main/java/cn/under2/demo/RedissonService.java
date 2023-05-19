package cn.under2.demo;

import cn.hutool.core.date.TimeInterval;
import org.junit.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

@org.springframework.stereotype.Service
public class RedissonService {

    private RedissonClient redissonClient;

    public RedissonService(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
     * redisson的缓存由 RBucket<T> 泛型来维护
     * @return
     */
    public Object cache() {
        RBucket<Object> bucket = redissonClient.getBucket("key1");
        Object val = bucket.get();
        if (val != null) {
            return val;
        } else {
            val = "val1";
            bucket.set(val);
        }
        return val;
    }


    /**
     * 可重入锁，同一个线程可以多次获得。
     * 假如重入获得，会在redis维护一个count值来记录重入次数，释放时减少重入次数。为0或没有锁是，其他线程（应用）才可以加锁
     */
    public void reentrantLock() {

        String lockKey = "your_business_id";
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                RLock lock = redissonClient.getLock(lockKey);
                if (lock.tryLock()) {
                    try {
                        System.out.println("执行业务逻辑");
//                        System.out.println("再次尝试拿锁（由于是可重入的，结果是成功的） = " + lock.tryLock()); lock.unlock();
                        TimeUnit.SECONDS.sleep(10);
                        System.out.println("执行业务逻辑完毕");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }


            }, String.valueOf(i)).start();
        }
    }

}
