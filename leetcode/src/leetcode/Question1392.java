package leetcode;

/**
 * 「快乐前缀」是在原字符串中既是非空 前缀也是后缀（不包括原字符串自身）的字符串。
 * 给你一个字符串 s，请你返回它的 最长快乐前缀。如果不存在满足题意的前缀，则返回一个空字符串""。
 *
 * @Author wushaoya
 * @date 2023-07-17
 * Time: 8:54
 */
public class Question1392 {
    public static void main(String[] args) {
        longestPrefix("aabcaabcaab");
    }
    public static String longestPrefix(String s) {
        // KMP算法
        int[] maxMatchLens = new int[s.length()];
        int currentLen = 0;
        for (int i = 1; i < s.length(); i++) {
            while (currentLen > 0 && s.charAt(i) != s.charAt(currentLen)) {
                currentLen = maxMatchLens[currentLen - 1];
            }
            if (s.charAt(i) == s.charAt(currentLen)) {
                currentLen++;
            }
            maxMatchLens[i] = currentLen;
        }
        return s.substring(0, currentLen);
        //=========超时=========
        /*for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(0) && s.charAt(s.length() - 1 - i) == s.charAt(s.length() - 1)) {
                if (s.substring(i).equals(s.substring(0, s.length() - i))) {
                    return s.substring(i);
                }
            }
        }
        return "";*/
    }
}
