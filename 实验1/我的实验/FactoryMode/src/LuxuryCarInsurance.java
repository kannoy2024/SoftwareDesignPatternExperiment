

public class LuxuryCarInsurance implements AutoInsurance {
    private String description;

    public String getInfo() {
        description = "豪华车险类业务计算过程" +
                      " lost wages, rehabilitation, treatment and/or" +
                      " funeral costs for anyone injured or killed " +
                      " by your car. Such coverage will also pay for" +
                      " pain and suffering damages when a third " +
                      " party successfully sues. ";
        return description;
    }
     
}
