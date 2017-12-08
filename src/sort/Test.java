package sort;
import java.util.Arrays;


public class Test {

	public static void main(String[] args){
		Sort sortBubbleSort = new Sort();
		Sort sortSelectionSort = new Sort();
		Sort sortCockTailSort = new Sort();
		Sort sortInsertSort = new Sort();
		Sort sortBinaryInsertSort = new Sort();
		Sort sortMergeSort = new Sort();
		Sort sortShellSort = new Sort();
		Sort sortQuickSort = new Sort();
		Sort sortHeapSort = new Sort();
		
		System.out.println("冒泡排序前：" + sortBubbleSort.toString());
		sortBubbleSort.bubbleSort(sortBubbleSort.nums);
		System.out.println("冒泡排序后：" + sortBubbleSort.toString());
		
		System.out.println("鷄尾酒排序前：" + sortCockTailSort.toString());
		sortBubbleSort.bubbleSort(sortCockTailSort.nums);
		System.out.println("鷄尾酒排序后：" + sortCockTailSort.toString());
		
		System.out.println("选择排序前：" + sortSelectionSort.toString());
		sortSelectionSort.selectionSort(sortSelectionSort.nums);
		System.out.println("选择排序后：" + sortSelectionSort.toString());
		
		System.out.println("插入排序前：" + sortInsertSort.toString());
		sortInsertSort.insertSort(sortInsertSort.nums);
		System.out.println("插入排序后：" + sortInsertSort.toString());
		
		System.out.println("二分插入排序前：" + sortBinaryInsertSort.toString());
		sortBinaryInsertSort.binaryInsertSort(sortBinaryInsertSort.nums);
		System.out.println("二分插入排序后：" + sortBinaryInsertSort.toString());
		
    
		System.out.println("归并排序前：" + sortMergeSort.toString());
		sortMergeSort.mergeSort(sortMergeSort.nums,0,9);
		System.out.println("归并排序后：" + sortMergeSort.toString());
		
		System.out.println("希尔排序前：" + sortShellSort.toString());
		sortShellSort.shellSort(sortShellSort.nums);
		System.out.println("希尔排序后：" + sortShellSort.toString());
		
		System.out.println("快速排序前：" + sortQuickSort.toString());
		sortQuickSort.quickSort(sortQuickSort.nums,0,9);
		System.out.println("快速排序后：" + sortQuickSort.toString());
		
		System.out.println("堆排序前：" + sortHeapSort.toString());
		sortHeapSort.heapSort(sortHeapSort.nums);
		System.out.println("堆排序后：" + sortHeapSort.toString());
	}
}
