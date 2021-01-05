import java.util.Deque;

/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        boolean isLeft = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            Deque<Integer> listLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (isLeft)
                    listLevel.offerLast(curr.val);
                else
                    listLevel.offerFirst(curr.val);

                if (curr.left != null)
                    queue.offer(curr.left);
                if (curr.right != null)
                    queue.offer(curr.right);
            }
            isLeft = !isLeft;
            res.add(new LinkedList<Integer>(listLevel));
        }
        return res;
    }
}
// @lc code=end
