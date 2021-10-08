package com.lmmmowi.sample.jvm;

public class DeadLock {

    private final Object lockA = new Object();
    private final Object lockB = new Object();

    public static void main(String[] args) {
        new DeadLock().run();
    }

    public void run() {
        Thread thread1 = new Thread(() -> {
            synchronized (lockA) {
                workOnLock(lockA);

                synchronized (lockB) {
                    workOnLock(lockB);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lockB) {
                workOnLock(lockB);

                synchronized (lockA) {
                    workOnLock(lockA);
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    private void workOnLock(Object lock) {
        System.out.println(Thread.currentThread().getName() + "获取到锁" + lock);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
