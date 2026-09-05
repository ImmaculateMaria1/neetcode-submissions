/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeightAndBalance(root) != -1;
    }

    // Helper function to calculate both height and check balance
    private int checkHeightAndBalance(TreeNode node) {
        // A null tree is height 0 and balanced
        if (node == null) {
            return 0;
        }

        // Recursively get the height of the left subtree
        int leftHeight = checkHeightAndBalance(node.left);
        if (leftHeight == -1) {
            return -1;  // Left subtree is unbalanced
        }

        // Recursively get the height of the right subtree
        int rightHeight = checkHeightAndBalance(node.right);
        if (rightHeight == -1) {
            return -1;  // Right subtree is unbalanced
        }

        // Check the balance condition at the current node
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;  // Current subtree is unbalanced
        }

        // If balanced, return the height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

