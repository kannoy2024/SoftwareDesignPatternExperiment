import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CourseService {
    private DBApplication db;

    public CourseService() {
        db = new DBApplication("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/student");
    }

    public ArrayList<Course> getAllCourseInfo(){
        ArrayList<Course> courseList = new ArrayList<Course>();
        try {
            ResultSet  result = db.executeQuery("select * from course");
            while (result.next()) { 
            Course  course = new Course(
            result.getString(1),result.getString(2), result.getString(3 ),
            result.getInt(4),result.getInt(5),result.getInt(6)
            );
            courseList.add(course);
            }
        }catch (Exception e) { 
            e.printStackTrace();
        }
        return courseList;
      }

      public ArrayList<Course> getByCourseID(String courseID){
        ArrayList<Course> courseList = new ArrayList<Course>();
        return  courseList;
      }

}
