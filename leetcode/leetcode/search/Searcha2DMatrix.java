package leetcode.search;

/**
 * Search a 2D Matrix
 * 
 * Write an efficient algorithm that searches for a value in an m × n matrix. This matrix has the following
 * properties:
 * • Integers in each row are sorted from left to right.
 * • The first integer of each row is greater than the last integer of the previous row.
 * For example, Consider the following matrix:
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * 
 * 题解：
 * 
 * 方法一：每一行递增，每一行的第一个元素都大于前一行的最后一个元素。那么将2D矩阵转换成1D，然后利用二分查找法来解决问题。用数学公式表示最后一个和第一个和取中间的值，略复杂。
 * 方法二：用两次二分查找法。因为所给矩阵第一列也是升序排列的，所以可以先对第一列进行二分查找，锁定该元素所在行数，然后再对列进行二分查找，即可判断target是否存在。这个的算法时间复杂度是O(log(rows)+log(columns))。 
 * 
 * 
 */
public class Searcha2DMatrix {

    //方法二
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[mid][0] == target)
                return true;
            else if (matrix[mid][0] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        int row = high; //当从while中跳出时，low指向的值肯定比target大，而high指向的值肯定比target小

        if (row < 0)
            return false;

        low = 0;
        high = matrix[0].length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return false;
    }
}