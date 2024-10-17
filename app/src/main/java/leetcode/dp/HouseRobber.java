package leetcode.dp;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/house-robber/description/
 * 
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class HouseRobber {

    /**
     * 假设街道上有n栋房子标号从0开始（[0 .. n-1]），小偷从下标为0的位置开始，定义f(i)表示为小偷从0开始到下标为i为止最多能偷盗的最大的金额。
     * 小偷在进入下标为i的房子之前有两个选择，一个是选择进入，那他就不能进i-1的房子，所以此时他能盗取的最大价值是f(i-2) + nums[i]，另外一个
     * 选择是不进入，那么他能盗取的最大金额是f(i - 1)。
     * f(i) = Math.max(f(i-1), f(i - 2) + nums[i])
     * 
     * 初始状态：从状态转移方程可以看到 i >= 2，所以当i = 0时，表示只有下标为0的一栋房子，所以f(0) = nums[0]，
     * 当 i = 1时，表示有下标0和1两栋房子，所以f(1) = max(nums[0],nums[1])
     * 
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }

    public int robBacktrack(int[] nums) {
        int n = nums.length;
        return backtrack(nums, n - 1);
    }

    private int backtrack(int[] nums, int i) {
        if (i == 0) {
            return nums[0];
        } else if (i == 1) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(backtrack(nums, i - 1), backtrack(nums, i - 2) + nums[i]);
    }

    public int robBacktrackWithMemo(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        backtrackWithMemo(nums, n - 1, memo);
        return memo[n - 1];
    }

    private void backtrackWithMemo(int[] nums, int i, int[] memo) {
        if (i == 0) {
            memo[i] = nums[0];
        } else if (i == 1) {
            memo[i] = Math.max(nums[0], nums[1]);
        } else if (memo[i] < 0) {
            backtrackWithMemo(nums, i - 1, memo);
            backtrackWithMemo(nums, i - 2, memo);

            memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 9, 3, 1 };
        HouseRobber robber = new HouseRobber();
        System.out.println(robber.rob(nums));
        System.out.println(robber.robBacktrack(nums));
        System.out.println(robber.robBacktrackWithMemo(nums));
    }
}
