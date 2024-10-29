package leetcode.sort;

import java.util.Arrays;

public class CountingSort {

    public static void countingSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(max, num);
        }

        int[] countArr = new int[max - min + 1];
        for (int num : nums) {
            countArr[num - min]++;
        }

        int index = 0;
        for (int i = min; i <= max; i++) {
            while (countArr[i - min] > 0) {
                nums[index++] = i;
                countArr[i - min]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        countingSort(array);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}
