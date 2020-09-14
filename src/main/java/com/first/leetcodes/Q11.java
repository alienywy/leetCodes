package com.first.leetcodes;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * @author allen
 */
public class Q11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int arrLength = height.length;
        for (int i = 0; i < arrLength; i++) {
            for (int j = i + 1; j < arrLength; j++) {
                int tempLength = Math.min(height[i], height[j]);
                int tempWidth = j - i;
                int tempArea = tempLength * tempWidth;
                if (tempArea > maxArea) {
                    maxArea = tempArea;
                }
            }
        }
        return maxArea;
    }

    public int maxArea2(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q11 solution = new Q11();
        System.out.println(solution.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}