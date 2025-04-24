public class EncryptedInfo3 implements AgentInfo  {

    @Override
    public String encryptName(String inputStr) {
        // TODO Auto-generated method stub
        throw null;
    }

    @Override
    public String encryptCode(String code) {
        // TODO Auto-generated method stub
        throw null;
    }

    @Override
    public void log(String lastNm, String firstNm, String code) {
        // TODO Auto-generated method stub
        throw null;
    }
    private boolean checkString(String code){
        for(int i=0; i<code.length(); i++)
        if(Character.isDigit(code.charAt(i))||Character.isLetter(code.charAt(i))){
            continue;
        }else{
            return false;
        }
        return true;
    }


    private String encryptString(String strString){
        char[] strChar= strString.toCharArray();
        for (int i=0; i<strChar.length; i++){
            if ((strChar[i]== '0'&& strChar[i]<'9')||
             (strChar[i]=='a'&& strChar[i]<'z')||
             ( strChar[i]=='A'&& strChar[i]<'Z')) {
                strChar[i]=(char)(Integer.valueOf(strChar[i])+1);
            }else if (strChar[i]=='9'){
                strChar[i]='0';
            }else if(strChar[i]=='z'){
                strChar[i]='a';
            }else if (strChar[i]=='Z'){
                strChar[i]='A';
            }
        }
        // return strChar.toString();
        return new String(strChar);
    }

}
