import java.util.ArrayList;
import java.util.Iterator;

public class CourseView {

    public Course getCourseInfo() {
        Course course = new Course();
        course.setCourseName("测试课程");
        course.setCourseId("123456");
        course.setCourseTeacher("测试老师");
        course.setCourseCredit(3);
        course.setCourseTime(1);
        course.setCourseWeek(1);
        return course;
    }

    public void displayAllCourseInfo(ArrayList<Course> courseList) {
        Iterator<Course> iterator = courseList.iterator();
        while (iterator.hasNext()) {
            Course course = (Course) iterator.next();
            System.out.println("课程名：" + course.getCourseName() +
                    "课程号：" + course.getCourseId() +
                    "教师：" + course.getCourseTeacher() +
                    "学分：" + course.getCourseCredit() +
                    "时间：" + course.getCourseTime() +
                    "周数：" + course.getCourseWeek());
        }
    }

    public Course getDeleteCourseInfo() {
        Course course = new Course();
        course.setCourseId("123456");
        return course;
    }

    public Course getUpdateCourseInfo() {
        Course course = new Course();
        course.setCourseId("123456");
        course.setCourseName("测试课程");
        course.setCourseTeacher("测试老师");
        course.setCourseCredit(3);
        course.setCourseTime(1);
        course.setCourseWeek(1);
        return course;
    }
}
