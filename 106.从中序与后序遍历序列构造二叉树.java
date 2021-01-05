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

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/tu-jie-gou-zao-er-cha-shu-wei-wan-dai-xu-by-user72/
        
        // 在后序遍历序列中,最后一个元素为树的根节点
        // 在中序遍历序列中,根节点的左边为左子树，根节点的右边为右子树

        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        post = postorder;
        return buildTree(0, postorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int posStart, int posEnd, int inStart, int inEnd) {
        if (inEnd < inStart || posEnd < posStart)
            return null;
        TreeNode root = new TreeNode(post[posEnd]);
        int inRoot = map.get(root.val);
        int numsLeft = inRoot - inStart;

        // [posStart, posStart + numsLeft - 1] [inStart, inRoot - 1]
        root.left = buildTree(posStart, posStart + numsLeft - 1, inStart, inRoot - 1);
        // [posStart + numsLeft, posEnd - 1] [inRoot + 1, inEnd]
        root.right = buildTree(posStart + numsLeft, posEnd - 1, inRoot + 1, inEnd);
        return root;
    }
}
// @lc code=end
