package DataStructures;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        // dynamic array, fast random access, slow insert \ delete
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");
        arrayList.add(0, "world!");
        System.out.println(arrayList);

        // doubly linked list, fast insert \ delete, slow random access
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("world");
        linkedList.add("Hello");
        System.out.println(linkedList);

        // stack, LIFO
        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

        Deque<String> dequeStack = new ArrayDeque<>();
        dequeStack.push("one");
        dequeStack.push("two");
        dequeStack.push("three");
        System.out.println(dequeStack);
        dequeStack.pop();
        System.out.println(dequeStack);

        // Set
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello");
        hashSet.add("world!");
        System.out.println(hashSet);

        hashSet.add("world!");
        System.out.println(hashSet);

//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("Hello");
//        hashSet.add("world!");
//        System.out.println(hashSet);

    }
}
