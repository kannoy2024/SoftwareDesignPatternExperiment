import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteFactory implements IFactory{
    public static Connection connection=null;

    @Override
    public Connection getConnection(String driver, String url, String username, String password){
        // TODO Auto-generated method stub
        if (connection == null) {
                try {
                    Class.forName("org.sqlite.JDBC");
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    connection = DriverManager.getConnection(url, username, password);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return connection;
        }
        return null;
    }

    @Override
    public IUserOperator createUserManageEntity(Connection connection) {
        // TODO Auto-generated method stub
        return new SQLiteUserManageEntity(connection);
    }

    @Override
    public IDepartmentOperator createDepartmentManageEntity(Connection connection) {
        // TODO Auto-generated method stub
        return new SQLiteDeparmentManageEntity(connection);
    }
    
}
