public class CourseController {
    private CourseService courseService;
    private CourseView courseView;

    public CourseController(CourseService courseService, CourseView courseView) {
        super();
        this.courseService = courseService;
        this.courseView = courseView;
    }

    public void updateView() {
        courseView.displayAllCourseInfo(courseService.getAllCourseInfo());
    }

    public void createTable() {
        courseService.createTable();
    }

    public void insertCourse() {
        courseService.insertCourse(courseView.getCourseInfo());
    }

    public void deleteCourse() {
        courseService.deleteCourse(courseView.getDeleteCourseInfo().getCourseId());
    }

    public void updateCourse() {
        courseService.updateCourse(courseView.getUpdateCourseInfo());
    }
}
