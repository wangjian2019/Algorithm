package algorithm.easy_algorithm;
/**约瑟夫环：
 * 30个人，数9退出（数组表示 ，碰到30返回，用if判断，模拟）
 * 30个人，数9退出（循环链表，每个链节点放boolean类型，和数组相同）
 * @author Administrator
 */
public class Joseph {
	private static  Joseph jj = new Joseph();
	static boolean[] joseph;
	
	private Joseph(){
		joseph = new boolean[30];
	}

	public Joseph getInstance(){
		return jj;
	}
	
	public static void main(String[] args){
		int count = joseph.length;
		int countNum = 0;
		int index = 0;
		for(int i = 0; i < joseph.length; i++){
			joseph[i] = true;
		}
		
		while(count > 0){
			countNum++;
			if(countNum == 9){
				countNum = 0;
				count--;
				joseph[index] = false;
			}
			index++;
			if(index == joseph.length){
				index = 0;
			}
		}
		for (boolean element : joseph){
			System.out.print(element + "            ");
		}
		
		
	}
	
	
}
