package hy_ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDUtil {
	
	/**
	 * 
	 * @param file
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String getMD5(File file) throws NoSuchAlgorithmException {
		return get(file, "MD5");
	}

	/**
	 * 
	 * @param file
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public static String getSHA(File file) throws NoSuchAlgorithmException {
		return get(file, "SHA-1");
	}

	/**
	 * 
	 * 
	 * @param file
	 * @return
	 */
	private static String get(File file, String algorithm) throws NoSuchAlgorithmException {
		

		try {
//			MessageDigest md = MessageDigest.getInstance(algorithm);
//			byte [] buf = file.getBytes();
//			byte[] result =md.digest(buf);
//
//			// System.out.println(result.length);
//			// System.out.println(Arrays.toString(result));
//
//			BigInteger b = new BigInteger(1, result);
//			// System.out.println(b.toString());
//
//			String m = b.toString(16);
//		
//			
//			return m;
			  String value = null;  
	            FileInputStream in = new FileInputStream(file);  
	        try {  
	            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY,
	            		                                                       0, file.length());  
	            MessageDigest md5 = MessageDigest.getInstance(algorithm);  
	            md5.update(byteBuffer);  
	            BigInteger bi = new BigInteger(1, md5.digest());  
	            value = bi.toString(16);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        } finally {  
	                if(null != in) {  
	                    try {  
	                    in.close();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	        return value;  

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return null;
	}

}
