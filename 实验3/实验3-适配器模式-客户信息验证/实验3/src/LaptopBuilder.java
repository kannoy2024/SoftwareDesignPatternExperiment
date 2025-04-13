public interface LaptopBuilder {//建造者的接口
    void buildCpu();
    void buildGpu( );
    void buildRam( );
    void buildStorage( );
    void buildDisplay( );
    Laptop getLaptop();
}