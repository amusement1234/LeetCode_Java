import java.util.Deque;

/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
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
    public void flatten(TreeNode root) {
        // 解法1：递归
        // 单链表中的节点顺序即为二叉树的前序遍历访问各节点的顺序
        List<TreeNode> list = new ArrayList<TreeNode>();
        helper(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }

        // // 解法2：迭代
        // List<TreeNode> list = new ArrayList<>();
        // Deque<TreeNode> stack = new LinkedList<>();
        // TreeNode node = root;
        // while (node != null || !stack.isEmpty()) {
        //     while (node != null) {
        //         list.add(node);
        //         stack.push(node);
        //         node = node.left;
        //     }
        //     node = stack.pop();
        //     node = node.right;
        // }

        // int size = list.size();
        // for (int i = 1; i < size; i++) {
        //     TreeNode prev = list.get(i - 1), curr = list.get(i);
        //     prev.left = null;
        //     prev.right = curr;
        // }

    }

    public void helper(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        list.add(root);
        helper(root.left, list);
        helper(root.right, list);
    }
}
// @lc code=end
