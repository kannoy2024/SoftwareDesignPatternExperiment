//This is a sub class in the factory class hierarchy PolicyProducerpackage cn.edu.bbc.computer;
package cn.edu.bbc.computer;



public class BodyPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
       return new BodyInjur();
    }
}
