package cn.edu.xidian.iii.util;

public class  IsChinese {  
	
	  
    //  GENERAL_PUNCTUATION �ж����ĵġ���  
  
    //  CJK_SYMBOLS_AND_PUNCTUATION �ж����ĵġ���  
  
    //  HALFWIDTH_AND_FULLWIDTH_FORMS �ж����ĵģ���  
	
	 public IsChinese(){
		 
	 }
	 
	 
    public static boolean isChineseChar(char c) {  
  
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);  
  
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS  
  
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS  
  
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A )
                /*|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION  
  
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION  
  
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS)*/ 
        {  
  
            return true;  
  
        }  
  
        return false;  
  
    }  
  
  
  
    public  static boolean isChineseString(String str) {  
  
        char[] ch = str.toCharArray();  
        
        for (int i = 0; i < ch.length; i++) {  
  
            char c = ch[i];  
  
            if (isChineseChar(c) == false)   return false;
   
        }  
        return true;
  
    }  
}