import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {
    public static void main(String[] args) {
        // 测试MySQL数据库
        testMySQLDatabase();
        
        // 测试MariaDB数据库
        testMariaDBDatabase();
    }

    private static void testMySQLDatabase() {
        System.out.println("===== MySQL 数据库测试开始 =====");
        Connection connection = null;
        try {
            // 1. 初始化MySQL连接
            MySQLFactory factory = new MySQLFactory();
            connection = factory.getConnection(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/student",
                "root",
                "123456"
            );

            // 2. 初始化测试表
            initializeTables(connection);

            // 3. 获取操作实例
            IUserOperator userOperator = factory.createUserManageEntity(connection);
            IDepartmentOperator deptOperator = factory.createDepartmentManageEntity(connection);

            // 4. 执行测试
            testDepartmentOperations(deptOperator);
            testUserOperations(userOperator);

            System.out.println("===== MySQL 数据库测试成功 =====");
        } catch (Exception e) {
            System.err.println("MySQL测试失败: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    private static void testMariaDBDatabase() {
        System.out.println("\n===== MariaDB 数据库测试开始 =====");
        Connection connection = null;
        try {
            // 1. 初始化MariaDB连接
            MariaDBFactory factory = new MariaDBFactory();
            connection = factory.getConnection(
                "org.mariadb.jdbc.Driver",
                "jdbc:mariadb://localhost:3307/student",
                "root",
                "111111"
            );

            // 2. 初始化测试表
            initializeTables(connection);

            // 3. 获取操作实例
            IUserOperator userOperator = factory.createUserManageEntity(connection);
            IDepartmentOperator deptOperator = factory.createDepartmentManageEntity(connection);

            // 4. 执行测试
            testDepartmentOperations(deptOperator);
            testUserOperations(userOperator);

            System.out.println("===== MariaDB 数据库测试成功 =====");
        } catch (Exception e) {
            System.err.println("MariaDB测试失败: " + e.getMessage());
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    private static void initializeTables(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            // 先删除User表
            stmt.execute("DROP TABLE IF EXISTS User");

            // 再删除Department表
            stmt.execute("DROP TABLE IF EXISTS Department");

            // 创建Department表
            stmt.execute("CREATE TABLE Department (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, " +
                "code VARCHAR(20), " +
                "manager_id INT, " +
                "description TEXT, " +
                "status INT, " +
                "location VARCHAR(100), " +
                "phone VARCHAR(20), " +
                "email VARCHAR(50))");

            // 创建User表
            stmt.execute("CREATE TABLE User (" +
                "studentID INT AUTO_INCREMENT PRIMARY KEY, " +
                "studentName VARCHAR(50) NOT NULL, " +
                "studentAge INT, " +
                "deptID INT, " +
                "dept VARCHAR(50), " +
                "studentClass VARCHAR(50), " +
                "studentAddr VARCHAR(100), " +
                "studentGender VARCHAR(10), " +
                "FOREIGN KEY (deptID) REFERENCES Department(id))");
        }
    }

    private static void testUserOperations(IUserOperator userOperator) throws SQLException {
        System.out.println("\n--- 测试User表操作 ---");

        // 1. 测试插入
        User user = new User(1, "张三", 25, 1, "技术部", "一班", "北京市", "男");
        System.out.println("插入用户: " + user);
        userOperator.insert(user);

        // 2. 测试查询
        User queriedUser = userOperator.getUserByID(1);
        System.out.println("查询结果: " + queriedUser);

        // 3. 测试更新
        queriedUser.setStudentName("张三丰");
        queriedUser.setStudentAge(30);
        System.out.println("更新用户: " + queriedUser);
        userOperator.update(queriedUser);
        System.out.println("更新后查询: " + userOperator.getUserByID(1));

        // 4. 测试删除
        // System.out.println("删除用户ID=1");
        // userOperator.delete(queriedUser);
        // System.out.println("删除后查询: " + userOperator.getUserByID(1));

        System.out.println("===student表测试结束");
    }

    private static void testDepartmentOperations(IDepartmentOperator deptOperator) throws SQLException {
        System.out.println("\n--- 测试Department表操作 ---");

        // 1. 测试插入
        Department dept = new Department(null, "技术部", "TECH001", 1, "负责技术研发", 1, "3楼", "010-12345678", "tech@company.com");
        System.out.println("插入部门: " + dept);
        Integer deptId = deptOperator.insert(dept);
        System.out.println("生成的部门ID: " + deptId);

        // 2. 测试查询
        Department queriedDept = deptOperator.getDepartmentByID(deptId.toString());
        System.out.println("查询结果: " + queriedDept);

        // 3. 测试更新
        queriedDept.setName("技术研发中心");
        queriedDept.setDescription("负责全公司技术研发工作");
        System.out.println("更新部门: " + queriedDept);
        deptOperator.update(queriedDept);
        System.out.println("更新后查询: " + deptOperator.getDepartmentByID(deptId.toString()));

        // 4. 测试删除
        // System.out.println("删除部门ID=" + deptId);
        // int affectedRows = deptOperator.delete(queriedDept);
        // System.out.println("删除影响行数: " + affectedRows);
        // System.out.println("删除后查询: " + deptOperator.getDepartmentByID(deptId.toString()));

        System.out.println("===Department测试结束===");
    }

    private static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}