public class GamingLaptopBuilder implements LaptopBuilder {
    private Laptop laptop;

    public GamingLaptopBuilder() {
        this.laptop = new Laptop();
    }

    @Override
    public void buildCpu( ) {
        laptop.setCpu("AMD");
    }

    @Override
    public void buildGpu( ) {
        laptop.setGpu("4060");
    }

    @Override
    public void buildRam( ) {
        laptop.setRam("40g");
    }

    @Override
    public void buildStorage( ) {
        laptop.setStorage("2T");
    }

    @Override
    public void buildDisplay( ) {
        laptop.setDisplay("4K");
    }

    @Override
    public Laptop getLaptop() {
        return laptop;
    }
}
