package hy_ftp;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SerUtil {

	public static void getser(int port) throws IOException {
		DataInputStream input = null;
		DataOutputStream output ;
		BufferedWriter bw ;
		BufferedReader br ;
		DataOutputStream fis ;
		
		ServerSocket sk = null;
		Socket s = null;
		try {
			sk = new ServerSocket(port);
			 s = sk.accept();
			input = new DataInputStream(s.getInputStream());
			output = new DataOutputStream(s.getOutputStream());
			
			File file1 = new File("D:\\ftp\\len.txt");
		     bw = new BufferedWriter(new FileWriter(file1, true));
			br = new BufferedReader((new FileReader(file1)));
			
			String len =input.readUTF();
			String filelen = br.readLine();
			boolean flag =true;
			while( filelen != null){
				if(filelen.equals(len)){
					output.writeUTF("Ãë´«");
				    output.flush();
				    output.close();
				    br.close();
				    bw.close();
				    flag =false;
				}
				filelen = br.readLine();
			}
			if(flag){
				
			output.writeUTF("XX");
			output.flush();
			
			bw.write(len);
			bw.newLine();
			bw.flush();
		
			String filename = input.readUTF();

			File file = new File("D:\\ftp\\" + filename);
			byte[] buf = new byte[8192];
			fis = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
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
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
			 input.close();
			 s.close();
			 sk.close();
		}
	}
}
