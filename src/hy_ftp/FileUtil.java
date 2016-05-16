package hy_ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {
	public static void cpFile(File src, File dest) throws IOException {

		long time = System.currentTimeMillis();

		if (!src.exists()) {
			// 中断后面的流程
			throw new FileNotFoundException();
		}

		// 打开输入流从源读取数据
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dest);

		byte[] buf = new byte[1024 * 16];
		int length;
		while (-1 != (length = in.read(buf))) {
			out.write(buf, 0, length);
		}

		in.close();
		out.close();

		time = System.currentTimeMillis() - time;
		System.out.println(time);
	}

	/**
	 * 复制目录
	 * 
	 * @param src
	 *            源目录
	 * @param dest
	 *            目标目录
	 * @throws IOException 
	 */
	public static void cp(File src, File dest) throws IOException {
		
		if (src.isFile()) {
			// 文件的复制
			cpFile(src, new File(dest, src.getName()));
		} else {
			// 在目标文件夹，新建一个与源码文件夹同名的文件夹
			File path = new File(dest, src.getName());
			path.mkdir();
			
			// 复制目录
			File[] files = src.listFiles();
			
			// 遍历文件
			for (File f : files) {
				if (f.isDirectory()) {
					// 递归
					cp(f, path);
				} else {
					// 文件
					cpFile(f, new File(path, f.getName()));
				}
			}
		}
	}
}
