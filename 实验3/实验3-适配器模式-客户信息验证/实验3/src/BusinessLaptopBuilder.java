
public class BusinessLaptopBuilder implements LaptopBuilder {
    private Laptop laptop;

    public BusinessLaptopBuilder() {
        this.laptop = new Laptop();
    }

    @Override
    public void buildCpu() {
        laptop.setCpu("英特尔");
    }

    @Override
    public void buildGpu( ) {
        laptop.setGpu("1060");
    }

    @Override
    public void buildRam( ) {
        laptop.setRam("20G");
    }

    @Override
    public void buildStorage( ) {
        laptop.setStorage("510G");
    }

    @Override
    public void buildDisplay( ) {
        laptop.setDisplay("2k");
    }

    @Override
    public Laptop getLaptop() {
        return laptop;
    }
}