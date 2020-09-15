import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (70.06%)
 * Likes:    36
 * Dislikes: 0
 * Total Accepted:    11K
 * Total Submissions: 15.6K
 * Testcase Example:  '{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}'
 *
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其后序遍历: [5,6,3,2,4,1].
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start

// Definition for a Node.
// class Node {
//     public int val;
//     public List<Node> children;

//     public Node() {}

//     public Node(int _val,List<Node> _children) {
//         val = _val;
//         children = _children;
//     }
// };

class Solution {

    public List<Integer> postorder(Node root) {

        //方法2；迭代法
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for (Node node : root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;

        // //方法一：递归法
        // if (root == null)
        //     return new ArrayList();
        // List<Integer> res = new ArrayList<Integer>();
        // helper(root, res);
        // return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null)
            return;
        for (Node node : root.children) {
            helper(node, res);
        }
        res.add(root.val);
    }
}
// @lc code=end
