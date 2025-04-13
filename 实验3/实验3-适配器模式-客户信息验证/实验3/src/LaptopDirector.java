public class LaptopDirector {
    private LaptopBuilder laptopBuilder;

    public void setLaptopBuilder(LaptopBuilder laptopBuilder) {
        this.laptopBuilder = laptopBuilder;
    }

    public Laptop buildLaptop() {
        laptopBuilder.buildCpu("Intel i7");
        laptopBuilder.buildGpu("NVIDIA RTX 3060");
        laptopBuilder.buildRam("16GB DDR4");
        laptopBuilder.buildStorage("512GB SSD");
        laptopBuilder.buildDisplay("15.6 inch Full HD");
        return laptopBuilder.getLaptop();
    }
}