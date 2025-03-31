package cn.edu.bbc.computer;

public class LxPolicy implements PolicyProducer {

    @Override
    public AutoInsurance getInsurObj() {
        // TODO Auto-generated method stub
        return new Lx();
    }
    
}
