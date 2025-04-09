import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLFactory implements IFactory{
    public static Connection connection=null;

    @Override
    public Connection getConnection(String driver, String url, String username, String password){
        if (connection == null) {
                try {
                    Class.forName(driver);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    connection = DriverManager.getConnection(url, username, password);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return connection;
        }
        return null;
    }

    @Override
    public IUserOperator createUserManageEntity(Connection connection) {
        return new MySQLUserManageEntity(connection);
    }

    @Override
    public IDepartmentOperator createDepartmentManageEntity(Connection connection) {
        return new MySQLDepartmentManageEntity(connection);
    }
    
}
