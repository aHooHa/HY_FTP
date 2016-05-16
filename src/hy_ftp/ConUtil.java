package hy_ftp;



import java.io.FileInputStream;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConUtil {
	
	
	
	public static void getCon(String path,int port,String filepath){
		try {
			Socket sk = new Socket(path,port);
			 
			 FileInputStream fos = new FileInputStream(filepath);
			 PrintWriter pw =null;
			 char[] buf = new char[1024];
			 int temp=0;
			 while((temp = fos.read())>0){
				 pw = new PrintWriter(sk.getOutputStream());
				 pw.write(buf,0,temp);
				 pw.flush();
			 }
			 
			 pw.close();
			 fos.close();
			 sk.close();	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
