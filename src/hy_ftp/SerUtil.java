package hy_ftp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class SerUtil {

	public static void getser(int port) throws IOException {

		ServerSocket sk = new ServerSocket(port);
		Socket s = sk.accept();
		
		
		HashMap<String, String> textfilename = new HashMap<>();
		BufferedReader br;
		BufferedWriter br3 = null;
		PrintWriter pw;
		File file;

		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String date2 = br.readLine();
		
		if (textfilename.containsKey(date2)) {
			pw = new PrintWriter(s.getOutputStream());
			pw.println("miaochuang");
			pw.flush();
			pw.close();
		} else {
			pw = new PrintWriter(s.getOutputStream());
			pw.println("shangchuang");
			pw.flush();
			String date1 = br.readLine();
			textfilename.put(date2, date1);
			file = new File("d:\\ftp\\" + date1);
			date1 = br.readLine();
			br3 = new BufferedWriter(new FileWriter(file, true));
			while (date1 != null) {
				br3.write(date1);
				br3.flush();
				date1 = br.readLine();
			}

		}

		br3.close();
		pw.close();
		br.close();
		s.close();
		sk.close();
	}
}
