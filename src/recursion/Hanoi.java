package recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Hanoi {
	int towers;
	
	public Hanoi() {
		
	}

	public void doTowers(int towers, char from, char inter, char to) {  //递归是一个写代码与执行代码相反的过程，
		if(towers == 1){                      //无论有几个盘子，第一步一定是把第一个最小的盘子房子C柱子上。                              
			System.out.println("Disk 1 from " + from + "  to  " + to);
		}else{
			doTowers(towers - 1,from, to, inter);  //第二部一定是在第一步的基础上把第二个盘子放在B柱子上
			System.out.println("Disk  " + towers +  "  from  " + from + "  to  " + to);
			doTowers(towers - 1,inter, from, to);
		}
		
	}

	public int getTowers(){
		String str = null;
		int temp = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		temp = Integer.parseInt(str);
		return temp;
	}
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
		hanoi.towers = hanoi.getTowers();
		hanoi.doTowers(hanoi.towers, 'A', 'B', 'C');
		
		Triangle triangle = new Triangle(13);
		triangle.aggregate = triangle.addition(triangle.row);
		System.out.print(triangle.aggregate);
	}
}
