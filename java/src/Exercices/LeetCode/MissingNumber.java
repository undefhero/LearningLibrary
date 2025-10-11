package Exercices.LeetCode;

import java.util.Arrays;
import java.util.stream.IntStream;

//class MissingNumberSolution {
//    public int missingNumber(int[] nums) {
//        var sorted = Arrays.stream(nums).sorted().toArray();
//
//        for (int i = 0; i < sorted.length; i++) {
//            if (i != sorted[i]) return i;
//        }
//
//        return sorted.length + 1;
//    }
//}

//class MissingNumberSolution {
//    public int missingNumber(int[] nums) {
//        return IntStream.rangeClosed(0, nums.length).sum() - Arrays.stream(nums).sum();
//    }
//}

class MissingNumberSolution {
    public int missingNumber(int[] nums) {
        var sum = Arrays.stream(nums).sum();


        return 0;
    }
}

public class MissingNumber {
    public static void main(String [] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        MissingNumberSolution solution = new MissingNumberSolution();

        System.out.println(solution.missingNumber(nums));
    }
}
