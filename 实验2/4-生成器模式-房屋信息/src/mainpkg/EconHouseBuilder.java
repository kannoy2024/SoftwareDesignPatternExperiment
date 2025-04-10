package mainpkg;

import java.awt.*;
import javax.swing.*;

class EconHouseBuilder extends HouseBuilder {
   public static final String SMALL_AREA = "180 sq meters";
   public static final String BIG_AREA = "210 sq meters";
   public static final String LESS_BEDROOM = "2";
   public static final String MORE_BEDROOM = "3";
   public static final String LESS_BATHROOM = "1";
   public static final String MORE_BATHROOM = "2";
   public static final String SMALL_GARAGE = "1-car garage";
   public static final String BIG_GARAGE = "2-car garage";
   public static final String ECONOMY_TYPE = "Economy-type house";

   public EconHouseBuilder() {
      area = null;
      bedroom = null;
      bathroom = null;
      garage = null;
      garden = null;
      swimmingPool = null;
   }

   public void addUIComponents() {
      houseGUI = new JPanel();
      houseGUI.setLayout(new GridLayout(4, 3));
      JLabel label1 = new JLabel("面积:");
      JLabel label2 = new JLabel("卧室数量:");
      JLabel label3 = new JLabel("浴室数量:");
      JLabel label4 = new JLabel("车库类型:");

      JRadioButton areaBtn1 = new JRadioButton(SMALL_AREA);
      JRadioButton areaBtn2 = new JRadioButton(BIG_AREA);
      JRadioButton bedroomBtn1 = new JRadioButton(LESS_BEDROOM);
      JRadioButton bedroomBtn2 = new JRadioButton(MORE_BEDROOM);
      JRadioButton bathroomBtn1 = new JRadioButton(LESS_BATHROOM);
      JRadioButton bathroomBtn2 = new JRadioButton(MORE_BATHROOM);
      JRadioButton garageBtn1 = new JRadioButton(SMALL_GARAGE);
      JRadioButton garageBtn2 = new JRadioButton(BIG_GARAGE);

      ButtonGroup areaGroup = new ButtonGroup();
      ButtonGroup bedroomGroup = new ButtonGroup();
      ButtonGroup bathroomGroup = new ButtonGroup();
      ButtonGroup garageGroup = new ButtonGroup();

      areaGroup.add(areaBtn1);
      areaGroup.add(areaBtn2);
      bedroomGroup.add(bedroomBtn1);
      bedroomGroup.add(bedroomBtn2);
      bathroomGroup.add(bathroomBtn1);
      bathroomGroup.add(bathroomBtn2);
      garageGroup.add(garageBtn1);
      garageGroup.add(garageBtn2);

      houseGUI.add(label1);
      houseGUI.add(areaBtn1);
      houseGUI.add(areaBtn2);
      houseGUI.add(label2);
      houseGUI.add(bedroomBtn1);
      houseGUI.add(bedroomBtn2);
      houseGUI.add(label3);
      houseGUI.add(bathroomBtn1);
      houseGUI.add(bathroomBtn2);
      houseGUI.add(label4);
      houseGUI.add(garageBtn1);
      houseGUI.add(garageBtn2);

      areaBtn1.addActionListener(new AreaListener());
      areaBtn2.addActionListener(new AreaListener());
      bedroomBtn1.addActionListener(new BedroomListener());
      bedroomBtn2.addActionListener(new BedroomListener());
      bathroomBtn1.addActionListener(new BathroomListener());
      bathroomBtn2.addActionListener(new BathroomListener());
      garageBtn1.addActionListener(new GarageListener());
      garageBtn2.addActionListener(new GarageListener());
   }

   public void buildType() {
      house.setType(ECONOMY_TYPE);
   }

   public void buildArea() {
      house.setArea(area);
   }

   public void buildBedroom() {
      house.setBedroom(bedroom);
   }

   public void buildBathroom() {
      house.setBathroom(bathroom);
   }

   public void buildGarage() {
      house.setGarage(garage);
   }

   public void buildGarden() {
      //是因为抽象类要求实现,但是经济房子根本没有花园
   }

   public void buildSwimmingpool() {
      //因为抽象类要求实现,但是经济房子根本没有游泳池
   }
   

   public String getUserRequest() {
      String usrRequest = null;
      if ((area == null) || (bedroom == null) || (bathroom == null) || (garage == null)) {
         usrRequest = "没有选中任何项目";
      } else {
         usrRequest = ECONOMY_TYPE
               + "\nArea =" + area
               + "\nBedroom number= " + bedroom
               + "\nBathroom number = " + bathroom
               + "\nGarage type = " + garage;

      }
      return usrRequest;
   }
}