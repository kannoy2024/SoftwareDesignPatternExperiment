public class ModuloOperation extends Operation{
    public double getResult() {
        double result = 0;
        if(getNumberB() == 0){
            System.out.println("除数不能为0");
            return result;
        }else{
        result = getNumberA() % getNumberB();
        return result;
        }
    }
         
}
