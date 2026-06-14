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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int level = 0;

        while (!stack.isEmpty()) {
            TreeNode recent = stack.pop();
            TreeNode left = recent.left;
            recent.left = recent.right;
            recent.right = left;
            if (recent.left != null) stack.push(recent.left);
            if (recent.right != null) stack.push(recent.right);
        }

        return root;
    }
}
