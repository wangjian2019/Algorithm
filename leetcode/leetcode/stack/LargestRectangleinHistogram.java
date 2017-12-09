package leetcode.stack;

import java.util.Stack;

/**
 * Largest Rectangle in Histogram
 * 
 * Given n non-negative integers representing the histogram’s bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * 
 * 题解：如果高度一致都是递增的就一直压入栈，一旦遇到一个高度减小的，那就说明目前遍历到的这个是高度相对最高的，用这个高乘以宽度（i - 1 - stack.peek()），也就是就计算栈里面能够组成的最大四边形面积（一个个出栈分别计算四边形面积）
 */
public class LargestRectangleinHistogram {
    
    public int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int maxarea = 0;
        int i = 0;
        int temp = 0;
        int tempTop = 0;
        while (i <= n) {
            temp = (i == n ? 0 : height[i]);
            if (stack.isEmpty() || height[stack.peek()] <= temp) {
                stack.push(i);
                i++;
            } else {
                tempTop = height[stack.pop()];
                maxarea = Math.max(maxarea, tempTop * (stack.isEmpty() ? i : i - 1 - stack.peek()));
            }
        }

        return maxarea;
    }
}