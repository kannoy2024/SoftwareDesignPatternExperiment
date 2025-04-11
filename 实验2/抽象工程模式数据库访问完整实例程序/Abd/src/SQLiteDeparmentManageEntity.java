import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLiteDeparmentManageEntity implements IDepartmentOperator {
    private Connection connection;

    public SQLiteDeparmentManageEntity(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Integer insert(Department department) {
        String sql = "INSERT INTO Department(name, code, manager_id, description, status, location, phone, email) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, department.getName());
            pstmt.setString(2, department.getCode());
            pstmt.setInt(3, department.getManager_id());
            pstmt.setString(4, department.getDescription());
            pstmt.setInt(5, department.getStatus());
            pstmt.setString(6, department.getLocation());
            pstmt.setString(7, department.getPhone());
            pstmt.setString(8, department.getEmail());
            pstmt.executeUpdate();
            
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer delete(Department department) {
        String sql = "DELETE FROM Department WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, department.getId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer update(Department department) {
        String sql = "UPDATE Department SET name = ?, code = ?, manager_id = ?, description = ?, status = ?, location = ?, phone = ?, email = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, department.getName());
            pstmt.setString(2, department.getCode());
            pstmt.setInt(3, department.getManager_id());
            pstmt.setString(4, department.getDescription());
            pstmt.setInt(5, department.getStatus());
            pstmt.setString(6, department.getLocation());
            pstmt.setString(7, department.getPhone());
            pstmt.setString(8, department.getEmail());
            pstmt.setInt(9, department.getId());
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Department getDepartmentByID(String sid) {
        String sql = "SELECT id, name, code, manager_id, description, status, location, phone, email FROM Department WHERE id = ?";
        Department department = null;
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, sid);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                department = new Department(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("code"),
                    rs.getInt("manager_id"),
                    rs.getString("description"),
                    rs.getInt("status"),
                    rs.getString("location"),
                    rs.getString("phone"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }
}