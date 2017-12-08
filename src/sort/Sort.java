package sort;

import java.util.Arrays;

/**
 * 稳定排序：冒泡法，鸡尾酒法，插入排序，归并排序。 不稳定排序：选择排序，希尔排序，堆排序，快速排序。
 * 
 * @author Alvin
 *
 */
public class Sort {

	private static long counter = 0; // 对象计数器
	private final long id = counter++; // 对象id号
	int[] nums;
	int border = 10;

	public Sort() {
		nums = new int[] { 9, 6, 8, 0, 3, 1, 5, 2, 4, 7 };
	}

	/**
	 * 非常慢，最简单的排序算法：每一轮之后，最大的放于最右边。 n个数，最坏n(n-1)/2次比较，平均n(n-1)/4次比较。
	 * 最差、平均是o(n^2)，最好是o(n)。
	 * 
	 * @param nums
	 */
	public void bubbleSort(int[] nums) {
		int temp = 0;
		for (int i = nums.length - 1; i > 0; i--) { // 限制是i>0，因为剩最后一个的时候，一定是最小的，放在第一个位置
			for (int j = 0; j < i; j++) {
				if (nums[j] > nums[j + 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
		/*
		 * for(int i = 0; i < nums.length; i++){ for(int j = 0; j < nums.length
		 * - i; j++){ if(nums[j] > nums[j+1]){ temp = nums[j]; nums[j] =
		 * nums[j+1]; nums[j+1] = temp; } } }
		 */
	}

	/**
	 * 鸡尾酒排序，非常慢，冒泡排序的变形：每一轮之后，最大的放于最右边，最小的放最左边。
	 * n个数，最坏n(n-1)/2次比较，平均n(n-1)/4次比较。 最差、平均是o(n^2)，最好是o(n)。
	 * 
	 * @param nums
	 */
	public void cockTail(int[] nums) { // 鸡尾酒排序，双向冒泡，第一次把最大的放最后一个，最小的放第一个；第二次把第二大的放倒数第二个，第二小的放第二个，以此类推。
		int temp = 0;
		for (int i = 0; i < nums.length / 2; i++) { // 因为每次循环都排好了两个数字，因此此限制到i <
													// nums.length/2
			for (int j = 0; j < nums.length - i; j++) {
				if (nums[j] > nums[j + 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
			for (int j = nums.length - i; j > 0; j--) {
				if (nums[j] < nums[j - 1]) {
					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 选择排序算法（冒泡算法的改进版本）。每一轮之后，最小的放于最左边。 n个数，最坏交换次数n次O(n)，比较次数n(n-1)/2次。
	 * 最差、平均都是o(n^2)。
	 * 
	 * @param nums
	 */
	public void selectionSort(int[] nums) {
		int temp = 0;
		int j, min = 0;
		for (int i = 0; i < nums.length; i++) {
			min = i;
			for (j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[min]) {
					min = j;
				}
			}
			temp = nums[i];
			nums[i] = nums[min];
			nums[min] = temp;
		}
	}

	/**
	 * 插入排序算法 比冒泡方法快一倍，应用局部有序的原则，开始默认第一个数所在区域局部有序。
	 * n个数，最坏n(n-1)/2次比较，n(n-1)/2次复制。 最好情况：当数据本已有序时，内层循环无效，O(n)
	 * 
	 * @param
	 *
	 * 			12453
	 *            124 5 12 45 12345
	 */
	public void insertSort(int[] nums) {
		int temp;
		int j;
		for (int i = 1; i < nums.length; i++) { // 插入排序，从第二个数开始排（ i =
												// 1），第一个数是局部有序部分
			temp = nums[i]; // 先把待插入的数放入临时存储temp中
			// 把很符合的元素逐个往后挪位置，最后把待插入的元素插入到空位中
			for (j = i; j > 0 && temp < nums[j - 1]; j--) {
				nums[j] = nums[j - 1];
			}
			nums[j] = temp;
		}
	}

	/**
	 * 二分插入排序算法 是直接插入排序的改进0(n^2)，稳定排序
	 */
	public void binaryInsertSort(int[] nums) {
		int temp;
		for (int i = 1; i < nums.length; i++) { // 插入排序，从第二个数开始排（ i =
												// 1），第一个数是局部有序部分
			temp = nums[i]; // 先把待插入的数放入临时存储temp中
			int low = 0;
			int high = i - 1;
			while (low < high) { // 二分法，最后low和high会并成一个地方
				int mid = (low + high) / 2;
				if (temp > nums[mid]) {
					low = mid + 1;
				} else if (temp < nums[mid]) {
					high = mid - 1;
				}
			}
			for (int k = i - 1; k > high; k--) {
				nums[k + 1] = nums[k];
			}
			nums[high + 1] = temp;
		}
	}

	/**
	 * 归并排序步骤：1.无限二分拆分，直到无法拆分（lower==upper），每个元素在一个拆分中。
	 * 2.把每次拆分的两边的数组排序存进临时数组temp中。 3.返回temp数组（已经排序好）覆盖掉原数组的部分 原则就是：1.归并拆分
	 * 2.合并两个数组（同有序数组合并算法）
	 * 
	 * 已知两个有序数组，合并成一个新的有序数组。 需要创建一个临时数组，临时数组长度等于两个有序数组长度只和
	 * 
	 * 前三个冒泡、插入、选择都需要o(n^2)时间，归并排序只需要o(N*logN)。 缺点：需要在存储器中再新建一个大小等于被排序数组的数组，占空间。
	 * 
	 * @param nums
	 */
	public int[] mergeSort(int[] nums, int lower, int upper) {
		int center = (lower + upper) / 2;
		if (lower == upper) { // 已经拆分完毕
			return nums;
		} else {
			// 左边，递归左面数组拆分
			mergeSort(nums, lower, center);
			// 右边 ，递归右面数组拆分
			mergeSort(nums, center + 1, upper);
			// 左右归并 ，对每个拆分数组进行排序
			merge(nums, lower, center, upper);
		}
		return nums;
	}

	// 开辟一个新的临时数组，合并两个拆分的区域，也就是合并有序数组nums[lower~center]和有序数组nums[center+1~upper]到这个新数组中
	public static void merge(int[] nums, int lower, int center, int upper) {
		// 创建临时数组，临时数组长度=要合并的两个有序数组长度之和
		int[] temp = new int[upper - lower + 1];
		int begin1 = lower;// 左指针
		int begin2 = center + 1;// 右指针
		int k = 0;

		// 把较小的数先移到新的临时数组中
		while (begin1 <= center && begin2 <= upper) {
			if (nums[begin1] < nums[begin2]) {
				temp[k++] = nums[begin1++];
			} else {
				temp[k++] = nums[begin2++];
			}
		}

		// 把左边剩余的数移入数组
		while (begin1 <= center) {
			temp[k++] = nums[begin1++];
		}

		// 把右边边剩余的数移入数组
		while (begin2 <= upper) {
			temp[k++] = nums[begin2++];
		}

		// 把新数组中的数覆盖nums数组
		for (int k2 = 0; k2 < temp.length; k2++) {
			nums[k2 + lower] = temp[k2];
		}
	}

	/**
	 * 希尔排序，o(N*(logN)^2),最坏情况和平均情况相差不大。（插入排序为1-增量排序） 希尔排序就是在不同的增量h下的插入排序
	 */
	public void shellSort(int[] nums) {
		int h = nums.length / 2;
		int temp = 0;
		int i, j = 0;

		// 插入排序就是步长全是1，希尔排序是步长是h，每次/2每次变小，代码和简单插入排序一样，就是把1换成h，外面有个循环改变h
		for (; h > 0; h = h / 2) {
			for (i = h; i < nums.length; i++) {
				temp = nums[i];
				for (j = i; j > h - 1 && temp <= nums[j - h]; j = j - h) {
					nums[j] = nums[j - h];
				}
				nums[j] = temp;
			}
		}
		/*
		 * while(h < border/3){ //增量h不能大于数组容量的三分之一，否则此间隔下没有三个元素，无法插入排序 h = 3 * h
		 * + 1; } for(;h > 0; h = (h-1)/3 ){ for(i = h; i < nums.length; i++){
		 * temp = nums[i]; for(j = i; j > h - 1 && temp <= nums[j-h]; j = j -
		 * h){ nums[j] = nums[j-h]; } nums[j] = temp; } }
		 */

	}

	/**
	 * 快速排序： 找一个中介节点，一般是最后一个或第一个，使得比中介节点小的元素在左面，比中介节点大的元素在右面，然后再递归这两组数据。。。。
	 * 快速排序法是最流行的排序算法，平均是o(N*logN)，最坏是o(n^2)。空间复杂度：o（nlogn）,不稳定
	 * 快速排序算法当被划分的左右两个数组元素个数相同时，为最优；当数组为逆序排列时，为最坏情况，被分的左面数组为所有，没有面数组为0。此时为o(n^2)
	 * 。
	 * 
	 * @param nums
	 */
	public void quickSort(int a[], int start, int end) {
		if ((a == null) || (a.length == 0))
			return;
		if (end - start <= 1)
			return;
		//选择中介节点，第一个元素
		int x = a[start];
		int p1 = start;
		int p2 = end;
		boolean dr = true; // 查找方向

		L1: while (p1 < p2) {
			//由于中介节点选第一个元素，那么必须从后往前开始遍历
			if (dr) {
				for (int j = p2; j > p1; j--) {
					if (a[j] <= x) {
						a[p1++] = a[j];
						p2 = j;
						dr = !dr;
						continue L1;
					}
				}
				p2 = p1;
			} else {
				for (int i = p1; i < p2; i++) {
					if (a[i] >= x) {
						a[p2--] = a[i];
						p1 = i;
						dr = !dr;
						continue L1;
					}
				}
				p1 = p2;
			}
		}
		//此时p1==p2
		a[p1] = x;
		quickSort(a, start, p1-1);
		quickSort(a, p1 + 1, end);
	}

	public String toString() {
		return Arrays.toString(nums);
	}

	/**
	 * 堆排序，最差、平均、最好o(N*logN),比快速排序算法略慢，但是对初始数据的分布不敏感，当初始数据为逆序时，快速排序算法降到o(N^2)，
	 * 而堆排序仍然是o(N*logN)。 
	 * 堆：一个完全二叉树，除叶子节点外，非叶子节点一定会有两个孩子。父亲大于（或小于）子节点，这两个子节点的大小没有任何关系。所以堆顶元素一定是最大的（或最小的）。如果把堆顶元素拿出，堆低最后一个元素切换位置重新组建堆。再次拿出堆顶元素。。。以此类推就是堆排序 
	 * 
	 * 正常情况下，一个树的结构，应该使用链式结构，一个node有leftChildNode、rightChildNode、value这三个属性，通过引用指向完成一个树的结构。
	 * 但是堆这个结构是为了堆排序而存在，所以可以使用从上到下、从左到右的遍历方式，依次把树的元素放入数组中。由数组表示一个堆树。
	 * 已知子节点，那么父节点：（k-1）/2
	 * 已知父节点, 那么左孩子：2k+1 ， 右孩子：2k+2
	 * 
	 * 堆的最大(小)值总是根节点，把根节点删除后，再取堆的根节点，总之，每次删除根节点，就是从大（小）到小（大）的排序。
	 * 步骤： 
	 * 1. 把当前乱序的数组（普通完全二叉树）组建成堆
	 * 2.把堆顶第0个元素拿出暂存，堆低最后一个元素（数组最后一个元素）拿出来放到堆顶，这就破坏了堆的原则，所以开始调整：如果这个堆顶元素大于两个孩子，那就和最小的那个孩子交换位置；如果只大于一个孩子，那就跟这个孩子交换，如果比两个孩子都小，那说明现在结构还是一个堆，无需调整。
	 * 3.如果第#2步骤进行了调整换位置，那么就需要继续看这个堆顶元素换到孩子之后，和后面的孩子是否存在大小关系，重复#2，直到如果比两个孩子都小，那说明现在结构还是一个堆，无需调整。
	 * 4. 把堆顶第0个元素拿出暂存，其余元素重新组建堆。然后把第0个元素放在数组最后，以此类推
	 * 
	 * 为了另开辟内存空间，将对顶第0个元素弹出后，直接放入数组最后一个元素。
	 * 
	 * 堆排序很快，只是开始需要先组建堆，然后依次弹出堆顶元素，不停地重新组建堆，再弹出堆顶元素，直到堆中只剩一个元素，直接弹出即可。
	 */
	public static void heapSort(int[] data) {
		//建立初始堆
		//(data.length - 1)/2表示最后一个节点的父节点，也就是最后一个非叶子节点
		for(int i = (data.length - 1)/2; i >= 0; i--){
			//传参：堆的有效长度，和要调整的元素
			heapOne(data,data.length,i);
		}
		int n = data.length;
		//逐次弹出堆顶元素
		while(n > 0){
			System.out.println(data[0] + "");
			int top = data[0];
			data[0] = data[n-1];
			n--;
			//为了把从堆顶弹出来的元素再放回数组的尾部，这样就避免的再开辟一个新数组去装弹出来的元素了
			//所以，如果是从小到大排序，就要建立堆顶元素是最大元素的堆，这样堆顶元素弹出，放到数组的末尾，当堆的最后一个元素出堆的时候，也就是放在第一个元素上，就是从小到大的排序了
			data[n] = top;
			heapOne(data,n,0);
		}
	}

	/**
	 * 
	 * @param data 
	 * @param n 堆中的有效数据个数
	 * @param k 待筛选节点
	 */
	private static void heapOne(int[] data, int n, int k) {
		//这个节点的左孩子
		int k1 = 2 * k + 1;
		//这个节点的右孩子
		int k2 = 2 * k + 2;
		//已经是叶子节点了
		if(k1 >= n && k2 >= n){
			return;
		}
		
		int a1 = Integer.MAX_VALUE;
		int a2 = Integer.MAX_VALUE;
		//左孩子的值
		if(k1 < n){
			a1 = data[k1];
		}
		//右孩子的值
		if(k2 < n){
			a2 = data[k2];
		}
		//符合堆
		if(data[k] <= a1 && data[k] <= a2){
			return;
		}
		//找到左子树中孩子最小的，与它互换位置
		if(a1<a2){
			int t = data[k];
			data[k] = data[k1];
			data[k1]=t;
			heapOne(data, n, k1); //继续筛选子树
		}else{
			int t = data[k];
			data[k] = data[k2];
			data[k2] = t;
			heapOne(data,n,k2);
		}
		
	}

	

	
}
