package recursion;

/**
 * 剑指offer第9题：斐波那契数列
 * @author Alvin
 *
 */
public class Fibonacci {

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

	// Fibonacci数列的另外一种问法
	/**
	 * 一只青蛙一次可以跳1个台阶也可以跳2个台阶， 求青蛙跳n个台阶有多少种跳法？
	 * 
	 * @param n
	 * @return
	 */
	public long fibonacci1(int n) {
		return 1L;
	}

	// Fibonacci数列的另外一种问法
	/**
	 * 8个2*1的矩形要去覆盖2*8的矩形，有多少种方法？
	 * 
	 * @param n
	 * @return
	 */
	public long fibonacci2(int n) {
		return 1L;
	}
}
