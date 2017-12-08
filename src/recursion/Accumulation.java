package recursion;

/**
 * 累加 
 *
 */
public class Accumulation {

	public int sum(int num) {
		// 判断是否是加到了最后一个数
		if (num == 1) { 
			return 1;
		} else {
			return num + sum(num - 1); // 递归调用
		}
	}

}
