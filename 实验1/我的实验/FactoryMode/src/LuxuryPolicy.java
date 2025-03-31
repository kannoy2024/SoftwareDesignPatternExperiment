
public class LuxuryPolicy implements PolicyProducer {

    @Override
    public AutoInsurance getPolicyObj() {
        return new Luxury();
    }
    
}
