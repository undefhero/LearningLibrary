package Exercices;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

interface CommonExercise<T> {
    T calculate(int value);
}

class Factorial implements CommonExercise<Integer> {
    @Override
    public Integer calculate(int value) {
        int acc = 1;

        for (int i = 1; i < value; i++) {
            acc = acc * i;
        }

        return acc;
    }
}

class Fibonacci implements CommonExercise<List<Integer>> {
    List<Integer> list;

    Fibonacci() {
        this.list = new LinkedList<>();
        this.list.add(0);
        this.list.add(1);
    }

    @Override
    public List<Integer> calculate(int value) {
        for (int i = 2; i < value; i++) {
            this.list.add(i, this.list.get(i - 2) + this.list.get(i - 1));
        }

        return this.list;
    }
}

class FibonacciRecursive implements CommonExercise<Integer> {
    @Override
    public Integer calculate(int value) {
        if (value <= 1) return value;

        return calculate(value - 2) + calculate(value - 1);
    }
}

class FibonacciRecursiveList implements CommonExercise<List<Integer>> {
    List<Integer> list;

    FibonacciRecursiveList() {
        this.list = new LinkedList<>();
        this.list.add(0);
        this.list.add(1);
    }

    @Override
    public List<Integer> calculate(int value) {
        IntStream.range(2, value)
                .forEach((v) -> { this.list.add(this.list.get(v - 2) + this.list.get(v - 1)); });

        return this.list;
    }
}

class CommonExample {
    public static void main(String[] args) {
        Factorial fact = new Factorial();
        System.out.println(fact.calculate(5));

        Fibonacci fib = new Fibonacci();
        System.out.println(fib.calculate(10));

        FibonacciRecursive fibRecursive = new FibonacciRecursive();
        System.out.println(fibRecursive.calculate(10));

        FibonacciRecursiveList fibRecursiveList = new FibonacciRecursiveList();
        System.out.println(fibRecursiveList.calculate(10));
    }
}
