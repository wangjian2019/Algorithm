package leetcode.array;

/**
 * Climb stairs
 * 
 * You are climbing a stair case. It takes n steps to reach to the top. Each
 * time you can either climb 1 or 2 steps. In how many distinct ways can you
 * climb to the top?
 * 
 * Solution：菲比納妾數列
 * 
 * 设 f(n) 表示爬 n 阶楼梯的不同方法数，为了爬到第 n 阶楼梯，有两个选择：
 *  从第 n − 1 阶前进 1 步；
 *  从第 n − 1 阶前进 2 步；
 * 因此，有 f(n) = f(n − 1) + f(n − 2)。
 * 这是一个斐波那契数列。
 * 
 * 方法 1，递归，太慢；
 * 方法 2，迭代
 * 
 * @author Alvin
 *
 */
public class Climbintairs {
	// 如果n=10,那么要先求f(9),f(8), 要是f(9)就要求f（8），f（7）。。。。
	// 递归效率很低，时间复杂度以n的指数递增
	// 数字从后往前计算，相同数字被计算多遍
	// o(n^n)非常大
	public long fibonacci(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	// Fibonacci数列增强版，不能使用递归
	// o(n)
	public long enhance(int n) {
		int[] result = { 0, 1 };
		if (n < 2) {
			return result[n];
		}
		long f1 = 1;
		long f2 = 0;
		long fn = 0;
		for (int i = 2; i <= n; ++i) {
			fn = f1 + f2;
			f2 = f1;
			f1 = fn;
		}
		return fn;
	}
}
