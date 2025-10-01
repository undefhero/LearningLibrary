import Concurrency.MyTask;
import Concurrency.MyThread;
import Concurrency.Threading;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            Threading.run(i);

            Thread t = new MyThread(i);
            t.start();

            MyTask task = new MyTask();
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}