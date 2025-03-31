public class DivisionOperation extends Operation {
    public double getResult() {
        double result = 0;
        if (getNumberB() != 0)
            result = getNumberA() / getNumberB();
        else
            System.out.println("除数不能为0！");
        return result;
    }
}
