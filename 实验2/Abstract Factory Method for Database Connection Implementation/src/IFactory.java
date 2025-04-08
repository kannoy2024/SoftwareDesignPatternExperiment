import java.sql.Connection;

public interface IFactory {
        public Connection getConnection(String driver,String url,String username,String password);
        public IUserOperator createUserManageEntity(Connection connection);
        public IDepartmentOperator createDepartmentManageEntity(Connection connection);
}
