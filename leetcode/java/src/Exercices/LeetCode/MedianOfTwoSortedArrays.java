package Exercices.LeetCode;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int n1 = 0, n2 = 0;

        for (int i = 0; i < merged.length; i++) {
            if (n1 == nums1.length) {
                merged[i] = nums2[n2++];
            } else if (n2 == nums2.length) {
                merged[i] = nums1[n1++];
            } else if (nums1[n1] < nums2[n2]) {
                merged[i] = nums1[n1++];
            } else {
                merged[i] = nums2[n2++];
            }
        }

        return calculate(merged);
    }

    private double calculate(int[] nums) {
        var l = nums.length;

        if (l % 2 == 0) {
            var a = nums[l / 2];
            var b = nums[l / 2 - 1];

            return (nums[l / 2] + nums[l / 2 - 1]) / 2.0;
        } else if(l > 1) {
            return nums[l / 2];
        } else {
            return nums[0];
        }
    }
}

public class MedianOfTwoSortedArrays {
    public static void main(String [] args) {
       Solution sol = new Solution();
        int [] a1 = {1, 3};
        int [] b1 = {2};
        int [] a2 = {1, 2};
        int [] b2 = {3, 4};
        System.out.println(sol.findMedianSortedArrays(a1, b1));
        System.out.println(sol.findMedianSortedArrays(a2, b2));
    }
}
