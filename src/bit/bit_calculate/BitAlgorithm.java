package bit.bit_calculate;

import java.util.List;

/*
 *   & : 0&0=0, 1&0=0, 0&1=0, 1&1=1
 *   | : 0|0=0, 1|0=1, 0|1=1, 1|1=1
*亦或 ^ : 0^0=0, 1^0=1, 0^1=1, 1^1=0
 *   <<: 00001010<<2=00101000
 *   >>: 00101000>>2=00001010 整数右移一位和整数除以2在数学上等价，但是位运算效率高很多
 **
 *
 * 位运算定理1：把一个整数减去1，再和原整数做&运算，会把该整数最右边一个1变成0
 * 位运算定理2：位运算>>1 可以代替除以2 (/2)， 位运算<<1 可以代替乘以2 (*2)
 * 位运算定理3：二进制最后一位是0，那么这个数字是偶数，如果是1，那么这个数字是奇数。位运算&1  可以代替取求余数运算%判断奇偶数
 * 位运算定理4：判断两个数字不同之处的地方，一定使用亦或^
 * 位运算定理5：循环处理每个二进制位，从最后一位开始，每次>>一位
 */
public class BitAlgorithm {
	
	/**
	 * 利用位运算，不使用辅助内存空间，实现两个变量交换位置
	 */
	public void testSwap(List<Integer> list){
		int i = list.get(0);
		int j = list.get(1);
		i = i^j;
		j = j^i;
		i = i^j;
		list.set(0, i);
		list.set(1, j);
	}
	
	/**
	 * 问题：不使用加减乘除四则运算，实现两个数相加
	 * 
	 * 思路：第一步：两个二进制数相加不进位（也就是亦或）
	 *       第二步： 二进制只有1+1的时候才有进1位，因此两个二进制数进行与操作，结果进1位
	 *       第三步：重复前两步，直到不产生进位为止
	 */
	public int testPlus(int i, int j){
		int sum;
		int carry;
		for(;j != 0;){
			sum = i ^ j;
			carry = (i & j) << 1;
			i = sum;
			j = carry;
		}
		return i;
	}
	
	/**
	 * 剑指offer第10题：二进制中1的个数
	 * 
	 * 思路1：1的二进制是00000001，把00000001与这个整数做&运算，如果是1，那么这个数字的二进制最后一位一定是1，如果是0，那么该数字末尾位一定是0。然后该数字>>一位继续比较
	 * 以上整数如果是负数，会有死循环。因为第一位标记位是标识负数的1，因此无论怎么>>这个负数位1也是不会动的，死循环
	 * 思路2：循环条件不是>>该整数，而是<<00000001
     * 思路3：位运算定理1：把一个整数减去1，再和原整数做&运算，会把该整数最右边一个1变成0
	 */
	public int get1Count(int num){
//思路1：		
//		int count = 0;
//		while(num > 0){
//			if((num & 1) == 1 ? true : false){
//				count++;
//			}
//			num = num >> 1;
//		}
//		return count;
//思路2：		
//		int count = 0;
//		int flag = 1;
//		//loop times = binary位数，32位整数要循环32次
//		while(flag > 0){
//			if((num & flag) == 1 ? true : false){
//				count++;
//			}
//			flag = flag << 1;
//		}
//		return count;
//思路3：
		int count = 0;
		while(num > 0){
			count++;
			num = (num - 1) & num;
		}
		return count;
	}
	
	/**
	 * 问题：一条语句判断一个整数是不是2的整数次方
	 * 
	 * 思路：一个整数如果是2的整数次方，那么它的二进制中有且只有一位是1，其他位都是0。
	 *     把这个整数-1再&它自己，这个整数中唯一的1就会变成0
	 */
	public boolean verify2(int num){
		return false;
	}
	
	/**
	 * 问题：输入两个整数m和n，需要改变m的二进制多少位才能和n相等
	 * 思路：第一步求这两个数字的亦或，第二步统计亦或结果中1的位数
	 */
	public int modifyNumber(int m, int n){
		return 0;
	}
	
	/**
	 * 剑指offer第11题：求数值的整数次方，power可以是正数、负数、0
	 * 
	 * 思路1：当是正数次方，循环下num=num*num
	 *       当是负数次方，循环下num=num*num，取倒数
	 *       当是0次方，结果是1
	 *       当是整数是负数，按正数去做，最后用0减变成负数
	 *       当是整数是0，最终结果是0
	 *       
	 * 思路2：   循环下num=num*num效率太低。 
	 *     当偶数次方的时候，a^n = a^(n/2)*a^(n/2)
	 *     当奇数次方的时候，a^n = a^(n-1/2)*a^(n-1/2)*a
	 */
	public double testPower(double num, int power){
		if(num == 0){
			return 0;
		}
		if(power == 0){
			return 1;
		}else if(power == 1){
			return num;
		}else{
			if(power > 1){
				double result = testPower(num, power >> 1);
				result = result * result;
				if((power & 0x1) == 1){
					result = result * num;
				}
				return result;
			}
			if(power < 0){
				power = Math.abs(power);
				// power >> 1相当于power=power/2
				double result = testPower(num, power >> 1);
				result = result * result;
				// &0x1判断奇数偶数，相当于%2
				if((power & 0x1) == 1){
					result = result * num;
				}
				return 1/result;
			}
		}
		return 0;
	}
	
}
