package leetcode.dp;

/**
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/description/
 * 
 * 如果一个二进制字符串，是以一些 0（可能没有 0）后面跟着一些 1（也可能没有 1）的形式组成的，那么该字符串是 单调递增 的。
 * 
 * 给你一个二进制字符串 s，你可以将任何 0 翻转为 1 或者将 1 翻转为 0 。
 * 
 * 返回使 s 单调递增的最小翻转次数。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：s = "00110"
 * 输出：1
 * 解释：翻转最后一位得到 00111.
 * 示例 2：
 * 
 * 输入：s = "010110"
 * 输出：2
 * 解释：翻转得到 011111，或者是 000111。
 * 示例 3：
 * 
 * 输入：s = "00011000"
 * 输出：2
 * 解释：翻转得到 00000000。
 * 
 */
public class FlipString2MonoIncreasing {

    /**
     * 假设字符串S的下标从0 ~ i，它的长度为i + 1，在翻转下标为i的字符时候它的前i个字符已经按照要求翻转完毕，所有的'0'都在'1'前面。
     * 对于下标为i的字符是否要翻转依赖于它前一个字符是'0'还是'1',如果它前一个字符是'0'，那么下标为i的字符不管是'0'还是'1'都是满足要求的，
     * 如果前一个字符是'1',下标为i的字符必须是'1'才能满足要求。
     * 我们把这个问题分两种情况讨论：
     *  1. 用f(i)定义从下标0开始到下标为i的前i+1个字符按要求翻转且最后一个字符是'0'的最小翻转次数。
     *  2. 用g(i)定义从下标0开始到下标为i的前i+1个字符按要求翻转且最后一个字符是'1'的最小翻转次数。
     * 
     * 那么对于当前的字符S[i]，如果S[i]为'0',那么f(i) = f(i - 1)，如果是'1'，f(i) = f(i - 1) + 1
     * @param s
     * @return
     */
    public int minFlipsMonoIncr(String s) {
        return 0;
    }

}
