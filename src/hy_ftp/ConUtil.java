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

	public static String getCon(String path, int port, String filepath) {
		Socket sk = null;
		 DataInputStream fis = null;
		  DataOutputStream ps = null ;
		  DataInputStream input;
		
		try {

			sk = new Socket(path, port);
			File f = new File(filepath);
			
			 fis = new DataInputStream(new BufferedInputStream(new FileInputStream(f)));  
             ps = new DataOutputStream(sk.getOutputStream()); 
             input = new DataInputStream(sk.getInputStream());
             
             
             String len =MDUtil.getMD5(f.getName());
             ps.writeUTF(len);
             ps.flush();
             
             
             String miao = input.readUTF();
             if(miao.equals("秒传")){
            	 input.close();
            	 ps.close();
            	 fis.close();
            	 return miao;
             } 
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
                 

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			 try {
				ps.flush();
				 fis.close();
	             ps.close();
	             sk.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            
		}
		
		return "上传成功";
		
		
		
	}
}
