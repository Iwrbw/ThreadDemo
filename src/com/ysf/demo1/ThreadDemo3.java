package com.ysf.demo1;

/**
 * Create by yangshunfan
 * 2018/1/20 13:47
 *
 * join方法
 */
public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程运行开始" + Thread.currentThread().getName());
        Thread t1 = new Thread(new Thread3("A"));
        Thread t2 = new Thread(new Thread3("B"));
        t1.start();
        t2.start();
        /**
         * 这里加入join（）方法就可以使主线程等待t1和t2线程运行完在结束主线程
         */
        t1.join();
        t2.join();
        System.out.println("主线程运行结束" + Thread.currentThread().getName());
    }
}

class Thread3 implements Runnable {

    private String name;

    public Thread3(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        System.out.println("线程开始运行：" + Thread.currentThread().getName());
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行：" + i);
            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("线程结束运行：" + Thread.currentThread().getName());
        System.out.println("线程运行时间：" + (end - start) + "ms");
    }
}