import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 *
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (61.61%)
 * Likes:    568
 * Dislikes: 0
 * Total Accepted:    82.6K
 * Total Submissions: 129.7K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x
 * 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 
 * 
 * 示例 2:
 * 
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // // // 方法一：递归
        // if (root == null || root == p || root == q)
        //     return root;
        // TreeNode left = lowestCommonAncestor(root.left, p, q);
        // TreeNode right = lowestCommonAncestor(root.right, p, q);
        // if (left == null && right == null)
        //     return null;
        // if (left == null)
        //     return right;
        // if (right == null)
        //     return left;
        // return root; 

        // // 方法二：存储父节点
        // dfs(root);
        // while (p != null) {
        //     visited.add(p.val);
        //     p = parent.get(p.val);
        // }
        // while (q != null) {
        //     if (visited.contains(q.val)) {
        //         return q;
        //     }
        //     q = parent.get(q.val);
        // }
        // return null;

        //方法三：迭代
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        stack.push(root);
        parent.put(root, null);
        //将遍历过程中每个节点的父节点保存起来
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
                parent.put(cur.left, cur);
            }
            if (cur.right != null) {
                stack.push(cur.right);
                parent.put(cur.right, cur);
            }
        }
        HashSet<TreeNode> path = new HashSet<>();
        // 倒着还原 p 的路径，并将每个节点加入到 set 中
        while (p != null) {
            path.add(p);
            p = parent.get(p);
        }

        // 倒着遍历 q 的路径，判断是否在 p 的路径中
        while (q != null) {
            if (path.contains(q)) {
                break;
            }
            q = parent.get(q);
        }
        return q;

    }

    Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

}
// @lc code=end
