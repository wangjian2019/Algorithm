package array;

import java.util.HashSet;
import java.util.Set;

public class Codility {

	/**
	 * There is an array. X,Y is index of the array. The equi-3 pair is a pair
	 * of indices (X, Y), such that 0 < X, X+1 < Y < N-1, and the sums of slices
	 * (0, X-1), (X+1, Y-1), (Y+1, N-1) are all equal. Write a function which
	 * check whether the array exists equi-3 pair.
	 */
	public int equi3Pair(int[] A) {
		int sum = 0;
		int left_sum = 0;
		int midddle_sum = 0;
		int right_sum = 0;
		int n = 0;
		n = A.length;
		int[] sumArray = new int[n];
		for (int i = 0; i < n; i++) {
			sum += A[i];
			sumArray[i] = sum;
		}
		int left_pointer = 1;
		int right_pointer = n - 2;
		while (left_pointer + 1 < right_pointer) {
			left_sum = sumArray[left_pointer - 1];
			midddle_sum = sumArray[right_pointer - 1] - sumArray[left_pointer];
			right_sum = sumArray[n - 1] - sumArray[right_pointer];
			if ((left_sum == midddle_sum) && (midddle_sum == right_sum)) {
				return 1;
			} else if (left_sum > right_sum) {
				right_pointer--;
			} else if (left_sum < right_sum) {
				left_pointer++;
			} else {
				right_pointer--;
				left_pointer++;
			}
		}
		return 0;
	}

	public void equi3PairTest() {
		System.out.println(equi3Pair(new int[] { 4, 5, 1, 1, 1, 1, 4, 3, 1 }));
	}

	public int elevator(int[] A, int[] B, int M, int X, int Y) {
		Set<Integer> peopleSet = new HashSet<Integer>();
		int stop = 0;
		int capacity = 0;
		int weight = 0;
		for (int i = 0; i < A.length; i++) {
			capacity = capacity + 1;
			weight = weight + A[i];
			if (capacity <= X && weight <= Y) {
				peopleSet.add(B[i]);
				if (i == A.length - 1) {
					stop = stop + peopleSet.size() + 1;
				}
			} else {
				i--;
				stop = stop + peopleSet.size() + 1;
				peopleSet.clear();
				capacity = 0;
				weight = 0;
			}
		}

		return stop;
	}

	public void elevatorTest() {
		int[] A = new int[3];
		A[0] = 60;
		A[1] = 80;
		A[2] = 40;
		// A[3] = 80;
		// A[4] = 20;
		int[] B = new int[3];
		B[0] = 2;
		B[1] = 3;
		B[2] = 5;
		// B[3] = 2 ;
		// B[4] = 3 ;

		System.out.println(elevator(A, B, 5, 2, 200));
	}
}
