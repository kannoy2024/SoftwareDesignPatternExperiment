import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseTest {
    public static void main(String[] args) {
        // 测试SQLite数据库
        testSQLiteDatabase();
        
        // 测试MariaDB数据库
        testMariaDBDatabase();
    }

    private static void testSQLiteDatabase() {
        System.out.println("===== SQLite 数据库测试开始 =====");
        Connection connection = null;
        try {
            // 1. 初始化SQLite连接
            SQLiteFactory factory = new SQLiteFactory();
            connection = factory.getConnection(
                "org.sqlite.JDBC",
                "jdbc:sqlite:infod.db",
                "",
                ""
            );

            // 2. 初始化测试表
            // initializeTables(connection);

            // 3. 获取操作实例
            IUserOperator userOperator = factory.createUserManageEntity(connection);
            IDepartmentOperator deptOperator = factory.createDepartmentManageEntity(connection);

            // 4. 执行测试
            testUserOperations(userOperator);
            testDepartmentOperations(deptOperator);

            System.out.println("===== SQLite 数据库测试成功 =====");
        } catch (Exception e) {
            System.err.println("SQLite测试失败: " + e.getMessage());
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
                "jdbc:mariadb://localhost:3306/mydb",
                "pmauser",
                "yzhi0788"
            );
            //MySQL和MariadDB建表的SQL语句。
            // // 2. 初始化测试表
            // initializeTables(connection);
            // -- mydb.Department definition

            // CREATE TABLE `Department` (
            //   `id` int(11) NOT NULL AUTO_INCREMENT,
            //   `name` varchar(50) NOT NULL,
            //   `code` varchar(50) DEFAULT NULL,
            //   `manager_id` int(11) DEFAULT NULL,
            //   `description` varchar(500) DEFAULT NULL,
            //   `status` int(11) DEFAULT 1,
            //   `location` varchar(100) DEFAULT NULL,
            //   `phone` varchar(50) DEFAULT NULL,
            //   `email` varchar(50) DEFAULT NULL,
            //   PRIMARY KEY (`id`),
            //   KEY `idx_dept_manager` (`manager_id`)
            // ) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
            
            
            // -- mydb.`user` definition
            
            // CREATE TABLE `user` (
            //   `id` int(11) NOT NULL AUTO_INCREMENT,
            //   `name` varchar(50) DEFAULT NULL,
            //   `sage` int(11) NOT NULL,
            //   `dept_id` int(11) DEFAULT NULL,
            //   `sclass` varchar(50) DEFAULT NULL,
            //   `sdept` varchar(50) DEFAULT NULL,
            //   `saddr` varchar(100) DEFAULT NULL,
            //   `sgender` varchar(10) DEFAULT NULL,
            //   PRIMARY KEY (`id`),
            //   KEY `dept_id` (`dept_id`)
            // ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
            // 3. 获取操作实例
            IUserOperator userOperator = factory.createUserManageEntity(connection);
            IDepartmentOperator deptOperator = factory.createDepartmentManageEntity(connection);

            // 4. 执行测试
            testUserOperations(userOperator);
            testDepartmentOperations(deptOperator);

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
            // 创建Department表
            stmt.execute("DROP TABLE IF EXISTS Department");
            stmt.execute("CREATE TABLE Department (" +
                "id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50) NOT NULL, " +
                "code VARCHAR(20), " +
                "manager_id INTEGER, " +
                "description TEXT, " +
                "status INTEGER, " +
                "location VARCHAR(100), " +
                "phone VARCHAR(20), " +
                "email VARCHAR(50))");

            // 创建User表
            stmt.execute("DROP TABLE IF EXISTS User");
            stmt.execute("CREATE TABLE User (" +
                "id INTEGER PRIMARY KEY, " +
                "name VARCHAR(50) NOT NULL, " +
                "sage INTEGER, " +
                "dept_id INTEGER, " +
                "dept VARCHAR(50), " +
                "sclass VARCHAR(50), " +
                "saddr VARCHAR(100), " +
                "sgender VARCHAR(10), " +
                "FOREIGN KEY (dept_id) REFERENCES Department(id))");
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
        queriedUser.setName("张三丰");
        queriedUser.setSage(30);
        System.out.println("更新用户: " + queriedUser);
        userOperator.update(queriedUser);
        System.out.println("更新后查询: " + userOperator.getUserByID(1));
        
        // 4. 测试删除
        System.out.println("删除用户ID=1");
        userOperator.delete(queriedUser);
        System.out.println("删除后查询: " + userOperator.getUserByID(1));
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
        System.out.println("删除部门ID=" + deptId);
        int affectedRows = deptOperator.delete(queriedDept);
        System.out.println("删除影响行数: " + affectedRows);
        System.out.println("删除后查询: " + deptOperator.getDepartmentByID(deptId.toString()));
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