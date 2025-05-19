public class MVC {
    public static void main(String[] args) {
        CourseService courseService = new CourseService();
        CourseView courseView = new CourseView();
        CourseController courseController = new CourseController(courseService, courseView);
        courseController.createTable();
        courseController.insertCourse();
        courseController.updateView();
        courseController.updateCourse();
        courseController.updateView();
        courseController.deleteCourse();
        courseController.updateView();
    }
}
