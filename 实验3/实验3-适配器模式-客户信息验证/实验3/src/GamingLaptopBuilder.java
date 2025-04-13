public class GamingLaptopBuilder implements LaptopBuilder {
    private Laptop laptop;

    public GamingLaptopBuilder() {
        this.laptop = new Laptop();
    }

    @Override
    public void buildCpu(String cpu) {
        laptop.setCpu(cpu);
    }

    @Override
    public void buildGpu(String gpu) {
        laptop.setGpu(gpu);
    }

    @Override
    public void buildRam(String ram) {
        laptop.setRam(ram);
    }

    @Override
    public void buildStorage(String storage) {
        laptop.setStorage(storage);
    }

    @Override
    public void buildDisplay(String display) {
        laptop.setDisplay(display);
    }

    @Override
    public Laptop getLaptop() {
        return laptop;
    }
}
