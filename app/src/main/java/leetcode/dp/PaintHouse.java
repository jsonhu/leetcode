package leetcode.dp;

/**
 * https://leetcode.cn/problems/paint-house/description/
 * 
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * 
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵
 * costs 来表示的。
 * 
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * 
 * 请计算出粉刷完所有房子最少的花费成本。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 * 最少花费: 2 + 5 + 3 = 10。
 * 示例 2：
 * 
 * 输入: costs = [[7,6,2]]
 * 输出: 2
 * 
 */
public class PaintHouse {

    /**
     * 因为每一个房子可以粉刷成三种颜色，我们定义3个函数r(i)、b(i)、g(i)分别表示从下标0的房子开始粉刷至下标i的房子为止，粉刷成红色、蓝色、绿色的花费最少的成本。
     * 按照题目的要求相邻的房子不能粉刷成相同的颜色，所以对于标号为i的房子:
     * r(i) = min(b(i - 1), g(i - 1)) + cost[i][0]
     * b(i) = min(r(i - 1), g(i - 1)) + cost[i][1]
     * g(i) = min(r(i - 1), b(i - 1)) + cost[i][2]
     * 
     * 假设有n个房子，那么粉刷至第n个房子的最少成本便是: min(r(n - 1), b(n - 1), g(n - 1))
     * 
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int n = costs.length;
        int[][] dp = new int[costs.length][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }

    public static void main(String[] args) {
        int[][] costs = new int[][] { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        PaintHouse paintHouse = new PaintHouse();
        System.out.println(paintHouse.minCost(costs));
    }
}
