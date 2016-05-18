package hy_ftp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConUtil {

	public static void getCon(String path, int port, String filepath) {
		try {

			Socket sk = new Socket(path, port);
			File f = new File(filepath);

			// 鍐欐枃浠跺悕瀛�
			PrintWriter pw = new PrintWriter(sk.getOutputStream());
			pw.println(f.getName());
			pw.flush();

			// 璇绘枃浠�
			BufferedReader bis = new BufferedReader(new FileReader(f));
			String str = bis.readLine();
			while (str != null) {
				// 鍐欐枃浠�
				pw.println(str);
				pw.flush();
				str = bis.readLine();
			}
			bis.close();
			pw.close();
			sk.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
