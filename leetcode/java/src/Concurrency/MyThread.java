package Concurrency;

public class MyThread extends Thread {
    int count;

    public MyThread(int i) {
        this.count = i;
    }

    public void run() {
        System.out.println("Thread is running on " + this.count);
    }
}
