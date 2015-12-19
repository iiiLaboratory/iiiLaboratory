package cn.edu.xidian.iii.util;
public class NumMatches {
	
	public NumMatches(){}
	public static  boolean phoneFormatMatches(String str){
		String regex="[1]\\d{10}";  //��������1��ͷ���10λ����
		if(str.matches(regex)) return true;
		
		return false;
	}
	
	public static boolean lengthMatches(String str ,int n){
		
		if(str.length()<=n)  return true;
		
		 return false;
	}
	
	
}
