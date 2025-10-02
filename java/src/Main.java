import Concurrency.MyTask;
import Concurrency.MyThread;
import Concurrency.Threading;
import Core.CSVParser;
import Core.Random;
import Core.ReadWrite;

import java.util.List;
import java.util.Map;
import java.util.random.RandomGenerator;
import java.util.random.RandomGenerator.SplittableGenerator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

//        concurrencyCase();
//        coreRandomCase();
//        coreReadWrite();
        coreCSVParser();
    }

    private static void coreCSVParser() {
        CSVParser parser = new CSVParser("src/Core/data/account.csv");
        List<Map<String, String>> parsed = parser.parse();
//        CSVParser.export("src/Core/data/account.json", parsed);
    }

    private static void coreReadWrite() {
      ReadWrite rw = new ReadWrite();

      rw.run();
    }

    private static void coreRandomCase() {
        Random myRandom = new Random();
        RandomGenerator generator1 = myRandom.getRandom();
        RandomGenerator generator2 = myRandom.getFactory().create();

        System.out.println("random: " + generator1.nextLong());
        System.out.println("factory: " + generator2.nextLong());
        System.out.println("factory: " + generator2.nextLong());

        SplittableGenerator generator3 = myRandom.getSplittableGenerator();

        IntStream processes = IntStream.rangeClosed(1, 10); // streams are lazy

        processes.parallel().forEach(p -> {
            RandomGenerator r = generator3.split();
            System.out.println("process " + p + ": " + r.nextLong());
        });
    }

    private static void concurrencyCase() {
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