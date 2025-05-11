import javax.swing.*;
public class AirConditionOnBtn extends JButton implements Command {
      public AirConditionOnBtn(String name) {
        super(name);
    }
     public void execute(JPanel panel){
         GAirConditioner airConditioner = new GAirConditioner(panel);
         airConditioner.open();
     }
}
