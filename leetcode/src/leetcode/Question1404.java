package leetcode;

import java.math.BigInteger;

/**
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * 如果当前数字为偶数，则将其除以 2 。
 * 如果当前数字为奇数，则将其加上 1 。
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 *
 * @Author wushaoya
 * @date 2022-09-27
 * Time: 11:18
 */
public class Question1404 {
    public static BigInteger two = new BigInteger("2");
    public static BigInteger one = new BigInteger("1");
    public static BigInteger zero = new BigInteger("0");

    public static int numSteps(String s) {
        int step = 0;
        boolean meetFlag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                step += meetFlag ? 2 : 1;
            } else {
                if (!meetFlag) {
                    if (i != 0) {
                        step += 2;
                    }
                    meetFlag = true;
                } else {
                    step++;
                }
            }
        }
        return step;
    }

    public static int dfs(int step, BigInteger num) {
        if (num.equals(one)) {
            return step;
        }
        return dfs(step + 1,
                num.divideAndRemainder(two)[1].equals(zero) ?
                        num.divide(two) :
                        num.add(one));
    }

    public static void main(String[] args) {
        System.out.println(numSteps("1101"));
    }
}
