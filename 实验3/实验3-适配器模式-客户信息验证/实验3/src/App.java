public class App {
    public static void main(String[] args) {
        LaptopDirector director = new LaptopDirector();

        LaptopBuilder gamingLaptopBuilder = new GamingLaptopBuilder();
        director.setLaptopBuilder(gamingLaptopBuilder);
        Laptop gamingLaptop = director.buildLaptop();
        System.out.println("Gaming Laptop: " + gamingLaptop);

        LaptopBuilder businessLaptopBuilder = new BusinessLaptopBuilder();
        director.setLaptopBuilder(businessLaptopBuilder);
        Laptop businessLaptop = director.buildLaptop();
        System.out.println("Business Laptop: " + businessLaptop);
    }
}