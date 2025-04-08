import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDBFactory implements IFactory {
    public static Connection connection = null;

    @Override
    public Connection getConnection(String driver, String url, String username, String password) {
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    @Override
    public IUserOperator createUserManageEntity(Connection connection) {
        return new MariaDBUserManageEntity(connection);
    }

    @Override
    public IDepartmentOperator createDepartmentManageEntity(Connection connection) {
        return new MariaDBDepartmentManageEntity(connection);
    }
}
