/*
 * @lc app=leetcode.cn id=93 lang=java
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
class Solution {

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result; 
        backTrack(s, 0, 0);
        return result;
    }

    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            if (isValid(s,startIndex,s.length()-1)) {
                result.add(s);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (!isValid(s, startIndex, i)) {
              break;
            }
            s = s.substring(0, i + 1) + "." + s.substring(i + 1);
            pointNum++;
            backTrack(s, i + 2, pointNum);
            pointNum--;
            s = s.substring(0, i + 1) + s.substring(i + 2);            
        }
    }

    private Boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }
        return true;
    }
 


}
// @lc code=end
