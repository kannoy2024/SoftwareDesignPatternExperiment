package mvc.MinMVC;

public class testMain {

	public static void main(String[] args) {
		SImpleModel model=new SImpleModel();
		SimpleVIew vIew=new SimpleVIew();
		SimpleController controller=new SimpleController(model, vIew);
		controller.insertDataToDb();
		controller.updateView();
	}

}
