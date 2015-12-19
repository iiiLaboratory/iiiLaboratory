package cn.edu.xidian.iii.util;

public class CheckStyle {
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
	public static boolean checkStringStudentnum(String number ){
		if(checkStringLength(number,11)==0||checkStringLength(number,8)==0)
			return true;
		return false;
	}
}
