package recursion;

import java.io.File;
import java.util.List;

/**
 * 递归某个文件夹下所有文件
 * @author Administrator
 *
 */
public class FileUtils {

	public static void main(String[] args) throws Exception {
		// 递归显示C盘下所有文件夹及其中文件
		File root = new File("c:");
		showAllFiles(root);
	}

	public static void showAllFiles(File dir) throws Exception {
		File[] fs = dir.listFiles();
		for (int i = 0; i < fs.length; i++) {
			System.out.println(fs[i].getAbsolutePath());
			if (fs[i].isDirectory()) {
				try {
					showAllFiles(fs[i]);
				} catch (Exception e) {
				}
			}
		}
	}
}
