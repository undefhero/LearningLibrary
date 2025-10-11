package Exercices.LeetCode;

import java.util.List;

class LongestPalindromicSubstringSolution {
    public String longestPalindrome(String str) {
        if (str == null || str.length() <= 1) return str;

        int left = 0;
        int right = str.length() - 1;
        return null;
    }

    private boolean checkPalindrome(String str) {
//        if (str == null || str.length() <= 1) return true;

        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }
}

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
//        LongestPalindromicSubstringSolution solution = new LongestPalindromicSubstringSolution();
//        solution.longestPalindrome("1bbabbacc00");

        List<String> list = List.of("a", "b", "c");
        list.stream()
                .peek(System.out::println)
                .filter(s -> s.equals("b"));


    }
}
