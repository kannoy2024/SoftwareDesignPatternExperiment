import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLUserManageEntity implements IUserOperator {
    private Connection connection;

    public MySQLUserManageEntity(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO user(studentID,studentName, studentAge, deptID, dept, studentClass, studentAddr, studentGender) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement= connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getStudentID());
            preparedStatement.setString(2, user.getStudentName());
            preparedStatement.setInt(3, user.getStudentAge());
            preparedStatement.setInt(4, user.getDeptID());
            preparedStatement.setString(5, user.getDept());
            preparedStatement.setString(6, user.getStudentClass());
            preparedStatement.setString(7, user.getStudentAddr());
            preparedStatement.setString(8, user.getStudentGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        String sql = "DELETE FROM user WHERE studentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, user.getStudentID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET studentName = ?, studentAge = ?, deptID = ?, dept = ?, studentClass = ?, studentAddr = ?, studentGender = ? WHERE studentID = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getStudentName());
            preparedStatement.setInt(2, user.getStudentAge());
            preparedStatement.setInt(3, user.getDeptID());
            preparedStatement.setString(4, user.getDept());
            preparedStatement.setString(5, user.getStudentClass());
            preparedStatement.setString(6, user.getStudentAddr());
            preparedStatement.setString(7, user.getStudentGender());
            preparedStatement.setInt(8, user.getStudentID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByID(Integer id) {
        String sql = "SELECT studentID, studentName, studentAge, deptID, dept, studentClass, studentAddr, studentGender FROM user WHERE studentID = ?";
        User user = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = new User(
                    rs.getInt("studentID"),
                    rs.getString("studentName"),
                    rs.getInt("studentAge"),
                    rs.getInt("deptID"),
                    rs.getString("dept"),
                    rs.getString("studentClass"),
                    rs.getString("studentAddr"),
                    rs.getString("studentGender")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}