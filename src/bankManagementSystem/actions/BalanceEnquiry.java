package bankManagementSystem.actions;

import bankManagementSystem.connectionToSQL.SetConnectionToMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    String pinNumber;
    ImageIcon imageIcon, setImage;
    Image atmImage;
    JLabel image, textOfBalance;
    JButton back;
    int balance;


    BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        //Set ATM image
        this.setATMImage();

        //Set button "Back"
        this.setButtonBack();

        //Connect to SQL and count balance
        this.connectionToSQLAndCountBalance();

        //Set label of balance
        this.setLabelBalance();

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

    void setButtonBack() {
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
    }

    void connectionToSQLAndCountBalance() {
        SetConnectionToMySQL setConnectionToMySQL = new SetConnectionToMySQL();
        balance = 0;
        try {
            ResultSet resultSet = setConnectionToMySQL.s.executeQuery("select * from bank where pin = '" + pinNumber + "'");

            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balance -= Integer.parseInt(resultSet.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println("Mistake is " + e);
        }
    }

    void setLabelBalance() {
        textOfBalance = new JLabel("You current account balance is $" + balance);
        textOfBalance.setForeground(Color.WHITE);
        textOfBalance.setBounds(170,300,400,30);
        image.add(textOfBalance);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    //endregion
    public static void main(String[] args) {
        new BalanceEnquiry("1234");
    }

}
