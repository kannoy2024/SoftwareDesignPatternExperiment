import java.util.ArrayList;
import java.sql.ResultSet;
// import java.sql.SQLException;

public class CourseService {
    private DBApplication db;

    public CourseService() {
        db = new DBApplication("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/student");
    }

    public void createTable() {
        db.createTable();
    }

    public ArrayList<Course> getAllCourseInfo() {
        ArrayList<Course> courseList = new ArrayList<Course>();
        try {
            ResultSet result = db.executeQuery("select * from course");
            while (result.next()) {
                Course course = new Course(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getInt(4),
                        result.getInt(5),
                        result.getInt(6));
                courseList.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    public ArrayList<Course> getByCourseID(String courseID) {
        ArrayList<Course> courseList = new ArrayList<Course>();
        try {
            ResultSet resultSet = db.executeQuery("select * from course where courseID='" + courseID + "'");
            while (resultSet.next()) {
                Course course = new Course(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6));
                courseList.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace(); // 建议打印异常信息以便调试
        }
        return courseList;
    }

    public void insertCourse(Course course) {
        String sql = "insert into course values('" +
                course.getCourseName() + "','"
                + course.getCourseId() + "','"
                + course.getCourseTeacher() + "',"
                + course.getCourseCredit() + ","
                + course.getCourseTime() + ","
                + course.getCourseWeek() + ")";
        System.out.println(sql);
        System.out.println("insertCourse");
        db.executeInsert(sql);
    }

    public void deleteCourse(String courseID) {
        String sql = "delete from course where courseID='" + courseID + "'";
        System.out.println(sql);
        System.out.println("deleteCourse");
        db.executeDelete(sql);
    }

    public void updateCourse(Course course) {
        String sql = "update course set courseName='" +
                course.getCourseName() + "',courseTeacher='" +
                course.getCourseTeacher() + "',courseCredit=" +
                course.getCourseCredit() + ",courseTime=" +
                course.getCourseTime() + ",courseWeek=" +
                course.getCourseWeek() + " where courseID='" +
                course.getCourseId() + "'";
        System.out.println(sql);
        System.out.println("updateCourse");
        db.executeInsert(sql);
    }

}
