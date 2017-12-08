package algorithm.easy_algorithm;
import java.io.*;
import javax.swing.JOptionPane;
/**
 * 杨辉三角的两种表现形式
 * @author Administrator
 *
 */
public class YangHuiTriangle {

	public static void main(String[] args) {
		int row = 8;
		int[][] result = new int[row][row];
		for (int i = 0; i < row; i++) { // 行
			result[i][0] = 1;
			System.out.print(result[i][0] + "\t");
			for (int j = 1; j <= i; j++) { // 列
				result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
				System.out.print(result[i][j] + "\t");
			}
			System.out.println();
		}
		printYangHuiTriangle();
	}

	public static void printYangHuiTriangle() {
		int k, j, h, row, center = 40, m = 0, space = 0;   //杨辉三角第一行开始向右推center个空格，以防止row较大时放不下。
		final int ROW = 15;// 限制三角形的最大行数
		String str = JOptionPane.showInputDialog(null, "请输入行数(<15)：", "打印杨辉三角形", JOptionPane.QUESTION_MESSAGE);
		row = Integer.parseInt(str);
		if (15 <= row) {
			JOptionPane.showMessageDialog(null,"本程序目前设置仅能够打印14行，若需打印15行以上者请与xlove联系。", "",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		} else if (0 >= row){
			JOptionPane.showMessageDialog(null, "0行及以下的杨辉三角形是没有意义的。", "",JOptionPane.INFORMATION_MESSAGE);
		}else {
			for (k = 1; k <= center; k++){  //打出center个空格
				System.out.print(" ");
			}	
			System.out.println(1); 
		}
		int y[][] = new int[ROW][ROW];
		for (k = 1; k <= row - 1; k++) { //k从1开始，因为第一行的1已经打出了
			m = center - 2 * k;// 每行前面的空格数
			y[k][1] = 1;
			for (j = 1; j <= m; j++)
				System.out.print(" ");// 输出每行开头的空格数
			System.out.print(1);
			for (j = 1; j <= k; j++) {
				y[k + 1][j + 1] = y[k][j + 1] + y[k][j];
				if (y[k + 1][j + 1] < 10)
					space = 3;// 当数字小于10时空格数
				else
					space = 2;// 当数字大于10时空格数
				for (h = 1; h <= space; h++)
					System.out.print(" ");// 输出空格数
				System.out.print(y[k + 1][j + 1]);
			}
			System.out.println();
		}

	}
}
