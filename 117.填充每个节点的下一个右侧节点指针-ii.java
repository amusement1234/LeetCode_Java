/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {

  public Node connect(Node root) {
    if (root == null) return null;
    Queue<Node> queue = new LinkedList<Node>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int n = queue.size();
      Node last = null;
      for (int i = 1; i <= n; i++) {
        Node temp = queue.poll();
        if (temp.left != null) queue.offer(temp.left);
        if (temp.right != null) queue.offer(temp.right);
        if (i != 1) last.next = temp;
        last = temp;
      }
    }
    return root;
  }
}
// @lc code=end
