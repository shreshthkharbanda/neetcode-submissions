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
        return height(root) != -1;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        
        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        if (heightLeft == -1 || heightRight == -1 || Math.abs(heightLeft - heightRight) > 1) return -1;

        return 1 + Math.max(heightLeft, heightRight);
    }
}
