package cn.edu.xidian.iii.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckString {
	public static int checkStringLength (String number,int num ) {
		int i = 0;
		if (number.length()==num && number.matches("[0-9]+")) {
			return i;//是格式正确的一卡通号
		}else if (number.length()!=num && number.matches("[0-9]+")) {
			return i=1;//是纯数字但是位数不够
		}
		else if ((!number.matches("[0-9]+")) && number.length() == 11) {
			return i=2;//位数够但不是纯数字 
		}
		else {
			return i=3;//位数不够 也不是纯数字
		}
	}
	
	/**检查学号或者手机号格式*/
	public static boolean checkStudentnum(String number ){
		if(checkStringLength(number,11)==0||checkStringLength(number,8)==0)
			return true;
		return false;
	}
	
	/**检查是否为纯数字*/
	public static boolean  isNumber(String number){
	   if(number.matches("[0-9]+"))
		   return true;
	   return false;
   }
	
	/**检查密码位数*/
	public static boolean checkPassword(String password){
	   
	   if (password.length()>5 && password.length()<17) {
		return true;
	   }else {
		return false;
	   }
	  
   }
	
	/**检查邮箱格式*/
	public static boolean checkEmail(String email) {
	
	   Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
	   Matcher m = p.matcher(email);
	   //Mather m = p.matcher("wangxu198709@gmail.com.cn");这种也是可以的！
	   return  m.matches();
   }
}
