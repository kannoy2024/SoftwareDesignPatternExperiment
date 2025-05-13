package mvc.minimvcconsoledataapp;

public class StuController {
	private StudentService service;
	private StudentView view;
	public StuController(StudentService service, StudentView view) {
		super();
		this.service = service;
		this.view = view;
	}
	public void updateView() {
		view.displayAllDetail(service.getAllStudentInfo());
	}
	
	public void createTable() {
		service.createTable();
	}
	
	public void deleteStudent() {
		service.deleteFromStudent(view.getDeleteStudentInfo());
	}
	
	public void insertStudent() {
		service.insertStudent(view.getNewStudent());
		
	}
	
	public void updateStudent()
	{
		service.updateStudentInfo(view.getUpdateStudentInfo());
	}
}
