/*------------------------------------------------*/
/* This class implements interface MessageWriter  */
/* This class provides a method called            */
/*            logMsg(String lastNm, String firstNm, String code) */
/* to write a message into the database table Agent */
/*------------------------------------------------*/

public class DBWriter implements MessageWriter {
    private String lastName;
    private String firstName;
    private String codeNum;

    // private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    // private static final String DATABASE_CONNECTION = "jdbc:mysql://localhost:3306/AgentInformation?";
    // private static final String USERNAME = "root";
    // private static final String PASSWORD = "123456";
    // MySQLFactory factory = new MySQLFactory();
    // connection = factory.getConnection(
    //     "com.mysql.cj.jdbc.Driver",
    //     "jdbc:mysql://localhost:3306/AgentInformation",
    //     "root",
    //     "123456"
    // );
    public void logMsg(String lastNm, String firstNm, String code) {
        firstName = firstNm;
        lastName = lastNm;
        codeNum = code;

        String sql = "INSERT INTO Agent (lastName, firstName, codeNum) VALUES ('" + lastName + "', '" + firstName + "', '" + codeNum + "')";
        System.out.println(sql);
        DBApplication db;
        try {
            db = new DBApplication( 
        "com.mysql.cj.jdbc.Driver",     
        "jdbc:mysql://localhost:3306/AgentInformation",
        "root",
        "123456");
            db.executeInsert(sql);
        } catch (Exception e) {
            System.err.println("数据库操作失败: " + e.getMessage());
            e.printStackTrace(); // 打印堆栈跟踪信息以便调试
        }
    }
}