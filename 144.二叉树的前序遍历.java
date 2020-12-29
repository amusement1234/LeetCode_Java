import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (65.30%)
 * Likes:    254
 * Dislikes: 0
 * Total Accepted:    102.5K
 * Total Submissions: 156.3K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
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
 * 输出: [1,2,3]
 * 
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
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
    public List<Integer> preorderTraversal(TreeNode root) {

        // // 解法3：基于栈的遍历 
        List<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return res;

        // // 解法2：基于栈的遍历
        // List<Integer> result = new LinkedList<>();
        // Deque<TreeNode> stack = new LinkedList<>();
        // TreeNode node = root;
        // while (node != null || !stack.isEmpty()) {
        //     if (node != null) {
        //         result.add(node.val);
        //         stack.push(node.right);
        //         node = node.left;
        //     } else {
        //         node = stack.pop();
        //     }
        // }
        // return result;

        // // 解法1：递归
        // List<Integer> res = new ArrayList<>();
        // helper(root, res);
        // return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
}
// @lc code=end
