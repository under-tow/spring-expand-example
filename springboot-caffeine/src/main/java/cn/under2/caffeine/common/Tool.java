package cn.under2.caffeine.common;

import java.util.concurrent.TimeUnit;

public class Tool {


    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
