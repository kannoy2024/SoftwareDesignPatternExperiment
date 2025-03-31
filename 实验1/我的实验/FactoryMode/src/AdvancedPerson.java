public class AdvancedPerson implements AutoInsurance{

    private String description;

    public String getInfo() {
        description = "简单写一个高级伤害保险吧\n"+
                      "Advanced Personal Injury Protection: \n\n" +
                      "This policy provides comprehensive coverage for bodily injury " +
                      "sustained by you or your passengers in an accident. It includes " +
                      "medical expenses, lost wages, rehabilitation, treatment, and funeral costs. " +
                      "Additionally, it offers enhanced coverage for pain and suffering damages " +
                      "when a third party successfully sues you. This advanced policy also " +
                      "includes legal defense services and emergency medical transportation.\n\n"+
                      "高级个人伤害保护: \n\n" +
                      "此保险政策提供全面的个人伤害保障，包括因交通事故导致的医疗费用、误工费、康复费用、治疗费用和丧葬费用。" +
                      "此外，它还涵盖第三方成功起诉时的疼痛和精神损害赔偿。此高级政策还包括法律辩护服务和紧急医疗运输服务。";
        return description;
    }
}
