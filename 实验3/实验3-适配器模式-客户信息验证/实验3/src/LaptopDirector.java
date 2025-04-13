public class LaptopDirector {
    private LaptopBuilder laptopBuilder;

    public void setLaptopBuilder(LaptopBuilder laptopBuilder) {
        this.laptopBuilder = laptopBuilder;
    }

    public Laptop buildLaptop() {
        laptopBuilder.buildCpu("Intel i7\n");
        laptopBuilder.buildGpu("NVIDIA RTX 3060\n");
        laptopBuilder.buildRam("16GB DDR4\n");
        laptopBuilder.buildStorage("512GB SSD\n");
        laptopBuilder.buildDisplay("15.6 inch Full HD\n");
        return laptopBuilder.getLaptop();
    }
}