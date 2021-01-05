import java.util.ArrayList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int sum) {
        // // 解法1：递归
        // if (root == null)
        //     return false;
        // if (root.left == null && root.right == null)
        //     return sum == root.val;
        // return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

        // 解法2：迭代 
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Queue<Integer> queVal = new LinkedList<Integer>();
        queVal.offer(root.val);

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            int val = queVal.poll();

            if (node.left == null && node.right == null) {
                if (val == sum)
                    return true;
                continue;
            }
            if (node.left != null) {
                queue.offer(node.left);
                queVal.offer(node.left.val + val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                queVal.offer(node.right.val + val);
            }
        }
        return false;
    }

}
// @lc code=end
