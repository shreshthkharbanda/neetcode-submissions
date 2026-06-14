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
    public boolean isValidBST(TreeNode root) {
        Stack<Pair<TreeNode, Pair<Integer, Integer>>> stack = new Stack<>();
        if (root == null) return true;
        stack.push(new Pair(root, new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE)));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Pair<Integer, Integer>> pair = stack.pop();
            TreeNode cur = pair.getKey();
            Pair<Integer, Integer> minMax = pair.getValue();
            int min = minMax.getKey();
            int max = minMax.getValue();

            if (cur.val <= min || cur.val >= max) return false;

            if (cur.left != null) stack.push(new Pair(cur.left, new Pair(min, cur.val)));
            if (cur.right != null) stack.push(new Pair(cur.right, new Pair(cur.val, max)));
        }

        return true;
    }
}
