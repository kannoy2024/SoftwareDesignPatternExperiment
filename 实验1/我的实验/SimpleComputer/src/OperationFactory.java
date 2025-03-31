

public class OperationFactory {
    //输入运算符号，实例化出相应的对象
    public static Operation createOperate(String operate) {   //返回值为Operation对象
        Operation operation = null;
        switch (operate) {
            case "+": operation = new AdditionOperation();
                break;
            case "-":
                operation = new SubtractionOperation();
                break;
            case "*":
                operation = new MultiplicationOperation();
                break;
            case "/":
                operation = new DivisionOperation();
                break;
             case "%":
                operation = new ModuloOperation();
                break;
                default:
                System.out.println("输入了错误的运算符号，请重启程序！");
                return null;
        }
        return operation;
    }
}
