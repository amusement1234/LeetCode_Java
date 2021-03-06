/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (68.39%)
 * Likes:    306
 * Dislikes: 0
 * Total Accepted:    69.2K
 * Total Submissions: 101.1K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3
 * 
 * 输出: [1,3,2]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // // 解法1：递归调用
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;

        // // 解法2：基于栈的调用
        // List<Integer> res = new ArrayList<>();
        // Stack<TreeNode> stack = new Stack<>();
        // TreeNode curr = root;
        // while (curr != null || !stack.isEmpty()) {
        // while (curr != null) {
        // stack.push(curr);
        // curr = curr.left;
        // }
        // curr = stack.pop();
        // res.add(curr.val);
        // curr = curr.right;
        // }
        // return res;

    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        if (root.left != null)
            helper(root.left, res);
        res.add(root.val);
        if (root.right != null)
            helper(root.right, res);
    }
}

// @lc code=end
