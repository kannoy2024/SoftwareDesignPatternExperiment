public class PrintWriter  implements MessageWriter{

    @Override
    public void logMsg(String lastNm, String firstNm, String code) {
     System.out.println(lastNm + " " + firstNm + " " +code);
    }

}
