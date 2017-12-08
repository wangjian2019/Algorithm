package recursion;
import java.util.Arrays;


public class CharFullArray {
	char[] string;
	int border;
	
	CharFullArray(int biorder){
		this.border = border;
		string = new char[border];
	}
	/**
	 * 1.全排列右面的length-1个字母
	 * 2.字符串左右字符左移，第一个字符到最后位置。
	 * 3.重复第一步
	 * @param size
	 */
	public void doFullArray(int size){   //，改变第一个字母n次
		if(size == 1){
			System.out.print(Arrays.toString(string));
			return;
		}else{
			for(int i = 0; i < size; i++){     //第一个字符不变，其他的字符全排列，共需要border次循环
				doFullArray(size - 1);//递归，把第一个不变的字符拿出去，对剩下的border-1个字符进行递归 
				if(size == 2){
					System.out.print(Arrays.toString(string));
				}
				rotate(size);
			}
		}
	}
	private void rotate(int size) {
		int j;
		int position = border - size;
		char temp = string[position];
		for(j = position + 1; j < border; j++){
			string[j-1] = string[j];
		}
		string[j-1] = temp;
		
		
	}
}
