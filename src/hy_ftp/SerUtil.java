package hy_ftp;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SerUtil {

	public static void getser(int port) throws IOException {

		ServerSocket sk = new ServerSocket(port);
		Socket s = sk.accept();

		DataInputStream input = new DataInputStream(s.getInputStream());
		String filename = input.readUTF();

		File file = new File("D:\\ftp\\" + filename);
		byte[] buf = new byte[8192];
		DataOutputStream fis = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		 while (true) {  
             int read = 0;  
             if (input != null) {  
                 read = input.read(buf);  
             }  
             
             if (read == -1) {  
                 break;  
             }  
             
             fis.write(buf, 0, read);  
         }  
		 fis.close();
		 input.close();
		 s.close();
		 sk.close();
	}
}
