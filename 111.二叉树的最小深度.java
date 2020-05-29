/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (42.19%)
 * Likes:    255
 * Dislikes: 0
 * Total Accepted:    74.2K
 * Total Submissions: 175.1K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最小深度。
 * 
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例:
 * 
 * 给定二叉树 [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最小深度  2.
 * 
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
    public int minDepth(TreeNode root) {

        // // 方法一：递归
        // if (root == null)
        //     return 0;
        // int m1 = minDepth(root.left);
        // int m2 = minDepth(root.right);
        // //1.如果左孩子和右孩子有为空的情况，直接返回m1+m2+1
        // if (root.left == null || root.right == null)
        //     return m1 + m2 + 1;
        // else
        //     //2.如果都不为空，返回较小深度+1 
        //     return Math.min(m1, m2) + 1;

        //方法二
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            ++depth;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    //如果左右都没有 返回
                    if (node.left == null && node.right == null)
                        return depth;

                    if (node.left != null)
                        queue.offer(node.left);

                    if (node.right != null)
                        queue.offer(node.right);

                }
            }
        }
        return depth;

    }
}
// @lc code=end
