package com.ysf.demo1;

/**
 * Create by yangshunfan
 * 2018/1/20 15:41
 *
 * wait()方法
 */
public class ThreadDemo6 {
    public static void main(String[] args) throws InterruptedException {

        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Thread7 pa = new Thread7("A", c, a);
        Thread7 pb = new Thread7("B", a, b);
        Thread7 pc = new Thread7("C", b, c);
        new Thread(pa).start();
        Thread.sleep(100);  //确保按顺序A、B、C执行
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
}

class Thread7 implements Runnable {

    private String name;
    private Object a;
    private Object b;

    public Thread7(String name,Object a,Object b) {
        this.name = name;
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("++++++" + name + "-----" + i);
            synchronized (a) {
                synchronized (b) {
                    if (i % 2 == 0) {
                        System.out.println(name);
                        b.notify();
                    }
                    try {
                        a.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
