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
			System.out.println("	数据库连接成功!");
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
			System.out.println("**********" + sql + "**********");
			num = stmt.executeUpdate(sql);
			System.out.println("插入执行成功");
		} catch (SQLException ex) {
			System.err.println("执行插入有错误:" + ex.getMessage());
			System.out.print("执行插入有错误:" + ex.getMessage()); // 输出到客户端
		}
		// closeDataBase();
		return num;
	}

	public ResultSet executeQuery(String sql) {
		result = null;
		try {
			Statement stmt = conn.createStatement();
			System.out.println("**********" + sql + "**********");
			result = stmt.executeQuery(sql);
			System.out.println("查询执行成功");
		} catch (SQLException ex) {
			System.err.println("执行查询有错误:" + ex.getMessage() + sql);
			System.out.print("执行查询有错误:" + ex.getMessage()); // 输出到客户端
		}

		return result;
	}

	public int executeDelete(String sql) {
		int num = 0;
		try {
			Statement stmt = conn.createStatement();
			System.out.println("**********" + sql + "**********");
			num = stmt.executeUpdate(sql);
			System.out.println("删除执行成功");
		} catch (SQLException ex) {
			System.err.println("执行删除有错误:" + ex.getMessage());
			System.out.print("执行删除有错误:" + ex.getMessage()); // 输出到客户端
		}

		// closeDataBase();
		return num;
	}

	public void createTable() {
		Statement statement1;
		try {
			statement1 = conn.createStatement();
			statement1.setQueryTimeout(30); // set timeout to 30 sec.
			String sql = "CREATE TABLE if not exists course ( "
					+ "courseId varchar(20) NOT NULL, "
					+ "courseName varchar(100) NOT NULL,"
					+ "courseTeacher varchar(10) NOT NULL,"
					+ "courseCredit int(11) NOT NULL,"
					+ "courseTime int(11) NOT NULL,"
					+ "courseWeek int(11) NOT NULL)";

			statement1.executeUpdate(sql);
			System.out.println("**********" + sql + "**********");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void closeDataBase() {
		try {
			conn.close();
		} catch (Exception end) {
			System.err.println("执行关闭Connection对象有错误：" + end.getMessage());
			System.out.print("执行执行关闭Connection对象有错误：有错误:" + end.getMessage()); // 输出到客户端
		}
	}

}
