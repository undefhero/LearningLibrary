package Exercices.LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeInorderTraversalSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result =  new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }
}

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        // Test scenario: root = [1,2,3,4,5,null,8,null,null,6,7,9]
        
        // Tree structure:
        //         1
        //       /   \
        //      2     3
        //     / \     \
        //    4   5     8
        //       / \   /
        //      6   7 9
        
//         Build the tree manually
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.right = new TreeNode(8);
//        root.left.right.left = new TreeNode(6);
//        root.left.right.right = new TreeNode(7);
//        root.right.right.left = new TreeNode(9);
        
        // Expected inorder result: [4, 2, 6, 5, 7, 1, 3, 9, 8]

//        var queue = Deque<Integer>();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right = new TreeNode(7);

        
        BinaryTreeInorderTraversalSolution solution = new BinaryTreeInorderTraversalSolution();
        List<Integer> result = solution.inorderTraversal(root);
        
        System.out.println("Inorder traversal result: " + result);
        System.out.println("Expected: [4, 2, 6, 5, 7, 1, 3, 9, 8]");
    }
}
