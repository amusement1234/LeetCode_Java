import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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

    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        // 解法1：递归
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(postorder, 0, postorder.length - 1, 0, inorder.length);
    }

    public TreeNode buildTree(int[] postorder, int postorder_left, int postorder_right, int inorder_left,
            int inorder_right) {
        if (postorder_left > postorder_right || inorder_left > inorder_right) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder_right]);
        int inorder_root = map.get(postorder[postorder_right]);
        int leftsize_subtree = inorder_root - inorder_left;

        root.left = buildTree(postorder, postorder_left, postorder_left + leftsize_subtree - 1, inorder_left,
                inorder_root - 1);
        root.right = buildTree(postorder, postorder_left + leftsize_subtree, postorder_right - 1, inorder_root + 1,
                inorder_right);
        return root;
    }
}
// @lc code=end
