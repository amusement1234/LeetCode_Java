import java.util.ArrayList;
import java.util.Stack;

import sun.jvm.hotspot.opto.SafePointNode;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (73.02%)
 * Likes:    77
 * Dislikes: 0
 * Total Accepted:    25.8K
 * Total Submissions: 35.3K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        // //方法一：递归法
        // if (root == null)
        //     return new ArrayList();
        // List<Integer> res = new ArrayList<Integer>();
        // helper(root, res);
        // return res;

        //方法2：迭代
        if (root == null)
            return new ArrayList();
        Stack<Node> stack = new Stack();
        List<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            result.add(curr.val);
            Collections.reverse(curr.children);
            for (Node node : curr.children) {
                stack.add(node);
            }

        }
        return result;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null)
            return;
        res.add(root.val);
        for (Node node : root.children) {
            helper(node, res);
        }
    }
}
// @lc code=end
