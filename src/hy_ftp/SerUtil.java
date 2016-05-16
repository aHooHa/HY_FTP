package hy_ftp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SerUtil {
	
	public static void getser(int port) throws IOException{
	 File file = new File("d://ftp");
	 ServerSocket sk = new ServerSocket(port);
	 Socket s = sk.accept();
	 
	 BufferedReader br1 = new BufferedReader(new InputStreamReader(s
				.getInputStream()));
	 String date =br1.readLine();
	 File src = new File("date");
	 
	 FileUtil.cp(src, file);
	 
	
	 while(date != null){
	 
	 FileOutputStream fis = new FileOutputStream(file,true);
	 byte[] buf = new byte[(int)file.length()];
	 fis.write(buf);
	 date = br1.readLine();
	 }
	 s.close();
	 sk.close();
	}
}
