import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层序遍历 II
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null)
            return res;
        helper(root, 0, res);
        return res;
    }

    public void helper(TreeNode root, int level, List<List<Integer>> res) {
        if (root == null)
            return;
        if (res.size() == level) {
            res.add(0, new ArrayList<>());
        }
        res.get(res.size() - level - 1).add(root.val);
        if (root.left != null)
            helper(root.left, level + 1, res);
        if (root.right != null)
            helper(root.right, level + 1, res);

    }
}
// @lc code=end
