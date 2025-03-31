public class AdvancedPersonPolicy implements PolicyProducer{
    public AutoInsurance getPolicyObj(){
        return new AdvancedPerson();
    }
}
