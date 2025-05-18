public class CourseController {
    private CourseService courseService;
    private CourseView courseView;
    public CourseController(CourseService courseService, CourseView courseView){
        this.courseService = courseService;
        this.courseView = courseView;
    }
    public void updateCourse(){
    
    }
}
