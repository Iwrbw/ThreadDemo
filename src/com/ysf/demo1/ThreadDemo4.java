package com.ysf.demo1;

/**
 * Create by yangshunfan
 * 2018/1/20 14:01
 *
 * yield()方法是让线程展厅回到准备阶段，这是和其他现线程一样获取CPU的权限。
 */
public class ThreadDemo4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread4("A"));
        Thread t2 = new Thread(new Thread5("B"));
        t1.start();
        t2.start();
    }
}

class Thread4 implements Runnable {

    private String name;

    public Thread4(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("+++++" + name + "---" + i);
            if (i == 5) {
                Thread.yield();
            }
        }
    }
}
class Thread5 implements Runnable {

    private String name;

    public Thread5(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("+++++" + name + "---" + i);
        }
    }
}