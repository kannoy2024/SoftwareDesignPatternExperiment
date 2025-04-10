/*---------------------------------------------------------*/
/* This adapter class extends InfoValidation and           */
/* implements CusInfoValidator, and so the first           */
/* 4 functionalities listed in class CusInfoValidator      */
/* are automatically inherited from class InfoValidation,  */
/* and in this addapter class, isValidSSNNum(String SSNNum)*/
/* is emplemented.                                         */
/*---------------------------------------------------------*/
package cn.edu.bbc.computer;


class InformationAdapter extends InfoValidation implements CusInfoValidator{

    /*------------------------------------------*/
	/* The Social Security number is a 9-digit  */
	/* number in the format "AAA-GG-SSSS".      */
	/*------------------------------------------*/
	public boolean isValidSSNNum(String SSNNum){
	   boolean isValid=true;
       String ns = SSNNum.trim();
	   String nStr = ns.replaceAll("\\s{1,}", "");
	   int len = nStr.length();

	   if ( (nStr.charAt(3) == '-') && (nStr.charAt(6) == '-') && (len==11) ) {
	      for(int m=0; m<len; m++){
		     if(  (m != 3) && (m !=6) && ( Character.isDigit(nStr.charAt(m))==false) ){
		        isValid=false;
		     }
	      }
	      return isValid;
	   }
	   else{
		  return false;
	   }
	}




	// public boolean isValidSSNNum(String SSNNum) {
    //     if (SSNNum == null || SSNNum.isEmpty()) {
    //         return false;
    //     }
    //     String regex = "^\\d{3}-\\d{2}-\\d{4}$";
    //     return SSNNum.trim().matches(regex);
    // }

	public boolean isValidEmailAddr(String emailAddr) {
        if (emailAddr == null || emailAddr.isEmpty() || emailAddr.length() < 5) {
            return false;
        }
        String regex = "^[a-zA-Z][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return emailAddr.trim().matches(regex);
    }
// example123@domain.com
	
}
// 使用正则表达式 ^[a-zA-Z][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$ 验证电子邮件地址格式：
// ^[a-zA-Z] 确保首字符是英文字母。
// [a-zA-Z0-9._%+-]* 允许后续字符为字母、数字、下划线、点、百分号、加号或减号。
// @[a-zA-Z0-9.-]+ 确保包含一个“@”符号，并且“@”后面至少有一个字符。
// \\.[a-zA-Z]{2,}$ 确保至少有一个“.”，并且“.”后面至少有两个字母

