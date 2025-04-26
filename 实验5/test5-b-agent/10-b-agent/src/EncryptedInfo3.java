public class EncryptedInfo3 implements AgentInfo {
    private MessageWriter writer;

    public EncryptedInfo3(MessageWriter w) {
        super();
        this.writer = w;
    }

    @Override
    public String encryptName(String inputStr) {
        if (checkString(inputStr)) {
            return encryptString(inputStr);
        } else {
            System.out.println("包含非法字符");
            return null;
        }
    }

    @Override
    public String encryptCode(String code) {
        if (code.length() == 12 && checkString(code)) {
            return encryptString(code);
        } else {
            System.out.println("包含非法字符,或者编码长度不足12");
            return null;
        }
    }

    @Override
    public void log(String lastNm, String firstNm, String code) {
        String lName = encryptName(lastNm);
        String fName = encryptName(firstNm);
        String codeStr = encryptCode(code);

        writer.logMsg(lName, fName, codeStr);
    }

    private boolean checkString(String code) {
        for (int i = 0; i < code.length(); i++)
            if (Character.isDigit(code.charAt(i)) ||
                    Character.isLetter(code.charAt(i))) {
                continue;
            } else {
                return false;
            }
        return true;
    }

    private String encryptString(String strString) {
        char[] strChar = strString.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            if ((strChar[i] >= '0' && strChar[i] < '9') ||
                    (strChar[i] >= 'a' && strChar[i] < 'z') ||
                    (strChar[i] >= 'A' && strChar[i] < 'Z')) {
                strChar[i] = (char) (Integer.valueOf(strChar[i]) + 1);
            } else if (strChar[i] == '9') {
                strChar[i] = '0';
            } else if (strChar[i] == 'z') {
                strChar[i] = 'a';
            } else if (strChar[i] == 'Z') {
                strChar[i] = 'A';
            }
        }
        // return strChar.toString();//使用toString()会输出字符串的引用
        return new String(strChar);
    }
    // private String encryptString(String str) {
    // char[] chars = str.toCharArray();
    // for (int i = 0; i < chars.length; i++) {
    // char c = chars[i];
    // //Character.isDigit() 识别数字
    // if (Character.isDigit(c)) {
    // chars[i] = (char) ((c - '0' + 1) % 10 + '0');
    // // Character.isLowerCase() 识别小写字母
    // } else if (Character.isLowerCase(c)) {
    // chars[i] = (char) ((c - 'a' + 1) % 26 + 'a');
    // // Character.isUpperCase() 识别大写字母
    // } else if (Character.isUpperCase(c)) {
    // chars[i] = (char) ((c - 'A' + 1) % 26 + 'A');
    // }
    // }
    // return new String(chars);
    // }

}
