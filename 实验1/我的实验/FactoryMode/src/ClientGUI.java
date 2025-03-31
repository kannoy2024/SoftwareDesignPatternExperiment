// This is a client class that uses the factory method pattern

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class ClientGUI extends JFrame {
   private JSplitPane bigSplitPane;
   private JScrollPane showInfoPane;
   private JPanel btnPanel;
   private JComboBox<String> cmbInsuranceType;
   private JLabel lblInsureType;
   private Dimension minimumSize;
   private JTextArea txtForInfo;

   public static final String SHOW = "Show Info";
   public static final String EXIT = "Exit";
   public static final String BODY_INJURY_LIABILITY = "Body Injury Liability";//身体伤害责任
   public static final String COLLISION_COVERAGE = "Collision Coverage";//碰撞保险
   public static final String PERSONAL_INJURY_PROTECTION = "Personal Injury Protection";//人身伤害保险
   public static final String PROPERTY_DAMAGE_LIABILITY = "Property Damage Liability";//财产伤害责任
   public static final String COMPREHENSIVE_COVERAGE = "Comprehensive Coverage";//全程保险
   public static final String LUXURY_CAR_INSURANCE = "Luxury Car Insurance";//高端汽车保险
   public static final String LUXURY = "Luxury";
   public static final String ADVANCED_PERSONAL_INJURY_INSURANCE= "高级人身伤害保险";

   public ClientGUI() {
      super("Factory Method Pattern - Auto Insurance.");
      minimumSize = new Dimension(130, 100);
      setUpChoicePanel();
      setUpScrollPanes();

      setMinimumSize(minimumSize);
   }

   private void setUpChoicePanel() {
      cmbInsuranceType = new JComboBox<>();
      cmbInsuranceType.addItem(BODY_INJURY_LIABILITY);
      cmbInsuranceType.addItem(COLLISION_COVERAGE);
      cmbInsuranceType.addItem(PERSONAL_INJURY_PROTECTION);
      cmbInsuranceType.addItem(PROPERTY_DAMAGE_LIABILITY);
      cmbInsuranceType.addItem(COMPREHENSIVE_COVERAGE);
      cmbInsuranceType.addItem(LUXURY_CAR_INSURANCE);
      cmbInsuranceType.addItem(LUXURY);
      cmbInsuranceType.addItem(ADVANCED_PERSONAL_INJURY_INSURANCE);

      lblInsureType = new JLabel("Insurance Types");

      // Create the open button
      JButton openButton = new JButton(SHOW);
      openButton.setMnemonic(KeyEvent.VK_S);
      JButton exitButton = new JButton(EXIT);
      exitButton.setMnemonic(KeyEvent.VK_X);

      ButtonListener btnListener = new ButtonListener();

      // add action Listener
      openButton.addActionListener(btnListener);
      exitButton.addActionListener(btnListener);

      btnPanel = new JPanel();

      // ------------------------------------------------
      GridBagLayout GridBag = new GridBagLayout();
      btnPanel.setLayout(GridBag);
      GridBagConstraints gbc = new GridBagConstraints();

      btnPanel.add(lblInsureType);
      btnPanel.add(cmbInsuranceType);
      btnPanel.add(openButton);
      btnPanel.add(exitButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;

      gbc.gridx = 0;
      gbc.gridy = 0;
      GridBag.setConstraints(lblInsureType, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      GridBag.setConstraints(cmbInsuranceType, gbc);

      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 15;
      gbc.gridx = 0;
      gbc.gridy = 5;
      GridBag.setConstraints(openButton, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 5;
      GridBag.setConstraints(exitButton, gbc);
      // -----------------------------------------------
   }

   private void setUpScrollPanes() {
      Border raisedBevel = BorderFactory.createRaisedBevelBorder();

      txtForInfo = new JTextArea("Auto insurance information will be shown here.", 20, 30);
      txtForInfo.setFont(new Font("Helvetica", Font.BOLD, 15));

      txtForInfo.setLineWrap(true);
      txtForInfo.setBackground(Color.pink);

      txtForInfo.setBorder(raisedBevel);

      showInfoPane = new JScrollPane(txtForInfo);

      bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, showInfoPane, btnPanel);
      bigSplitPane.setDividerLocation(220);

      getContentPane().add(bigSplitPane);
      setSize(new Dimension(500, 300));
      setVisible(true);
   }

   class ButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent ae) {
         if (ae.getActionCommand().equals(EXIT)) {
            System.exit(1);
         }

         if (ae.getActionCommand().equals(SHOW)) {
            String type = (String) cmbInsuranceType.getSelectedItem();
            PolicyProducer pp = null;

            if (type.equals(BODY_INJURY_LIABILITY)) {
               pp = new BodyPolicy();
            } else if (type.equals(COLLISION_COVERAGE)) {
               pp = new CollPolicy();
            } else if (type.equals(PERSONAL_INJURY_PROTECTION)) {
               pp = new PersonPolicy();
            } else if (type.equals(PROPERTY_DAMAGE_LIABILITY)) {
               pp = new PropPolicy();
            } else if (type.equals(COMPREHENSIVE_COVERAGE)) {
               pp = new ComPolicy();
            } else if (type.equals(LUXURY_CAR_INSURANCE)) {
               pp = new LuxuryCarInsurancePolicy();
            } else if (type.equals(LUXURY)) {
               pp = new LuxuryPolicy();
            } else if (type.equals(ADVANCED_PERSONAL_INJURY_INSURANCE)) {
               pp = new AdvancedPersonPolicy();
            }

            AutoInsurance ai = pp.getPolicyObj();
            String desc = ai.getInfo();
            txtForInfo.setText(desc);
         }
      }
   }

   public static void main(String args[]) {
      ClientGUI frame = new ClientGUI();
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
      });
      frame.setSize(500, 420);
      frame.setVisible(true);
   }
}