//This is a sub class in the factory class hierarchy PolicyProduce


public class CollPolicy implements PolicyProducer {
    public AutoInsurance getPolicyObj() {
        return new Collision();
    }
}
