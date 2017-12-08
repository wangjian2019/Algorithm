package leetcode.array;

import java.util.HashSet;

/**
 * Valid Sudoku
 * 
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules
 * http://sudoku.com.au/TheRules.aspx . The Sudoku board could be partially
 * filled, where empty cells are filled with the character '.'.
 * 
 * 题解：依次检查每行，每列，每个子九宫格是否出现重复元素，如果出现返回false，否则返回true. 很容易得到3个规则： 
 * 1. 每一行只能出现1~9一次；
 * 2. 每一列只能出现1~9一次； 
 * 3. 每个3×3子区域只能出现1~9一次（子区域之间没有交叉，也就是一共有9个子区域）
 * 
 * 
 * 这道题利用的是HashSet的唯一性来帮助check。
 * 
 * 先按每行check，如果是'.'说明还没填字，是合法的，往下走，如果没在set中存过就加一下，如果便利过程中出现了在set中存在的key值，
 * 说明有重复的数字在一行，不合法，return false。
 * 再按照这个方法check列。
 * 最后按照这个方法check小方块。
 * 注意小方块的ij取法。对于当前这块板子来说，总共有9个小方格，按0~8从左到右依次编号。
 * 按编号求'/'就是求得当前小方格的第一行横坐标，因为每个小方格有3行，所以循环3次。
 * 按编号求'%'就是求得当前小方格的第一列纵坐标，因为每个小方格有3列，所以循环3次。
 * 对9个小方格依次走一边，就完成了检查小方格的工作。
 * 
 * @author Alvin
 *
 */
public class ValidSudoku {

	public static void main(String[] args) {

	}

	public static boolean isValidSudoku(Character[][] board) {
		HashSet<Character> set = new HashSet<Character>();
		// Check for each row
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				if (set.contains(board[i][j])){
					return false;
				}else{
					set.add(board[i][j]);
				}
			}
			set.clear();
		}

		// Check for each column
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				if (board[i][j] == '.')
					continue;
				if (set.contains(board[i][j])){
					return false;
				}else{
					set.add(board[i][j]);
				}
			}
			set.clear();
		}

		// Check for each sub-grid
		for (int k = 0; k < 9; k++) {
			for (int i = k / 3 * 3; i < k / 3 * 3 + 3; i++) {
				for (int j = (k % 3) * 3; j < (k % 3) * 3 + 3; j++) {
					if (board[i][j] == '.')
						continue;
					if (set.contains(board[i][j])){
						return false;
					}else{
						set.add(board[i][j]);
					}
				}
			}
			set.clear();
		}

		return true;
	}

}
