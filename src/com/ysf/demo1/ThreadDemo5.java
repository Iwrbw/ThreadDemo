package com.ysf.demo1;

/**
 * Create by yangshunfan
 * 2018/1/20 15:27
 *
 * 设置线程优先级
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread6("A"));
        Thread t2 = new Thread(new Thread6("B"));
        //t1优先级为NORM,t2优先级为MAX 10
        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}

class Thread6 implements Runnable {

    private String name;

    public Thread6(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("+++++" + name + "---" + i);
        }
    }
}
