package com.gs.array;

public class ThreadPrintNumber {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}

class MyThread implements Runnable {

    public void run() {
        for (int i=1;i<=5;i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
