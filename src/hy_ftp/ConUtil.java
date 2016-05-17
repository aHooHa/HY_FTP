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
	
	
	
	public static void getCon(String path,int port,String filepath){
		try {
			Socket sk = new Socket(path,port);
			File f = new File(filepath);
			InputStream put = new FileInputStream(f);
			BufferedReader input = new BufferedReader(new InputStreamReader(put));
			
			String sa =input.readLine();
			PrintWriter pw = new PrintWriter(sk.getOutputStream());
			
			while(sa != null){
				pw.println(sa);
				pw.flush();
				sa = input.readLine();
			}
			 
			 pw.close();
			 input.close();
			 put.close();
			 sk.close();	
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
