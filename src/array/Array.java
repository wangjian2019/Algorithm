package array;
import java.util.Arrays;
/**
 * 时间复杂度（Time complexity）：
 * for(int i = 0; i < n; i++){   //n
 * 	  for(int j = 0; j < n; j = j * 2){   //log(n)
 *        n*log(n)
 * 	  }
 * }
 * o(常数) = o(1)
 */
public class Array {  //数组插入快，查找删除慢。

    public int[] nums;   //定义数组
	private int pointer;   //数组中实际插入数据的最后位置,即插入后++，删除后--。
	
	/**
	 * 构造方法初始化两个成员变量
	 * @param border  数组的长度
	 */
	public Array(int border){     
		nums = new int[border];
		pointer = 0;
	}
	
	/**
	 * 已知两个有序数组，合并成一个新的有序数组。
	 * 需要创建一个临时数组，临时数组长度等于两个有序数组长度只和
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] merge(int[] nums1, int[] nums2){
		int[] temp = new int[nums1.length + nums2.length];
		int a = 0;
		int b = 0;
		int x = 0;
		
		while(a > nums1.length || b > nums2.length){
			if(nums1[a] > nums2[b]){
				temp[x] = nums2[b];
				x++;
				b++;
			}else{
				temp[x] = nums1[a];
				x++;
				a++;
			}
		}
		if(a > nums1.length){
			temp[x++] = nums1[a++];
		}else{
			temp[x++] = nums1[a++];
		}
		return temp;
	}
	
	public boolean find(int key){  //普通查找
		if(nums.length == 0){
			return false;
		}
		for(int element : nums){
			if(key == element){
				return true;
			}
		}
		return false;
	}
	/**
	 * 非递归：二分查找的时间复杂度为log(n)
	 * @param key
	 * @return
	 */
	public boolean binarySearch(int key){  //二分法查找，最多查找【log(n)】+1
		int lower = 0;  //左指针
		int upper = pointer;  //右指针
		if(nums.length == 0){
			return false;
		}
		for(;;){  //死循环，用过return跳出此方法顺便结束循环。
			int center = (lower + upper)/2;
			if(key == nums[center]){
				return true;
			}else if(key < nums[center]){
				upper = center - 1;
			}else if(key > nums[center]){
				lower = center + 1;
			}
			if(lower > upper){  //没找到，二分查找找不到的终止条件
				return false;
			}
		}
	}
	
	/**
	 * 递归：二分查找的时间复杂度为log(n)
	 * @param key
	 * @return
	 */
	public boolean binarySearch(int key, int lower, int upper){  //二分法查找(递归实现)
		if(nums.length == 0){
			return false;
		}
		int center = (lower + upper)/2;
		if(key == nums[center]){
			return true;
		}else if(key < nums[center]){
			return binarySearch(key,lower,center - 1);
		}else if(key > nums[center]){
			return binarySearch(key,center + 1,upper);
		}
		if(lower > upper){  //没找到，二分查找找不到的终止条件
			return false;
		}
		return false;
	}
	
	public void insert(int key){  //插入（只能在数组的末尾插入）
		nums[pointer] = key;
		pointer++;
	}
	
	public void insert(int... temps){  //（可变参数列表）插入，可变参数列表的temps相当于是整形数组
		for(int i = 0; i < temps.length; i++){
			nums[pointer] = temps[i];
			pointer++;
		}
	}

    public int delete(int key){   //删除
    	if(nums.length == 0){
			System.exit(0);
		}
    	for(int i = 0; i < pointer; i++){
    		if(nums[i] == key){
    			pointer--;
    			for(int j = i; j < pointer; j++){
    				nums[j] = nums[j+1];
    			}
				nums[pointer] = 0; //因为每位都往前挪了一位，最后一位补0
    			return i;
    		}
    	}
    	return -1;	
    }
    
    public void sort(){  //数组排序，java的Arrays类专门给数组写了排序方法，可以直接调用
    	Arrays.sort(nums);
    }
    
    public boolean isDuplicate(){    //判断数组中是否有重复数据
    	for(int i = 0; i < pointer; i++){
    		for(int j = i+1; j < pointer; j++){
    			if(nums[i] == nums[j]){
    				return true;
    			}
    		}
    	}
    	return false;
    }
    
    public void noDuplicate(){   //去掉数组中重复数据
    	if(isDuplicate()){
    		for(int i = 0; i <= pointer; i++){
        		for(int j = i+1; j <= pointer; j++){
        			if(nums[i] == nums[j]){	
        				delete(nums[j]);
        			}
        		}
        	}
    	}
    }
    
    public int getMax(){   
    	int max = 0;
    	if(nums.length == 0){
			return -1;
		}
    	for(int i = 0; i < pointer; i++){
    		max = nums[0];
    		if(nums[i] > max){
    			max = nums[i];
    		}
    	}
    	return max;
    }
    
    public void removeMax(){
    	int max = getMax();
    	delete(max);
    }
    
    public int getMin(){
    	int min = 0;
    	if(nums.length == 0){
			return -1;
		}
    	for(int i = 0; i < pointer; i++){
    		min = nums[0];
    		if(nums[i] < min){
    			min = nums[i];
    		}
    	}
    	return min;
    }
    
    public void removeMin(){
    	int min = getMin();
    	delete(min);
    }
    
    public String toString(){
		return Arrays.toString(nums);   //Arrays的方法，把数组转成字符串
    }

	public static void main(String[] args) {
		int max = 10 ;
		Array array = new Array(max);
		array.insert(13,101,15,35,234,656,223,99,20,199);
		System.out.println("打印数组：" + array.toString());
		System.out.println("能否找到22：" + array.find(22));
		if(array.find(22)){
			array.delete(22);
		}
		System.out.println("能否找到22：" + array.find(22));
		System.out.println("打印数组：" + array.toString());
		array.sort();
		System.out.println("打印排序后数组：" + array.toString());
		System.out.println("二分法能否找到99：" + array.binarySearch(99));
		System.out.println("数组中是否有重复：" + array.isDuplicate());
		array.noDuplicate();
		System.out.println("数组中是否有重复：" + array.isDuplicate());
		System.out.println("打印数组：" + array.toString());
	}

	
}
