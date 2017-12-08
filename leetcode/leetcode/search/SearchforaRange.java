package leetcode.search;

/**
 * Search for a Range
 * 
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm’s runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4]
 * 
 * 题解：已经排序的数组，一定是二分查找
 * 第一步，在给定数组中找到该target，记录该位置。这时我们并不关心这个target是边界还是中间值，我们只需确定，在数组中是能够找到这样一个target值。如果找不到返回{-1，-1}。为了保证时间复杂度是O(logn), 这里自然而然使用传统二分查找法实现。
 * 第二步，确定该target的右边界。此时我们将对数组从刚才确定的那个target的pos作为起始点，到数组结束，来确定右边界。同样是使用二分查找法，当新的mid值仍然等于target值时，我们能确定该mid左半边（到pos）都是等于target，继续在右半边查找。如果新的mid值不等于target值，我们就知道右边界一定在新mid值的左半边，继续查找。最后新的high指 针指向的就是右边界的位置。
 * 第三步，确定该target的左边界。这一步与第二步对称操作，最后新的low指针指向的就是左边界的位置。
 * 
 */
public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
        int[] res = { -1, -1 };
        if (A == null || A.length == 0)
            return res;

        //first iteration, find target wherever it is
        int low = 0;
        int high = A.length - 1;
        int pos = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            pos = mid;
            if (A[mid] > target)
                high = mid - 1;
            else if (A[mid] < target)
                low = mid + 1;
            else {
                res[0] = pos;
                res[1] = pos;
                break;
            }
        }

        if (A[pos] != target)
            return res;

        //second iteration, find the right boundary of this target
        int newlow = pos;
        int newhigh = A.length - 1;
        while (newlow <= newhigh) {
            int newmid = (newlow + newhigh) / 2;
            if (A[newmid] == target)
                newlow = newmid + 1;
            else
                newhigh = newmid - 1;
        }
        res[1] = newhigh;

        //third iteration, find the left boundary of this target
        newlow = 0;
        newhigh = pos;
        while (newlow <= newhigh) {
            int newmid = (newlow + newhigh) / 2;
            if (A[newmid] == target)
                newhigh = newmid - 1;
            else
                newlow = newmid + 1;
        }
        res[0] = newlow;

        return res;
    }
}