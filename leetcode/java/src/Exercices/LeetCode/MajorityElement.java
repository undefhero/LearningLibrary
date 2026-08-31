package Exercices.LeetCode;

import java.util.Arrays;
import java.util.Map;

class MajorityElementSolution {
    public int majorityElement(int[] nums) {
        int counter = 0;

        for (int num : Arrays.stream(nums).sorted().toArray()) {
            if (++counter >= nums.length / 2) return num;
        }

        return 0;
    }
}

public class MajorityElement {
    public static void main(String[] args) {
        int[] scenario = {2, 2, 1, 1, 1, 2, 2};
        MajorityElementSolution solution = new MajorityElementSolution();
        solution.majorityElement(scenario);
    }
}
