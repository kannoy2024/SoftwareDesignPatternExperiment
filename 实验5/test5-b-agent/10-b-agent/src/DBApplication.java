import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBApplication {
    public static Connection conn = null;
    public ResultSet rs = null;

    // private String databaseDriver;
    // private String databaseConnStr;
    // private String databaseUserName;
    // private String databasePassword;

    public DBApplication(String dBDriver, String dBConnStr, String userName, String password) {
        try {
            System.out.println("正在加载驱动: " + dBDriver);
            Class.forName(dBDriver);
            System.out.println("驱动加载成功，尝试连接数据库...");
            conn = DriverManager.getConnection(dBConnStr, userName, password);
        } catch (ClassNotFoundException e) {
            System.err.println("致命错误：驱动类未找到！请检查：");
            System.err.println("1. 是否添加了 mysql-connector-java 依赖？");
            System.err.println("2. 驱动类名是否拼写正确？");
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            System.err.println("数据库连接失败！错误原因：");
            System.err.println("1. 检查连接字符串: " + dBConnStr);
            System.err.println("2. 验证用户名/密码");
            System.err.println("3. 确认数据库服务是否启动");
            e.printStackTrace();
            if (conn != null) {
                try { conn.close(); } catch (SQLException ex) {}
            }
            System.exit(2);
        }
    }
    public int executeInsert(String sql) {
        if(conn == null) {
            throw new IllegalStateException("数据库连接未初始化");
        }
        int num = 0;
        try (Statement stmt = conn.createStatement()) {
            stmt.setQueryTimeout(30);
            System.out.println(sql + ";;;;");
            num = stmt.executeUpdate(sql);
            System.out.println("执行插入操作成功: " + num);
        } catch (SQLException ex) {
            System.err.println("执行插入操作出错: " + ex.getMessage());
        }
        return num;
    }

    public ResultSet executeQuery(String sql) {
        rs = null;
        try (Statement stmt = conn.createStatement()) {
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println("查询结果: " + rs.getString("name"));
            }
        } catch (SQLException ex) {
            System.err.println("执行查询出错: " + ex.getMessage());
        }
        return rs;
    }

    public int executeDelete(String sql) {
        int num = 0;
        try (Statement stmt = conn.createStatement()) {
            num = stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println("执行删除操作出错: " + ex.getMessage());
        }
        return num;
    }

    public void closeDataBase() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("关闭Connection时出错: " + e.getMessage());
        }
    }
}