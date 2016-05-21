package hy_ftp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConUtil {

	public static void getCon(String path, int port, String filepath) {
		try {

			Socket sk = new Socket(path, port);
			File f = new File(filepath);
			
			 DataInputStream fis = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));  
             DataOutputStream ps = new DataOutputStream(sk.getOutputStream()); 
             
             ps.writeUTF(f.getName());
             ps.flush();


             int bufferSize = 8192;  
             byte[] buf = new byte[bufferSize];  
            
             while (true) {  
            	 int read = 0;
                 if (fis != null) {  
                     read = fis.read(buf);  
                 }  

                 if (read == -1) {  
                     break;  
                 }  
                 ps.write(buf, 0, read);  
             }  
             ps.flush();  
             fis.close();
             ps.close();
             sk.close();     

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
