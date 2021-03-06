package com.ysf.demo1;

/**
 * Create by yangshunfan
 * 2018/1/20 13:39
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        new Thread(new Thread2("A")).start();
        new Thread(new Thread2("B")).start();
    }
}

class Thread2 implements Runnable {

    private String name;

    public Thread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行" + i);
            try {
                Thread.sleep((int) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
