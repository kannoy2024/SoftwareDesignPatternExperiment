package mvc.MinMVCConsoleDataApp;

public class mvcDemo {

	public static void main(String[] args) {
		StudentService service=new StudentService();
		StudentView view=new StudentView();
		StuController stController=new StuController(service, view);
		stController.createTable();
		stController.insertStudent();
		stController.updateView();
		stController.updateStudent();
		stController.updateView();
		stController.deleteStudent();
		stController.updateView();
	}

}
