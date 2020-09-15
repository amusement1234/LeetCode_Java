import java.util.ArrayList;
import java.util.LinkedList;

import org.w3c.dom.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (65.18%)
 * Likes:    81
 * Dislikes: 0
 * Total Accepted:    19.8K
 * Total Submissions: 30.2K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 
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
    public List<List<Integer>> levelOrder(Node root) {

        // 解法2：利用队列实现广度优先搜索
        if (root == null)
            return new ArrayList();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();//要单独存size，size在for里面会变化
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                queue.addAll(node.children);
            }
            result.add(level);
        }
        return result;

        // // 解法1：递归
        // if (root == null)
        //     return new ArrayList();
        // List<List<Integer>> list = new ArrayList();
        // helper(root, list, 0);
        // return list;

    }

    public void helper(Node root, List<List<Integer>> list, int level) {
        if (list.size() <= level)
            list.add(new ArrayList<>());
        list.get(level).add(root.val);
        for (Node node : root.children) {
            helper(node, list, level + 1);

        }
    }
}
// @lc code=end
