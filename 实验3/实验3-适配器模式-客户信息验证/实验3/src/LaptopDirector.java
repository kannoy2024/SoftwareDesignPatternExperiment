public class LaptopDirector {//
    private LaptopBuilder laptopBuilder;

    public void setLaptopBuilder(LaptopBuilder laptopBuilder) {
        this.laptopBuilder = laptopBuilder;
    }

    public Laptop buildLaptop() {
        laptopBuilder.buildCpu();
        laptopBuilder.buildGpu();
        laptopBuilder.buildRam();
        laptopBuilder.buildStorage();
        laptopBuilder.buildDisplay();
        return laptopBuilder.getLaptop();
    }
}
// 接下来，我们定义一个负责调用具体建造者方法以构建产品的Director类。
// 这个类不需要知道具体的建造步骤或产品细节，只需知道存在建造过程即可。