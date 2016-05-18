package hy_ftp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SerUtil {

	public static void getser(int port) throws IOException {

		ServerSocket sk = new ServerSocket(port);
		Socket s = sk.accept();

		// 读文件名
		BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String filename = br.readLine();

		// 新建文件
		File file = new File("D:\\ftp\\" + filename);
		// 读文件
		BufferedWriter bop = new BufferedWriter(new FileWriter(file, true));
		String str = br.readLine();
		while (str != null) {
			// 写文件
			bop.write(str);
			bop.flush();
			bop.newLine();
			str = br.readLine();
		}
		bop.close();
		br.close();
		s.close();
		sk.close();

	}
}
