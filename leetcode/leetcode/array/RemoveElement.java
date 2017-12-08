package leetcode.array;

import sun.applet.Main;

/**
 * Remove Element
 * 
 * Given an array and a value, remove all instances of that value in place and
 * return the new length. The order of elements can be changed. It doesn’t
 * matter what you leave beyond the new length.
 * 
 * 题解：在数组中移除某个值，后面元素依次覆盖前面，必用：A[index++] = A[i];
 * 
 * @author Alvin
 *
 */
public class RemoveElement {

	public static void main(String[] args) {
		
	}
	
	public static int removeElement(int A[], int n, int elem) {
		int index = 0;
		for (int i = 0; i < n; ++i) {
			if (A[i] != elem) {
				A[index++] = A[i];
			}
		}
		return index;
	}
}
