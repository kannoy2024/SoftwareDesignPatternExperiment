package mvc.MinMVCConsoleDataApp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class StudentService {
	private DBApplication db;
	public StudentService() {
db = new DBApplication("com.mysql.cj.jdbc.Driver", 
    "jdbc:mysql://localhost:3306/student");
	}
	 public ArrayList<Student> getAllStudentInfo() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            ResultSet rs = db.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                Student student = new Student(
                    rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public ArrayList<Student> getByPara(Student s) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            ResultSet rs = db.executeQuery("SELECT * FROM student WHERE id='" + s.getId() + "'");
            while (rs.next()) {
                Student student = new Student(
                    rs.getString(1), rs.getString(2), rs.getString(3),
                    rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7)
                );
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void createTable() {
        db.createTable();
    }

    public void insertStudent(Student s) {
        String sqlString = "INSERT INTO student VALUES ('" +
            s.getId() + "','" + s.getName() + "','" + s.getGender() + "'," +
            s.getAge() + ",'" + s.getMajor() + "','" + s.getDept() + "','" + s.getAddr() + "')";
        System.out.println(sqlString);
        db.executeInsert(sqlString);
    }

    public void deleteFromStudent(Student s) {
        String sqlString = "DELETE FROM student WHERE id='" + s.getId() + "'";
        System.out.println(sqlString);
        db.executeDelete(sqlString);
    }

    public void updateStudentInfo(Student s) {
        String sqlString = "UPDATE student SET name='" + s.getName() +
            "', gender='" + s.getGender() + "', age=" + s.getAge() +
            ", major='" + s.getMajor() + "', dept='" + s.getDept() +
            "', addr='" + s.getAddr() + "' WHERE id='" + s.getId() + "'";
        System.out.println(sqlString);
        db.executeInsert(sqlString); // 注意这里应该是 executeUpdate，不是 executeInsert
    }
}