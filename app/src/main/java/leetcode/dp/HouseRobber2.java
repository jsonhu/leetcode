package leetcode.dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈
 * ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * 
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * 
 * 输入：nums = [1,2,3]
 * 输出：3
 */
public class HouseRobber2 {

    /**
     * 这道题和之前的HouseRobber的区别是第一个房子和最后是挨在一起的，假设街道上有n栋房子，下标是从0到n - 1，如果选择进入下标是n - 1
     * 的房子那么就不能进入下标是0的房子，可以拆成2个问题来看，小偷从下标0开始到下标n - 2为止能盗取的最大金额和从下标1开始到下标 n -
     * 1为止能盗取的最大金额。
     * 两者的最大值便是问题的最优解。
     * 
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] dp0 = new int[n - 1];
        dp0[0] = nums[0];
        dp0[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n - 1; i++) {
            dp0[i] = Math.max(dp0[i - 1], dp0[i - 2] + nums[i]);
        }
        int max0 = dp0[n - 2];

        int[] dp1 = new int[n - 1];
        dp1[0] = nums[1];
        dp1[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < n - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i + 1]);
        }
        int max1 = dp1[n - 2];
        return Math.max(max0, max1);
    }

    public static void main(String[] args) {
        HouseRobber2 robber2 = new HouseRobber2();
        int[] nums = new int[] { 1,2,3};
        System.out.println(robber2.rob(nums));
    }
}
