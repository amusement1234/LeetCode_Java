/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (27.81%)
 * Likes:    358
 * Dislikes: 0
 * Total Accepted:    56.2K
 * Total Submissions: 199.9K
 * Testcase Example:  '[2,1,3]'
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 * 
 * 
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 * 
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
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        // // 方法一: 递归
        // return helper(root, null, null);

        // // 方法二：中序遍历
        // if (root == null)
        //     return true;
        // if (!isValidBST(root.left))
        //     return false;
        // if (root.val <= pre)
        //     return false;
        // pre = root.val;
        // return isValidBST(root.right);

        // //方法三：中序遍历（二叉搜索树中序遍历得到升序）
        // if (root == null)
        //     return true;
        // inOrder(root);
        // for (int i = 1; i < res.size(); i++) {
        //     if (res.get(i) <= res.get(i - 1)) {
        //         return false;
        //     }
        // }
        // return true;

        //方法四：中序遍历 迭代
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode pre = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();

            if (pre != null && pre.val >= curr.val)
                return false;
            pre = curr;
            curr = curr.right;
        }
        return true;
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;

        int thisVal = node.val;
        if (lower != null && lower >= thisVal)
            return false;
        if (upper != null && upper <= thisVal)
            return false;

        boolean b1 = helper(node.left, lower, thisVal);
        if (!b1)
            return false;

        boolean b2 = helper(node.right, thisVal, upper);
        if (!b2)
            return false;

        return true;
    }

    List<Integer> res = new ArrayList<>();

    private void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            res.add(root.val);
            inOrder(root.right);
        }
    }

}
// @lc code=end
