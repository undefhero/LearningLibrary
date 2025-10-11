package Exercices.LeetCode;

import java.util.*;

class MajorityElementTwoSolution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> storage =  new HashSet<>();
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);

            if (counts.get(num) > nums.length / 3) storage.add(num);
        }

        return storage.stream().toList();
    }
}

public class MajorityElementTwo {
    public static void main(String[] args) {
        int[] scenario = {2, 2, 1, 1, 1, 2, 2};
        MajorityElementSolution solution = new MajorityElementSolution();
        System.out.println(solution.majorityElement(scenario));
    }
}
