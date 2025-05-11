import javax.swing.*;
public class AirConditionOffBtn  extends JButton implements Command {
     public AirConditionOffBtn(String name){
          super(name);
     }
     public void execute(JPanel panel){
         GAirConditioner airConditioner = new GAirConditioner(panel);
         airConditioner.close();
     }
}


