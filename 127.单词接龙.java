import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 *
 * https://leetcode-cn.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (37.11%)
 * Likes:    153
 * Dislikes: 0
 * Total Accepted:    13.7K
 * Total Submissions: 36.3K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord
 * 的最短转换序列的长度。转换需遵循如下规则：
 * 
 * 
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 
 * 
 * 说明:
 * 
 * 
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * 
 * 
 * 示例 1:
 * 
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * 输出: 5
 * 
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * ⁠    返回它的长度 5。
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * 输出: 0
 * 
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * 
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
// 解法1：bfs、dfs、双端bfs


        // //解法1 bfs
        // int L = beginWord.length();
        // Map<String, List<String>> map = new HashMap();
        // for (int i = 0; i < wordList.size(); i++) {
        //     String word = wordList.get(i);
        //     for (int j = 0; j < L; j++) {
        //         String newWord = word.substring(0, j) + "*" + word.substring(j + 1, L);
        //         List<String> temp = map.getOrDefault(newWord, new ArrayList<>());
        //         temp.add(word);
        //         map.put(newWord, temp);
        //     }
        // }

        // Queue<Pair<String, Integer>> queue = new LinkedList();
        // queue.add(new Pair(beginWord, 1));

        // Map<String, Boolean> visited = new HashMap();
        // visited.put(beginWord, true);

        // while (!queue.isEmpty()) {
        //     Pair<String, Integer> node = queue.poll();
        //     String word = node.getKey();
        //     int level = node.getValue();

        //     for (int i = 0; i < L; i++) {
        //         String newWord = word.substring(0, i) + "*" + word.substring(i + 1, L);
        //         for (String str : map.getOrDefault(newWord, new ArrayList<>())) {
        //             if (str.equals(endWord))
        //                 return level + 1;
        //             if (!visited.containsKey(str)) {
        //                 visited.put(str, true);
        //                 queue.add(new Pair(str, level + 1));
        //             }
        //         }

        //     }
        // }
        // return 0;

        // 解法2
        if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0)
            return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(1, beginWord));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            Iterator<String> iterator = wordList.iterator();
            while (iterator.hasNext()) {
                String word = iterator.next();
                if (checkNext(curr.str, word)) {
                    iterator.remove();
                    if (word.equals(endWord))
                        return curr.len + 1;
                    queue.offer(new Pair(curr.len + 1, word));
                }
            }
        }
        return 0;

    }

    private boolean checkNext(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {//相同位置，不同的单词
                count++;
                if (count > 1)
                    return false;
            }
        }
        return count <= 1;
    }

    class Pair {
        int len;
        String str;

        public Pair(int len, String str) {
            this.len = len;
            this.str = str;
        }

    }
}
// @lc code=end
