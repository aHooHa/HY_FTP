package hy_ftp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
	 
	 FileOutputStream fout = new FileOutputStream(file,true);
	 byte[] buf = new byte[1024];
	 while(date !=null){
		 fout.write(buf);
		 fout.flush();
	 }
	 fout.close();
	 s.close();
	 sk.close();
	}
}
