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

	// public boolean isValidEmailAddr(String emailAddr) {
    //     if (emailAddr == null || emailAddr.isEmpty() || emailAddr.length() < 5) {
    //         return false;
    //     }
    //     String regex = "^[a-zA-Z][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    //     return emailAddr.trim().matches(regex);
    // }
	
	// emailAddr.trim()
// 调用 trim() 方法去除字符串两端的空格，确保输入的电子邮件地址没有多余的空白字符。
// .matches(regex)

// 使用 matches() 方法将去除空格后的电子邮件地址与正则表达式 regex 进行匹配。
// 如果电子邮件地址符合正则表达式的规则，则返回 true；否则返回 false。
	public boolean isValidEmailAddr(String emailAddr) {
		// 检查电子邮件地址是否为 null、空字符串或长度小于 5。
		if (emailAddr == null || emailAddr.isEmpty() || emailAddr.length() < 5) {
			return false;
		}
		// 找到 @ 符号的位置，并确保它存在且不在字符串的开头或结尾。
		emailAddr = emailAddr.trim();
		int atIndex = emailAddr.indexOf('@');
		if (atIndex == -1 || atIndex == 0 || atIndex == emailAddr.length() - 1) {
			return false;
		}
		// 分离本地部分和域名部分。
		String localPart = emailAddr.substring(0, atIndex);
		String domainPart = emailAddr.substring(atIndex + 1);
	
		if (localPart.isEmpty() || domainPart.isEmpty()) {
			return false;
		}
	
		if (!Character.isLetter(localPart.charAt(0))) {
			return false;
		}
		// 检查本地部分是否以字母开头，并且只包含字母、数字、.、_、%、+ 和 -。
		for (char c : localPart.toCharArray()) {
			if (!Character.isLetterOrDigit(c) && c != '.' && c != '_' && c != '%' && c != '+' && c != '-') {
				return false;
			}
		}
		// 检查域名部分是否包含有效的点号，并且点号不在开头或结尾。
		int dotIndex = domainPart.lastIndexOf('.');
		if (dotIndex == -1 || dotIndex == 0 || dotIndex == domainPart.length() - 1) {
			return false;
		}
	
		String domainName = domainPart.substring(0, dotIndex);
		String domainSuffix = domainPart.substring(dotIndex + 1);
		// 检查域名名称和后缀是否有效，并且后缀长度至少为 2。
		if (domainName.isEmpty() || domainSuffix.isEmpty() || domainSuffix.length() < 2) {
			return false;
		}
		// 确保域名部分只包含字母、数字、. 和 -。
		for (char c : domainPart.toCharArray()) {
			if (!Character.isLetterOrDigit(c) && c != '.' && c != '-') {
				return false;
			}
		}
	
		return true;
	}
// example123@domain.com
	
}
// 使用正则表达式 ^[a-zA-Z][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$ 验证电子邮件地址格式：
// ^[a-zA-Z] 确保首字符是英文字母。
// [a-zA-Z0-9._%+-]* 允许后续字符为字母、数字、下划线、点、百分号、加号或减号。
// @[a-zA-Z0-9.-]+ 确保包含一个“@”符号，并且“@”后面至少有一个字符。
// \\.[a-zA-Z]{2,}$ 确保至少有一个“.”，并且“.”后面至少有两个字母

