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
	
	public static void getser(int port) throws IOException{
	 File file = new File("d:\\ftp\\text.txt");
	 ServerSocket sk = new ServerSocket(port);
	 Socket s = sk.accept();
	 BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	 String date =br.readLine();
	 BufferedWriter br3 = new BufferedWriter(new FileWriter(file,true));
	 while(date != null){
		 br3.write(date);
		 br3.flush();
		 date =br.readLine();
	 }
	 br3.close();
	 br.close();
	 s.close();
	 sk.close();
	}
}
