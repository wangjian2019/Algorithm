package leetcode.array;

import org.junit.Test;

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
 * 例子：5，3，1，2，5，2
 * 
 * left:  1,1,1,2,3,1
 * right: 3,2,1,1,2,1
 * getmax:3,2,1,2,3,1
 * result=3+2+1+2+3+1=12
 *    
 * 
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;

        int[] leftnums = new int[ratings.length];
        int[] rightnums = new int[ratings.length];

        //最少是一个苹果，默认最左面第一个位置rank最低，只有一个苹果
        leftnums[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
        	//如果下一个位置rank比上一个位置大，就多给一个苹果
            if (ratings[i] > ratings[i - 1])
                leftnums[i] = leftnums[i - 1] + 1;
          //如果下一个位置rank比上一个位置小、或是一样的，就只给一个苹果（这里其实可以是比上一个位置的苹果数一样的，也可以是比上一个位置的苹果数小的任意一个数，最小值是1，那么题目中问最少多少个苹果，这里就给最小值1）
            else
                leftnums[i] = 1;
        }
        //从左面遍历已经分完了，当从右面遍历的时候，右面第一个位置默认是左面遍历的结果
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
   
    @Test
    public void test() {
    	int[] ratings = {5,3,1,2,5,2};
    	int candy = this.candy(ratings);
    	System.out.println(candy);
    }
}
