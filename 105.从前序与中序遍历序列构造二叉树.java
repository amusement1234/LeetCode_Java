import java.util.HashMap;

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

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] pre;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        pre = preorder;

        return buildTree(0, preorder.length, 0, inorder.length);
    }

    public TreeNode buildTree(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart == preEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        // [preStart + 1, preStart + numsLeft + 1] [inStart, inRoot - 1]
        root.left = buildTree(preStart + 1, preStart + numsLeft + 1, inStart, inRoot - 1);
        // [preStart + numsLeft + 1, preEnd] [inRoot + 1, inEnd]
        root.right = buildTree(preStart + numsLeft + 1, preEnd, inRoot + 1, inEnd);
        return root;

    }

}
// @lc code=end
