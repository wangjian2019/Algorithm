package leetcode.array;

/**
 * 
 * Set Matrix Zeroes
 * 
 * Given a m × n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * Follow up: Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 * 题解：
 * O(m + n) 空间的方法很简单，设置两个 bool 数组，记录每行和每列是否存在 0。
 * 想要常数空间，可以复用第一行和第一列。
 * 
 *  
 */
public class SetMatrixZeroes {

    //时间复杂度 O(m*n)，空间复杂度 O(m+n)
    public void test(int[][] nums) {
        int m = nums.length;
        int n = nums[0].length;

        //mark each row whether there existing zero 
        boolean[] rows = new boolean[m];
        //mark each column whether there existing zero        
        boolean[] columns = new boolean[n];

        //o(m*n)遍历，把exist zero所在的列和行，位置标志成true
        for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                if (nums[i][j] == 0) {
                    rows[i] = true; 
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            //找到某个行位置是true，把该行所有元素变成0
            if (rows[i]){
                for(int k = 0; k < n; k ++){
                    nums[i][k] = 0;
                }
            }
            //找到某个行位置是true，再找到列位置是true，把该行的该列元素设置为0
            for (int j = 0; j < n; ++j) {
                if (columns[j]) {
                    for (int ii = 0; ii < m; ++ii) {
                        nums[ii][j] = 0;
                    }
                }
            }
        }
    }

}