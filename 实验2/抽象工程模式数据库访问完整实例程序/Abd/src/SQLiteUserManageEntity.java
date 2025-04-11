import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteUserManageEntity implements IUserOperator {
    private Connection connection;

    public SQLiteUserManageEntity(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO user(id, name, sage, dept_id, sdept, sclass, saddr, sgender) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setInt(3, user.getSage());
            pstmt.setInt(4, user.getDept_id());
            pstmt.setString(5, user.getDept());
            pstmt.setString(6, user.getSclass());
            pstmt.setString(7, user.getSaddr());
            pstmt.setString(8, user.getSgender());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        String sql = "DELETE FROM user WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE user SET name = ?, sage = ?, dept_id = ?, sdept = ?, sclass = ?, saddr = ?, sgender = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, user.getName());
            pstmt.setInt(2, user.getSage());
            pstmt.setInt(3, user.getDept_id());
            pstmt.setString(4, user.getDept());
            pstmt.setString(5, user.getSclass());
            pstmt.setString(6, user.getSaddr());
            pstmt.setString(7, user.getSgender());
            pstmt.setInt(8, user.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByID(Integer id) {
        String sql = "SELECT id, name, sage, dept_id, sdept, sclass, saddr, sgender FROM user WHERE id = ?";
        User user = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("sage"),
                    rs.getInt("dept_id"),
                    rs.getString("sdept"),
                    rs.getString("sclass"),
                    rs.getString("saddr"),
                    rs.getString("sgender")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}