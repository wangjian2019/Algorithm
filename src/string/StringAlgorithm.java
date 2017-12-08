package string;

public class StringAlgorithm {
	
	/**
	 * 剑指offer第12题：打印1到最大的n位数，例如输入3，那么就是从1打印到999。
	 * 存在大数的可能，有可能会超出long的最大数。
	 * 
	 * 思路：有大数可能，就得使用string代替long，在string上模拟数字加法
	 */
	public void printNumber(int n){
		if(n <= 0){
			return;
		}
		//如果是c++代码，数组长度就是n+1，因为最后一位是\0
		char[] str = new char[n];
		//这里if-branch boundary不应该是和n位数的最大值做比较，例如，3位数就999做比较。这样时间复杂度是o(n)
		//这里if-branch boundary应该是+1之后如果首位进位了，就说明之前的数就是n位数的最大值，例如999,+1之后就是4位数字了。这样时间复杂度是o(1)
//		while(!increment(str)){
//			printStr(str);
//		}
	}
	
	/**
	 * 剑指offer第12题：定义一个函数，实现任意两个整数的加法
	 * 
	 * 思路：没有限定整数大小，有大数可能。使用字符串代替Integer
	 * 		数字中有可能是负数，也要考虑到
	 * 
	 */
	public void test(){
		
	}
	
	

	/**
	 * 问题：反转单词顺序（单词字母顺序改变），反转字符转中单词的顺序（每个单词中字母顺序不变）
	 * 
	 * 答案：反转整个字符串逆序输出，
	 *      “I am dell.” 变为 ".lled ma I"
	 *      然后反转每个单词
	 *      变为“. dell am I”
	 */
	public void test0(String str) {

	}
	
	/**
	 * 问题：一个字符串，只有一个字符出现一次，找到这个字符
	 * 
	 * 答案；hashmap<Char, Integer>  每个字符和对应出现的次数，第一次遍历字符串来初始化这个map，第二次在map中找这个次数是1的字符
	 */
	public void test1(String str) {

	}
	
	/**
	 * 剑指offer第4题： 替换空格，把一个字符串中的每个空格替换成"%20"，例如："We are happy."换成"We%20are%20happy."
	 * 
	 * 答案：先遍历一遍字符串，统计总共有多少个空格。
	 *       "%20"比" "多两个字符，那么当前字符串空格数*2 + 当前字符串长度str.length就是替换后字符串的长度
	 *       从字符串的尾部开始替换：
	 *        两个指针分别指向当前字符串的尾部p1和替换后字符串的尾部p2。向前移动p1,将p1的数据复制到p2; p1, p2向前移动。
	 *        当p1移动的后发现是空格字符, 将"%20"复制到p2（p2需要提前向前移动2位）, p1,p2向前移动。
	 *			时间复杂度：o(n)
	 *
	 *	关键： 合并两个数组或字符串，必须从后往前移动，减少移动次数，提高效率
	 *
	 */
	public void test2(){
		
	}
	
	
}
