package hashtable;
/**
 * 哈希表是一种数据结构，提供快速的插入与查找，无论哈希表中有多少数据，插入与查找都是o(1)。优点：速度！！！
 * 哈希函数（哈希化）：关键字-->数组下标（6，453，242342这类大范围的数字间，哈希化后压缩到很小的范围内。例453%9）
 * 冲突：多个关键字哈希化后对应到一个数组下标。（开放地址法，链地址法）(哈希数组应是元素总量的两倍)
 * 开放地址法（线性探测，二次探测，再哈希法）：
 * 线性探测：哈希后位置是8，8被占，用9，就被占，用10。。。。。。。（坏处：容易产生元素聚集）
 * 二次探测：哈希后位置是8，8被占，用8+1^2，9就被占，用8+2^2。。。。。。。
 * 再哈希法：第一次哈希化位置被占用之后，用第二个哈希函数再次哈希
 * 链地址法：在哈希表的每个元素中设置链表，一旦位置被占，就链下去，因为每个位置都是一个链表（Node节点类，Link链表类，哈希表类：Link[]）
 * 哈希表缺点：基于数组，难于扩展，一旦超越界限就崩溃。
 * 
 * 
 * 
 * 马士兵的HashTable，定义一个链表数组，每个数组元素是一个链表，存到重复的值时就往链表后放
 * @author Administrator
 *
 */
public class HashTable {
	int[] dataItem;
	int border;
	
	HashTable(int border){
		this.border = border;
		dataItem = new int[border];
		
	}
	
	public int hashFunction(int data){
		return data%border;
	}
	
	public void insert(int data){
		int key = hashFunction(data);
		while(dataItem[key] != 0){
			key++;
			if(key >= border){
				key = 0;
			}
		}
		dataItem[key] = data;
	}

	public int find(int data){
		int key = hashFunction(data);
		while(dataItem[key] != 0){
			if(dataItem[key] == key){
				int temp = dataItem[key];
				return temp;
			}
			key++;
			if(key >= border){
				key = 0;
			}
		}
		return -1;
	}
	
	public int delete(int data){
		int key = hashFunction(data);
		while(dataItem[key] != 0){
			if(dataItem[key] == key){
				int temp = dataItem[key];
				dataItem[key] = 0;
				return temp;
			}
			key++;
			if(key >= border){
				key = 0;
			}
		}
		return -1;
	}
}
