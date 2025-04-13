public interface LaptopBuilder {
    void buildCpu(String cpu);
    void buildGpu(String gpu);
    void buildRam(String ram);
    void buildStorage(String storage);
    void buildDisplay(String display);
    Laptop getLaptop();
}