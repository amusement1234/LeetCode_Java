import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<Integer>();

    // List<List<Integer>> ret = new LinkedList<List<Integer>>();
    // Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // 解法1：递归
        helper(root, sum);
        return res;

        // // 解法2：迭代
        // if (root == null)
        //     return ret;
        // Queue<TreeNode> queue = new LinkedList<>();
        // queue.offer(root);

        // Queue<Integer> queVal = new LinkedList<Integer>();
        // queVal.offer(0);

        // while (!queue.isEmpty()) {
        //     TreeNode node = queue.poll();
        //     int val = queVal.poll() + node.val;

        //     if (node.left == null && node.right == null) {
        //         if (val == sum)
        //             getPath(node);
        //         continue;
        //     }
        //     if (node.left != null) {
        //         map.put(node.left, node);
        //         queue.offer(node.left);
        //         queVal.offer(val);
        //     }
        //     if (node.right != null) {
        //         map.put(node.right, node);
        //         queue.offer(node.right);
        //         queVal.offer(val);
        //     }
        // }
        // return ret;
    }

    public void helper(TreeNode root, int sum) {
        if (root == null)
            return;
        path.addLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new LinkedList<Integer>(path));
        }
        helper(root.left, sum);
        helper(root.right, sum);
        path.removeLast();
    }

    // public void getPath(TreeNode node) {
    //     List<Integer> temp = new LinkedList<Integer>();
    //     while (node != null) {
    //         temp.add(node.val);
    //         node = map.get(node);
    //     }
    //     Collections.reverse(temp);
    //     ret.add(new LinkedList<Integer>(temp));
    // }

}
// @lc code=end
