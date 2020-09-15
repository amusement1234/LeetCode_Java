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
        // //解法一
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

        //解法2
        // Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        // int len = 1;
        // HashSet<String> visited = new HashSet<String>();//记录已访问的

        // beginSet.add(beginWord);
        // endSet.add(endWord);
        // while (!beginSet.isEmpty() && !endSet.isEmpty()) {
        //     if (beginSet.size() > endSet.size()) {
        //         Set<String> set = beginSet;
        //         beginSet = endSet;
        //         endSet = set;
        //     }

        //     Set<String> temp = new HashSet<String>();
        //     for (String word : beginSet) {
        //         char[] thisWorld = word.toCharArray();

        //         for (int i = 0; i < thisWorld.length; i++) {
        //             for (char c = 'a'; c <= 'z'; c++) {
        //                 char old = thisWorld[i];
        //                 thisWorld[i] = c;
        //                 String target = String.valueOf(thisWorld);

        //                 if (endSet.contains(target)) {
        //                     return len + 1;
        //                 }

        //                 if (!visited.contains(target) && wordList.contains(target)) {
        //                     temp.add(target);
        //                     visited.add(target);
        //                 }
        //                 thisWorld[i] = old;
        //             }
        //         }
        //     }

        //     beginSet = temp;
        //     len++;
        // }

        // return 0;

        // 解法三
        if (beginWord.length() == 0 || endWord.length() == 0 || wordList.size() == 0)
            return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(1, beginWord));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            Iterator<String> itr = wordList.iterator();
            while (itr.hasNext()) {
                String b = itr.next();
                if (checkNext(cur.str, b)) {
                    itr.remove();
                    if (b.equals(endWord))
                        return cur.len + 1;
                    q.offer(new Pair(cur.len + 1, b));
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
