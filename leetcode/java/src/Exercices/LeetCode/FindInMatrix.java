package Exercices.LeetCode;

import java.util.Arrays;

//class FindInMatrixSolution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        for (int i = 0; i < matrix.length; i++) {
//            var first = matrix[i][0];
//            var last = matrix[i][matrix[i].length - 1];
//
//            if (target >= first && target <= last) {
//                return Arrays.stream(matrix[i]).anyMatch((n) -> {return target == n;});
//            }
//        }
//
//        return false;
//    }
//}

//class FindInMatrixSolution {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int i = 0;
//
//        while (i < matrix.length) {
//            var first = matrix[i][0];
//            var last = matrix[i][matrix[i].length - 1];
//
//            if (target >= first && target <= last) {
//                return Arrays.stream(matrix[i]).anyMatch((n) -> {return target == n;});
//            }
//
//            i++;
//        }
//
//        return false;
//    }
//}

class FindInMatrixSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        var row = findRow(matrix, target);

        if (row.length > 0) {
            return binarySearch(row, target);
        }

        return false;
    }

    // public int[] findRow(int[][] matrix, int target) {
    //     int rowLength = matrix[0].length;
    //     int firstRow = 0, lastRow = matrix.length - 1;

    //     while (firstRow <= lastRow) {
    //         var mid = lastRow / 2;

    //         if (matrix[mid][rowLength - 1] <= target) {

    //         }
    //     }
    // }

    private int[] findRow(int[][] matrix, int target) {
        int left = 0, right = matrix.length - 1;
        
        while (left <= right) {
            int mid = right + left / 2;
            int first = matrix[mid][0];
            int last = matrix[mid][matrix[mid].length - 1];
            
            if (target >= first && target <= last) {
                return matrix[mid];
            } else if (target < first) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null;
    }

    public boolean binarySearch(int[] row, int target) {
        int left = 0, right = row.length - 1;

        while (left <= right) {
            var mid = right + left / 2;

            if (row[mid] == target) return true;
            else if (row[mid] < target) left = mid + 1;
            else right = mid - 1;
        }

        return false;
    }
}

public class FindInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };

        FindInMatrixSolution solution = new FindInMatrixSolution();
        System.out.println(solution.searchMatrix(matrix, 11));

        System.out.println(3 / 2);
    }
}
