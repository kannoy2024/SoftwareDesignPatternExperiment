



public class BodyPolicy implements PolicyProducer {
    public AutoInsurance getPolicyObj() {
       return new BodyInjury();
    }
}
