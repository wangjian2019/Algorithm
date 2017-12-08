package recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Triangle {   //用递归大都使用if-else

	int row;
	int aggregate;;
	
	Triangle(int row){
		this.row = row;
	}

	public static int addition(int row) { //递归写代码与执行代码相反的过程
		int totol = 0;
		if(row == 1){           // 无论是几个数的累加，一定是从1开始加。
			return 1;  
		}else{
			return addition(row - 1) + row;  //第二步一定是在第一步的基础上从2开始加
			//return addition(row - 1) * row;  阶乘
		}
	}

}
