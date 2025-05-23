
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.Iterator;

public class TouriststoreGUI  extends JFrame {
   private JSplitPane bigSplitPane;
   private JScrollPane showInfoPane;
   private JPanel btnPanel;
   // private JEditorPane editorPane;
   private JComboBox<String> nationality;
   private JLabel lblName, lblID, nation;
   private JTextField nameText, iDText;
   private String cusName;
   private String cusID;
   private String cusNation;
   private JTextArea display;

   private Dimension size = new Dimension(600, 210);
   private static int divider = 370;
   public static final String TouriststoreGUI  = "TouriststoreGUI ";
   public static final String SUBMIT = "Submit";
   public static final String EXIT = "Exit";

   private BusinessMediator bMediator;
   private ArrayList<String> cusNames;
   private ArrayList<String> candidateCusNames;

   public TouriststoreGUI (BusinessMediator BusinessMediator) {
      super("Mediator Pattern- Touriststore  ");
      bMediator = BusinessMediator;
      setUpChoicePanel();
      setUpScrollPanes();
      cusNames = new ArrayList<String>();
      candidateCusNames = new ArrayList<String>();
      bMediator.registerHotelGUI(this);
   }

   private void setUpChoicePanel() {

      nameText = new JTextField(20);
      iDText = new JTextField(20);

      nationality = new JComboBox<String>();
      nationality.addItem("China");
      nationality.addItem("USA");
      nationality.addItem("England");
      nationality.addItem("France");
      nationality.addItem("Germany");
      nationality.addItem("Russia");
      nationality.addItem("Japan");
      nationality.addItem("Korea");

      lblName = new JLabel("Customer Name:");
      lblID = new JLabel("Customer ID:");
      nation = new JLabel("Nationality:");

      // Create the open button
      JButton submitBtn = new JButton(SUBMIT);
      submitBtn.setMnemonic(KeyEvent.VK_S);
      JButton exitButton = new JButton(EXIT);
      exitButton.setMnemonic(KeyEvent.VK_X);

      ButtonListener btnListener = new ButtonListener();

      // add action Listener
      submitBtn.addActionListener(btnListener);
      exitButton.addActionListener(btnListener);

      btnPanel = new JPanel();

      // ------------------------------------------------
      GridBagLayout gridBag = new GridBagLayout();
      btnPanel.setLayout(gridBag);
      GridBagConstraints gbc = new GridBagConstraints();

      btnPanel.add(lblName);
      btnPanel.add(nameText);
      btnPanel.add(lblID);
      btnPanel.add(iDText);
      btnPanel.add(nation);
      btnPanel.add(nationality);
      btnPanel.add(submitBtn);
      btnPanel.add(exitButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;

      gbc.gridx = 0;
      gbc.gridy = 0;
      gridBag.setConstraints(lblName, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridBag.setConstraints(nameText, gbc);

      gbc.gridx = 0;
      gbc.gridy = 1;
      gridBag.setConstraints(lblID, gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gridBag.setConstraints(iDText, gbc);

      gbc.gridx = 0;
      gbc.gridy = 2;
      gridBag.setConstraints(nation, gbc);
      gbc.gridx = 1;
      gbc.gridy = 2;
      gridBag.setConstraints(nationality, gbc);

      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 15;
      gbc.gridx = 0;
      gbc.gridy = 5;
      gridBag.setConstraints(submitBtn, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 5;
      gridBag.setConstraints(exitButton, gbc);
      // -----------------------------------------------
   }

   private void setUpScrollPanes() {
      Border raisedBevel = BorderFactory.createRaisedBevelBorder();

      // editorPane = new JEditorPane();

      display = new JTextArea(15, 15);
      display.setBorder(raisedBevel);
      showInfoPane = new JScrollPane(display);

      bigSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, btnPanel, showInfoPane);
      bigSplitPane.setDividerLocation(divider);

      getContentPane().add(bigSplitPane);
      setSize(size);
      setVisible(true);
   }

   public void setCusName() {
      cusName = nameText.getText();
   }

   public void setCusID() {
      cusID = iDText.getText();
   }

   public void setCusNation() {
      cusNation = (String) nationality.getSelectedItem();
   }

   public String getCusName() {
      return cusName;
   }

   public String getCusID() {
      return cusID;
   }

   public String getCusNation() {
      return cusNation;
   }

   public void addCustomer(String cus) {
      cusNames.add(cus);
   }

   public void addCandidateCustomer(String cus) {
      candidateCusNames.add(cus);
   }

   public void displayInfoToScreen(String txt) {
      display.append(txt);
   }

   // public void writeReservedCusToDB() {
   //    Iterator<String> e = cusNames.iterator();
   //    while (e.hasNext()) {
   //        String s = (String) e.next();
   //        System.out.println("Writing to DB (reserved): " + s);
   //       // try to write data to DB
   //    }
   // }

   // public void writeCandidateCusToDB() {
   //    String s;
   //    Iterator e = cusNames.iterator();
   //    while (e.hasNext()) {
   //       s = (String) e.next();
   //       // try to write data to DB
   //    }
   // }

   class ButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent ae) {

         if (ae.getActionCommand().equals(EXIT)) {
            System.exit(1);
         }
         if (ae.getActionCommand().equals(SUBMIT)) {
            setCusName();
            setCusID();
            setCusNation();

            String nm = getCusName();
            String id = getCusID();
            String na = getCusNation();

            displayInfoToScreen("\n Tour reserved:\n" + nm);
            displayInfoToScreen("\n" + id);
            displayInfoToScreen("\n" + na);

            String hotelCus = "\n \nCustomer reserved A Tour line: ";
            String cusInfo = hotelCus + "\n Name: " + nm + "\n ID: " + id + "\n Nationality: " + na;
            addCustomer(cusInfo);
            bMediator.addAllCandidateCus(TouriststoreGUI , cusInfo);
            bMediator.updateALlGuis(TouriststoreGUI , cusInfo);
         }
      }
   }

}

/*
 * PRINT all the listed customers
 * 
 * String s;
 * Iterator e = nums.iterator();
 * while (e.hasNext()) {
 * s = (String) e.next();
 * System.out.println(s);
 * }
 */