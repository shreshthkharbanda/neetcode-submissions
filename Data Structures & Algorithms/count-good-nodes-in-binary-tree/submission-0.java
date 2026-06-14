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
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        // node val to highest up to node
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));
        int goodNodes = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();

            TreeNode cur = pair.getKey();
            int max = pair.getValue();
            if (cur.val >= max) {
                goodNodes++;
            }

            if (cur.left != null) stack.push(new Pair(cur.left, Math.max(max, cur.val)));
            if (cur.right != null) stack.push(new Pair(cur.right, Math.max(max, cur.val)));
        }

        return goodNodes;
    }
}
