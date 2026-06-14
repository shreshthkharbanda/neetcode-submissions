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
    public int kthSmallest(TreeNode root, int k) {
        int kLeft = k;

        Stack<TreeNode> stack = new Stack<>();
        if (root == null || k == 0) return 0;

        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            kLeft--;
            if (kLeft == 0) return cur.val;

            if (cur.right != null) {
                TreeNode node2 = cur.right;
                while (node2 != null) {
                    stack.push(node2);
                    node2 = node2.left;
                }
            }
        }

        return root.val;
    }
}
