package hy_ftp;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MDUtil {
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	public static String getMD5(String filename) {
		return get(filename, "MD5");
	}

	/**
	 * 
	 * @param file
	 * @return
	 */
	public static String getSHA(String file) {
		return get(file, "SHA-1");
	}

	/**
	 * 获得文件的 MD5 值
	 * 
	 * @param file
	 * @return
	 */
	private static String get(String file, String algorithm) {
		
		// TODO file 转换成 byte[]

		// 函数包
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte [] buf = file.getBytes();
			byte[] result =md.digest(buf);

			// System.out.println(result.length);
			// System.out.println(Arrays.toString(result));

			// 字节数组转化为十六进制数
			BigInteger b = new BigInteger(1, result);
			// System.out.println(b.toString());

			// 整数转换成字符串：数制系统
			String m = b.toString(16);
		
			
			return m;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}

}
