public class AddFactory implements Factory{

    @Override
    public Operation createOperation() {
        // TODO Auto-generated method stub
        return new Add();
    }
    
}
