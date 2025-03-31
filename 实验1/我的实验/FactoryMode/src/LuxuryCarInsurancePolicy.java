

public class LuxuryCarInsurancePolicy implements PolicyProducer {

    @Override
    public AutoInsurance getPolicyObj() {
        return new LuxuryCarInsurance();
    }
    
}
