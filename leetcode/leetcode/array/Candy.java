package leetcode.array;

/**
 * 
 * Candy
 * 
 * There are N children standing in a line. Each child is assigned a rating value
 * You are giving candies to these children subjected to the following requirements:
 • Each child must have at least one candy.
 • Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * 
 * 
 * 题解：
 *  这道题和Trapping water那个是一样的想法，因为无论是水坑还是得到糖的小朋友，影响因素都不只一边，都是左右两边的最小值/最大值来决定的。
 * 所以这道题跟上一道一样，也是左右两边遍历数组。
 * leftnums数组存从左边遍历，当前小朋友对比其左边小朋友，他能拿到糖的数量；
 * rightnums数组存从右边遍历，当前小朋友对比其右边小朋友，他能拿到的糖的数量。
 * 最后针对这两个数组，每个小朋友能拿到的糖的数量就是这两个数最大的那个数，求总加和就好了。
 * 
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;

        int[] leftnums = new int[ratings.length];
        int[] rightnums = new int[ratings.length];

        leftnums[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1])
                leftnums[i] = leftnums[i - 1] + 1;
            else
                leftnums[i] = 1;
        }

        rightnums[ratings.length - 1] = leftnums[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                rightnums[i] = rightnums[i + 1] + 1;
            else
                rightnums[i] = 1;

        }

        int res = 0;
        for (int i = 0; i < ratings.length; i++)
            res += Math.max(leftnums[i], rightnums[i]);

        return res;
    }
}
