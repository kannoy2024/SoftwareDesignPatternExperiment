public class CourseService {
    private DBApplication db;

    public CourseService() {
        db = new DBApplication("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/student");
    }

}
