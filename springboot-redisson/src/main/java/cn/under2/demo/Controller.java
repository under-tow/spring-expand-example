package cn.under2.demo;

import org.redisson.api.RBucket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {



    private RedissonService redissonService;

    public Controller(RedissonService redissonService) {
        this.redissonService = redissonService;
    }


    @GetMapping("redissonCache")
    public Object testRedissonCache() {
        return redissonService.cache();
    }

    @GetMapping("reentrantLock")
    public void reentrantLock() {
        redissonService.reentrantLock();
    }

}
