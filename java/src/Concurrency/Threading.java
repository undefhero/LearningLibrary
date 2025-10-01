package Concurrency;

import static java.lang.Thread.sleep;

public class Threading {
    public static void run(int i) {
        Thread t = new Thread(() -> { System.out.println("Thread in method, with thread = " + i);});
        t.start();
    }
}
