import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBApplication {
    public static Connection conn = null;
    public ResultSet result = null;

    private String databaseDriver;
    private String databaseConnStr;

    public DBApplication(String dBDriver, String dBConnStr) {
    System.out.println("Connecting to: " + dBConnStr);
    System.out.println("Using driver: " + dBDriver);

    databaseDriver = dBDriver;
    databaseConnStr = dBConnStr;

        try {
        // 加载驱动
        Class.forName(databaseDriver);

        // 增加用户名和密码参数
        conn = DriverManager.getConnection(databaseConnStr, "root", "123456");

    } catch (ClassNotFoundException e) {
        System.err.println("加载驱动器有错误:" + e.getMessage());
    } catch (SQLException e) {
        System.err.println("数据库连接失败:" + e.getMessage());
    }
}


	public int executeInsert(String sql) {
		int num = 0;
		try {
			Statement stmt = conn.createStatement();
			stmt.setQueryTimeout(30);
			System.out.println(sql + ";;;;");
			num = stmt.executeUpdate(sql);
		} catch (SQLException ex) {
			System.err.println("执行插入有错误:" + ex.getMessage());
			System.out.print("执行插入有错误:" + ex.getMessage()); // 输出到客户端
		}

//       closeDataBase();
		return num;
	}


}
