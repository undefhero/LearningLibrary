package Exercices.LeetCode;

import java.util.*;

//class IntersectionOfTwoArraysSolution {
//    public int[] intersection(int[] nums1, int[] nums2) {
//        List<Integer> result = new LinkedList<>();
//
//        Arrays.stream(nums2).distinct().forEach((n2) -> {
//            Arrays.stream(nums1).distinct().anyMatch((n1) -> {
//                if (n1 == n2) {
//                    result.add(n1);
//                    return true;
//                }
//
//                return false;
//            });
//        });
//
//        return result.stream().mapToInt(Integer::intValue).toArray();
//    }
//}

class IntersectionOfTwoArraysSolution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> result = new HashSet<>();
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}



public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        IntersectionOfTwoArraysSolution solution = new IntersectionOfTwoArraysSolution();
        solution.intersection(nums1, nums2);
    }
}
