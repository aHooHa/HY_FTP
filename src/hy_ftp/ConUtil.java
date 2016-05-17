package hy_ftp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConUtil {

	public static String getCon(String path, int port, String filepath) {
		try {
			
			Socket sk = new Socket(path, port);
			
			File f = new File(filepath);
			PrintWriter pw = new PrintWriter(sk.getOutputStream());
			
			String md = MDUtil.getMD5(f.getName());
			pw.println(md);
			pw.flush();
			
			BufferedReader br6 = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			String date2 = br6.readLine();
			if (date2.equals("miaochuang")) {
				br6.close();
				sk.close();
				return date2;
			}

			pw.println(f.getName());
			pw.flush();
			InputStream put = new FileInputStream(f);
			BufferedReader input = new BufferedReader(new InputStreamReader(put));

			String sa = input.readLine();
			while (sa != null) {
				pw.println(sa);
				pw.flush();
				sa = input.readLine();
			}

			pw.close();
			input.close();
			put.close();
			sk.close();
			return date2;
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
