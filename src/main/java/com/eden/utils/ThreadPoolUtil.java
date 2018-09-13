package com.eden.utils;

import java.util.concurrent.*;

/**
 * 线程池工具类
 * Created by nycqw
 */
public class ThreadPoolUtil {

    private static final int DEFAULT_FACTOR = 1;

    public static ExecutorService newExecutorService() {
        return newExecutorService(DEFAULT_FACTOR);
    }

    public static ExecutorService newExecutorService(int factor) {
        int processors = Runtime.getRuntime().availableProcessors();
        int poolSize = (factor + 1) * processors;
        BlockingQueue<Runnable> queue1 = new ArrayBlockingQueue<Runnable>(512);
        RejectedExecutionHandler policy = new ThreadPoolExecutor.DiscardPolicy();
        return new ThreadPoolExecutor(poolSize, poolSize, 0, TimeUnit.SECONDS, queue1, policy);
    }
}
