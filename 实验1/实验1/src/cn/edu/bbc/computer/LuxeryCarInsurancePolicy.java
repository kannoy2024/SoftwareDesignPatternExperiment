package cn.edu.bbc.computer;

public class LuxeryCarInsurancePolicy implements PolicyProducer {

    @Override
    public AutoInsurance getInsurObj() {
        // TODO Auto-generated method stub
        return new LuxeryCarInsurance();
    }
    
}
