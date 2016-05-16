package hy_ftp;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConUtil {
	public static void getCon(String path,int port){
		try {
			System.out.println("ooooo");
			Socket sk = new Socket(path,port);
			System.out.println("显示");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
