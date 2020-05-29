import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 *
 * https://leetcode-cn.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (72.47%)
 * Likes:    662
 * Dislikes: 0
 * Total Accepted:    61.1K
 * Total Submissions: 84.2K
 * Testcase Example:  '3'
 *
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 
 * 例如，给出 n = 3，生成结果为：
 * 
 * [
 * ⁠ "((()))",
 * ⁠ "(()())",
 * ⁠ "(())()",
 * ⁠ "()(())",
 * ⁠ "()()()"
 * ]
 * 
 * 
 */

// @lc code=start

class Solution {
    List<String> list;

    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis(int n) {
        // // 方法一：深度优先遍历
        // list = new ArrayList<>();
        // geneHelper(0, 0, n, "");
        // return list;

        // // 方法二：广度优先遍历
        // List<String> res = new ArrayList<>();
        // if (n == 0)
        //     return res;

        // Queue<Node> queue = new LinkedList<>();
        // queue.offer(new Node("", n, n));

        // while (!queue.isEmpty()) {
        //     Node curNode = queue.poll();
        //     if (curNode.left == 0 && curNode.right == 0)
        //         res.add(curNode.res);

        //     if (curNode.left > 0)
        //         queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));

        //     if (curNode.right > 0 && curNode.left < curNode.right)
        //         queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));

        // }
        // return res;

        // 方法三：DP ****
        List<List<String>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(""));

        for (int i = 1; i <= n; ++i) {
            final List<String> list = new ArrayList<>();
            for (int j = 0; j < i; ++j) {
                for (final String first : lists.get(j)) {
                    for (final String second : lists.get(i - 1 - j))
                        list.add("(" + first + ")" + second);
                }
            }
            lists.add(list);
        }

        return lists.get(lists.size() - 1);
    }

    public void geneHelper(int left, int right, int n, String s) {
        //teminator
        if (left >= n && right >= n) {
            list.add(s);
            return;
        }
        //process result

        //drill down 
        if (left < n)
            geneHelper(left + 1, right, n, s + "(");

        if (right < left)
            geneHelper(left, right + 1, n, s + ")");

        //restore current status

    }

}
// @lc code=end
