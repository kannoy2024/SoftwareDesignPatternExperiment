import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MariaDBDepartmentManageEntity implements IDepartmentOperator {
    private Connection connection;

    public MariaDBDepartmentManageEntity(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Integer insert(Department department) {
        String sql = "INSERT INTO Department(name, code, manager_id, description, status, location, phone, email) VALUES(?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.setString(2, department.getCode());
            preparedStatement.setInt(3, department.getManager_id());
            preparedStatement.setString(4, department.getDescription());
            preparedStatement.setInt(5, department.getStatus());
            preparedStatement.setString(6, department.getLocation());
            preparedStatement.setString(7, department.getPhone());
            preparedStatement.setString(8, department.getEmail());
            preparedStatement.executeUpdate();
            
            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
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
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, department.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Integer update(Department department) {
        String sql = "UPDATE Department SET name = ?, code = ?, manager_id = ?, description = ?, status = ?, location = ?, phone = ?, email = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, department.getName());
            preparedStatement.setString(2, department.getCode());
            preparedStatement.setInt(3, department.getManager_id());
            preparedStatement.setString(4, department.getDescription());
            preparedStatement.setInt(5, department.getStatus());
            preparedStatement.setString(6, department.getLocation());
            preparedStatement.setString(7, department.getPhone());
            preparedStatement.setString(8, department.getEmail());
            preparedStatement.setInt(9, department.getId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Department getDepartmentByID(String sid) {
        String sql = "SELECT id, name, code, manager_id, description, status, location, phone, email FROM Department WHERE id = ?";
        Department department = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, sid);
            ResultSet rs = preparedStatement.executeQuery();
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