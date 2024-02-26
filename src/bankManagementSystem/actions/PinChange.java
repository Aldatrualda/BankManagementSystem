package bankManagementSystem.actions;

import bankManagementSystem.connectionToSQL.SetConnectionToMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {
    ImageIcon imageIcon, setImage;
    Image atmImage;
    JLabel image, text, pinText, pinTextReenter;
    JPasswordField textFieldPin, textFieldPinReenter;
    JButton changePIN, back;
    String pinNumber;

    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        //Set ATM image
        this.setATMImage();

        //Set text "Change your pin"
        this.setTextOnTheImage();

        //Set text "Enter new PIN"
        this.pinText();

        //Set text field for PIN
        this.setTextFieldPin();

        //Set text "Re-enter new PIN"
        this.pinTextReenter();

        //Set text field for PIN
        this.setTextFieldPinReenter();

        //Set buttons "change" and "back"
        this.setButtonChange();
        this.setButtonBack();


        this.setSize(900, 900);
        this.setLocation(300, 0);
        setUndecorated(true);
        this.setVisible(true);
    }

    //region Methods
    void setATMImage() {
        imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        atmImage = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        setImage = new ImageIcon(atmImage);
        image = new JLabel(setImage);
        image.setBounds(0, 0, 900, 900);
        add(image);
    }

    void setTextOnTheImage() {
        text = new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(270, 300, 500, 35);
        image.add(text);
    }

    void pinText() {
        pinText = new JLabel("Enter your new PIN:");
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(165, 360, 500, 25);
        image.add(pinText);
    }

    void setTextFieldPin() {
        textFieldPin = new JPasswordField();
        textFieldPin.setFont(new Font("Raleway", Font.BOLD, 25));
        textFieldPin.setBounds(350, 360, 140, 25);
        image.add(textFieldPin);
    }

    void pinTextReenter() {
        pinTextReenter = new JLabel("Re-enter your new PIN:");
        pinTextReenter.setForeground(Color.WHITE);
        pinTextReenter.setFont(new Font("System", Font.BOLD, 16));
        pinTextReenter.setBounds(165, 400, 500, 25);
        image.add(pinTextReenter);
    }

    void setTextFieldPinReenter() {
        textFieldPinReenter = new JPasswordField();
        textFieldPinReenter.setFont(new Font("Raleway", Font.BOLD, 25));
        textFieldPinReenter.setBounds(350, 400, 140, 25);
        image.add(textFieldPinReenter);
    }

    void setButtonChange() {
        changePIN = new JButton("Change");
        changePIN.setBounds(370, 480, 120, 25);
        changePIN.addActionListener(this);
        image.add(changePIN);
    }

    void setButtonBack() {
        back = new JButton("Back");
        back.setBounds(165, 480, 120, 25);
        back.addActionListener(this);
        image.add(back);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == changePIN) {
            try {
                String newPin = textFieldPin.getText();
                String reenterPin = textFieldPinReenter.getText();
                if (!newPin.equals(reenterPin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                }

                if (newPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }

                SetConnectionToMySQL setConnectionToMySQL = new SetConnectionToMySQL();
                String queryBank = "update bank set pin = '" + reenterPin + "' where pin = '" + pinNumber + "'";
                String queryLogin = "update login set pinNumber = '" + reenterPin + "' where pinNumber = '" + pinNumber + "'";
                String querySignupAccountDetails = "update signupaccountdetails set pinNumber = '" + reenterPin + "' where pinNumber = '" + pinNumber + "'";
                setConnectionToMySQL.s.executeUpdate(queryBank);
                setConnectionToMySQL.s.executeUpdate(queryLogin);
                setConnectionToMySQL.s.executeUpdate(querySignupAccountDetails);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");

                setVisible(false);
                new Transactions(reenterPin).setVisible(true);

            } catch (Exception e) {
                System.out.println("Mistake is " + e);
            }
        } else {
            this.setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
//endregion
}
