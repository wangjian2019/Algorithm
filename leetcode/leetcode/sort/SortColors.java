package leetcode.sort;

/**
 * Sort Color
 * 
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are
 * adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note: You are not suppose to use the library’s sort function for this problem.
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0’s, 1’s, and 2’s, then overwrite array with total number of 0’s,
 * then 1’s and followed by 2’s.
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * 
 * 题解：
 * 3指针吧。
 * 一个指针notred从左开始找，指向第一个不是0（红色）的位置；一个指针notblue从右开始往左找，指向第一个不是2（蓝色）的位置。
 * 然后另一个新的指针i指向notred指向的位置，往后遍历，遍历到notred的位置。
 * 这途中需要判断：
 * 1.当i指向的位置等于0的时候，说明是红色，把他交换到notred指向的位置，然后notred++，i++。
 * 2.当i指向的位置等于2的时候，说明是蓝色，把他交换到notblue指向的位置，然后notred--。
 * 3.当i指向的位置等于1的时候，说明是白色，不需要交换，i++即可。
 * 
 * 0， 2， 1， 0， 1， 1， 2
 * |                      |
 * pre                   last
 * 
 * 0， 2， 1， 0， 1， 1， 2
 *     |   |          |
 *     pre x         last
 * 
 * 
 * 0， 2， 1， 0， 1， 1， 2
 *     |       |      |
 *     pre     x    last
 * 
 * 0， 0， 1， 2， 1， 1， 2
 *         |   |      |
 *        pre  x     last
 * 
 * 0， 0， 1， 1， 1， 2， 2
 *         |      ||
 *        pre     xlast
 * 
 */
public class SortColors {

    public void sortColors(int[] A) {
        if (A == null || A.length == 0)
            return;

        //左指针
        int notred = 0;
        //右指针
        int notblue = A.length - 1;

        while (notred < A.length && A[notred] == 0)
            notred++;

        while (notblue >= 0 && A[notblue] == 2)
            notblue--;

        int i = notred;
        while (i <= notblue) {
            //这里当A[i] == 0的时候，走第一个分支，交换元素，交换完后有可能A[i]==2了，那么继续走第二个分支，继续交换
            if (A[i] == 0) {
                swap(A, i, notred);
                notred++;
                i++;
            } else if (A[i] == 2) {
                swap(A, i, notblue);
                notblue--;
            } else
                i++;
        }
    }

    public void swap(int A[], int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}