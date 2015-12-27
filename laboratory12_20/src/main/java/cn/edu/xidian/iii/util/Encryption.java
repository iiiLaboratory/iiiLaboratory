package cn.edu.xidian.iii.util;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Encryption {
		public static final String KEY_MD5="MD5";
		public static final String KEY_SHA="SHA";
		//SHA加密
		public static String encryptSHA(String data) throws Exception {
			String inter =data+"@!jh&%";
			MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
			byte[] byteArray = inter.getBytes("UTF-8");
			sha.update(byteArray);
			BigInteger sha2 = new BigInteger(sha.digest());
			return  sha2.toString(32);
		}
		//MD5加密
		public static String encryptMD5(String data) throws Exception {
			String inter =data+"@!sdf&sd";
			MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
			byte[] byteArray = inter.getBytes("UTF-8");
			md5.update(byteArray);
			BigInteger md52 = new BigInteger(md5.digest());
			return md52.toString(32);
			
		}
	}

