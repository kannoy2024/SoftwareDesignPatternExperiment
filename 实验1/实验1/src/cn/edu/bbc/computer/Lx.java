package cn.edu.bbc.computer;

public class Lx implements AutoInsurance{
    private String description;

    public String getInfo() {
        description = " 豪华车险injury coverage pays for medical bills" +
                      " lost wages, rehabilitation, treatment and/or" +
                      " funeral costs for anyone injured or killed " +
                      " by your car. Such coverage will also pay for" +
                      " pain and suffering damages when a third " +
                      " party successfully sues. ";
        return description;
    }
 }
