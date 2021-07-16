import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

import jdk.nashorn.api.tree.Tree;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (65.05%)
 * Likes:    440
 * Dislikes: 0
 * Total Accepted:    65.8K
 * Total Submissions: 100.6K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 
 * 注意:
 * 你可以假设树中没有重复的元素。
 * 
 * 例如，给出
 * 
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 
 * 返回如下的二叉树：
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
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

    Map<Integer, Integer> map;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 解法1：递归
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int preorder_left, int preorder_right, int inorder_left,
            int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preorder_left]);
        int inorder_root = map.get(preorder[preorder_left]);
        int leftsize_subtree = inorder_root - inorder_left;

        root.left = buildTree(preorder, preorder_left + 1, preorder_left + leftsize_subtree, inorder_left,
                inorder_root - 1);
        root.right = buildTree(preorder, preorder_left + leftsize_subtree + 1, preorder_right, inorder_root + 1,
                inorder_right);
        return root;
    }
}
// @lc code=end
