/*
 * @lc app=leetcode.cn id=60 lang=java
 *
 * [60] 排列序列
 */

// @lc code=start
class Solution {
    public String getPermutation(int n, int k) {
        boolean[] visited = new boolean[n];
        List<Integer> a = backTrace(n, k, visited, new LinkedList<>());
        StringBuilder sb = new StringBuilder();
        for (Integer integer : a) {
            sb.append(integer);
        }
        return sb.toString();
    }

    private volatile int count;

    private LinkedList<Integer> backTrace(int n, int k, boolean[] visited, LinkedList<Integer> result) {
        if (result.size() == n) {
            ++count;
            return result;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i - 1]) {
                continue;
            }
            
            visited[i - 1] = true;
            result.add(i);
            result = backTrace(n, k, visited, result);
            if (count == k) {
                return result;
            }
            visited[i - 1] = false;
            result.removeLast();

        }
        return result;
    }

}
// @lc code=end
