//This is a sub class in the factory class hierarchy PolicyProducer
package cn.edu.bbc.computer;


public class PropPolicy implements PolicyProducer {

   public AutoInsurance getInsurObj() {
      return new Property();
   }
}