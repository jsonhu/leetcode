package leetcode.dp;

/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 * 
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * 请你计算并返回达到楼梯顶部的最低花费。
 * 
 * 示例 1：
 * 
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 * 
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 *
 */
public class MinCostClimbingStairs {

    /**
     * 如果一个楼梯有n级台阶（台阶从0计数，[0..n-1]），由于一次可以爬1级或者2级台阶，因此最终爬到楼梯顶部可以从n-1级台阶或者n-2级台阶爬上去。
     * 定义f(i)表示从第i级台阶向上爬的最小支付成本，那么本题的最优解便是f(n-1)和f(n-2)的最小值。
     * 状态转移方程：f(i) = min(f(i - 1), f(i - 2)) + cost[i]
     * 初始状态：如果i = 0表示从第0级台阶向上爬的最小成本f(0) = cost[0]，如果i =
     * 1表示从第1级台阶向上爬的最小成本，因为本题可以从下标为1的台阶向上爬，
     * 所以f(1) = cost[1]
     * 
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int minCostClimbingStairsBacktrack(int[] cost) {
        int n = cost.length;
        return Math.min(backtrack(cost, n - 1), backtrack(cost, n - 2));
    }

    private int backtrack(int[] cost, int i) {
        if (i < 2) {
            return cost[i];
        }
        return Math.min(backtrack(cost, i - 1), backtrack(cost, i - 2)) + cost[i];
    }

    public int minCostClimbingStairsBacktrackWithMemo(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n];
        backtrackWithMemo(cost, n - 1, memo);
        return Math.min(memo[n - 1], memo[n - 2]);
    }

    private void backtrackWithMemo(int[] cost, int i, int[] memo) {
        if (i < 2) {
            memo[i] = cost[i];
        } else if (memo[i] == 0) {
            backtrackWithMemo(cost, i - 1, memo);
            backtrackWithMemo(cost, i - 2, memo);
            memo[i] = Math.min(memo[i - 1], memo[i - 2]) + cost[i];
        }
    }

    public static void main(String[] args) {
        int[] cost = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
        MinCostClimbingStairs climbingStairs = new MinCostClimbingStairs();
        int minCost = climbingStairs.minCostClimbingStairsBacktrackWithMemo(cost);
        System.out.println(String.format("minCost: %d", minCost));
    }
}
