public class TuitionModel {
    private String studFirstName;
    private String studLastName;
    private String studSerialNum;
    private String paidFee;
    private String paidYear;

    public TuitionModel (String studFirstName, String studLastName, String studSerialNum,
                         String paidFee, String paidYear) {
                             this.studFirstName = studFirstName;
                             this.studLastName = studLastName;
                             this.studSerialNum = studSerialNum;    
                             this.paidFee = paidFee;
                             this.paidYear = paidYear;               
    }
    public String getStudFirstName() { return studFirstName; }
    public String getStudLastName(){ return studLastName; }
    public String getStudSerialNum(){ return studSerialNum; }
    public String getPaidFee(){ return paidFee; }
    public String getPaidYear(){ return paidYear; }
 
}
