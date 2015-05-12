/**
 * Copyright (c) 2005-2012 https://github.com/javahuang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.springframework.test.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.Lifecycle;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月10日 下午9:33:54
 * <p>Version: 1.0
 */
public class LifecycleBean implements Lifecycle {

    private static final Logger log = LoggerFactory
            .getLogger(LifecycleBean.class);

    private final Thread thread = new Thread("Lifecycle") {
        {
            setDaemon(false);
            setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
                @Override
                public void uncaughtException(Thread t, Throwable e) {
                    log.error("Abnormal thread termination", e);
                }
            });
        }

        public void run() {
            for (int i = 0; i < 10 && !isInterrupted(); ++i) {
                log.info("Hearbeat {}", i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };
    };

    @Override
    public void start() {
        log.info("Starting bean");
        thread.start();
    }

    @Override
    public void stop() {
        log.info("Stopping bean");
        thread.interrupt();
        waitForTermination();
    }

    @Override
    public boolean isRunning() {
        return thread.isAlive();
    }

    public void waitForTermination() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
