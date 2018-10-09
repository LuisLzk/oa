package com.bwf.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * md5 密码加密
 * @author admin
 *
 */
public class StringUtil {
	public static String md5 ( String source ) {          
		StringBuilder sb = new StringBuilder();
		MessageDigest md5;
		try {              
			md5 = MessageDigest.getInstance("MD5");
			md5.update(source.getBytes()); 
			for (byte b : md5.digest()) {
				sb.append(String.format("%02X", b)); 				           
			}             
			return sb.toString();         
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();          
		}          
		return null;      
	}

	
}
