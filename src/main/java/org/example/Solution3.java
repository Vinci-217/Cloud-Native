package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,2]
 * 解释：[1,3] 也会被视为正确答案。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,4,8]
 * 输出：[1,2,4,8]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2 * 109
 * nums 中的所有整数 互不相同
 */
public class Solution3 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        // 动态规划数组 dp[i] 表示以 nums[i] 结尾的最大整除子集的大小
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int maxSize = 1;
        int maxValIndex = 0;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxValIndex = i;
            }
        }

        // 倒推最大整除子集
        List<Integer> res = new ArrayList<>();
        int currSize = maxSize;
        int currValue = nums[maxValIndex];

        for (int i = maxValIndex; i >= 0; i--) {
            if (dp[i] == currSize && currValue % nums[i] == 0) {
                res.add(nums[i]);
                currValue = nums[i];
                currSize--;
            }
        }
        return res;
    }
}