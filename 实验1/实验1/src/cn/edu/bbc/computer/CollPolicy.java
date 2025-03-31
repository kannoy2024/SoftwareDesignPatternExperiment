//This is a sub class in the factory class hierarchy PolicyProducer
package cn.edu.bbc.computer;


public class CollPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
        return new Collision();
    }
}
