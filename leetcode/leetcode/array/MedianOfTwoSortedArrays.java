package leetcode.array;

/**
 * Median of Two Sorted Arrays
 * 
 * There are two sorted arrays A and B of size m and n respectively. Find the
 * median of the two sorted arrays. The overall run time complexity should be
 * O(log (m+n)).
 * 
 * 题解：
 * median，即中位数。
 * 计算中位数：把数组按照大小的顺序排列。如果个数是奇数，则中间那个数就是中位数；如果个数是偶数，
 * 则中间那2个数的平均值就是中位数。
 * 
 * 因此，在计算中位数Median时候，需要根据奇偶分类。
 * 
 * 解决此题的方法可以依照：寻找2个unioned sorted arrays中的第k大（从1开始数）的数（k=(m+n)/2就是中位数）。因而等价于寻找并判断两个sorted
 * array中各自的第k/2（从1开始数）大的数。
 * 
 * 特殊化到求median，那么对于奇数来说，就是求k = (m+n)/2+1（从1开始数）大的数。
 * 而对于偶数来说，就是求第(m+n)/2大（从1开始数）和第(m+n)/2+1大（从1开始数）的数的平均值。
 * 
 * 判断两个有序数组A,B中第k大的数：也就是判断A[(k/2)-1]和B[(k/2)-1]的大小。
 * 
 * 如果A[k/2-1]==B[k/2-1]，那么这个数就是两个数组中第k大的数。
 * 如果A[k/2-1]<B[k/2-1], 那么说明A[0]到A[k/2-1]都不可能是第k大的数，所以需要舍弃这一半，继续从A[k/2]到A[A.length-1]继续找。当然，因为这里舍弃了A[0]到A[k/2-1]这k/2个数，那么第k大也就变成了，第k-k/2个大的数了。
 * 如果 A[k/2-1]>B[k/2-1]，就做之前对称的操作就好。
 * 
 * 边界条件: 需要判断是否有一个数组长度为0，以及k==1时候的情况。
 * 
 * 因为除法是向下取整，对每个数组的分半操作采取：
 * int partA = Math.min(k/2,m); 
 * int partB = k - partA;
 * 
 * 为了能保证上面的分半操作正确，需要保证A数组的长度小于B数组的长度。
 * 同时，在返回结果时候，注意精度问题，返回double型的就好。
 * @author Alvin
 *
 */
public class MedianOfTwoSortedArrays {
	
	
	public static double findMedianSortedArrays(int A[], int B[]) {
		int m = A.length;
		int n = B.length;
		int total = m + n;
		//两个数组的长度只和是奇数，那么中位数就是一个数字，而不是需要取平均值
		if (total % 2 != 0) {
			// k传得是第k个，奇数长度的数组，中位数的位置是(total / 2) + 1
			return (double) findKth(A, 0, m - 1, B, 0, n - 1, (total / 2) + 1);
		} else {
			//两个数组长度只和是偶数，中位数是中间两个数字的平均值	
			double x = findKth(A, 0, m - 1, B, 0, n - 1, total / 2);// k传得是第k个，偶数数长度的数组，中位数的位置是total / 2和(total / 2) + 1
			double y = findKth(A, 0, m - 1, B, 0, n - 1, (total / 2) + 1);// k传得是第k个，偶数数长度的数组，中位数的位置是total / 2和(total / 2) + 1
			//算中间两个数字的平均值，就是中位数
			return (double) (x + y) / 2;
		}
	}

	public static int findKth(int[] A, int begin1, int end1, int[] B, int begin2, int end2, int k) {
		int m = end1 - begin1 + 1;
		int n = end2 - begin2 + 1;

		if (m == 0)
			return B[k - 1];
		if (k == 1)
			return Math.min(A[begin1], B[begin2]);
		if (m > n)
			return findKth(B, begin2, end2, A, begin1, end1, k);
		

		int partA = Math.min(k / 2, m);
		int partB = k - partA;
		if (A[begin1 + partA - 1] < B[begin2 + partB - 1])
			return findKth(A, begin1 + partA, end1, B, begin2, end2, k - partA);
		else if (A[begin1 + partA - 1] > B[begin2 + partB - 1])
			return findKth(A, begin1, end1, B, begin2 + partB, end2, k - partB);
		else
			return A[begin1 + partA - 1];
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,4,5,7,9,11,13,15};
		int[] b = {0,2,4,6,8,10};
		double median = findMedianSortedArrays(a, b);
		System.out.println(median);
	}
}
