package Exercices.LeetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class SortColorsSolution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int current = 0;

        while (current <= right) {
            if (nums[current] == 0) {
                swap(nums, current, left);
                left++;
                current++;
            } else if (nums[current] == 2) {
                swap(nums, current, right);
//                current++;
                right--;
            } else {
                current++;
            }

            System.out.println(Arrays.toString(nums));
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class SortColors {
    public static void main(String[] args) {
        // int[] scenario = {2, 2, 2, 1, 1, 0, 0, 1, 0, 1, 0, 2, 1, 0, 2, 1, 0, 2, 1, 1};
//        int[] scenario = {2, 0, 2, 1, 1, 0};
//        SortColorsSolution solution = new SortColorsSolution();
//        solution.sortColors(scenario);

        Deque<String> queue = new LinkedList<>();
//        queue.push("Uno");
//        queue.push("Dos");
        System.out.println(queue);
        System.out.println(queue.getFirst());
//        System.out.println(queue.pop());
//        System.out.println(queue);
    }
}
