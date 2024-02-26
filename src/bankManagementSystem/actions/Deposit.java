package bankManagementSystem.actions;

import bankManagementSystem.connectionToSQL.SetConnectionToMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    ImageIcon imageIcon, setImage;
    Image atmImage;
    JLabel textEnter, image;
    JTextField amountOfMoney;
    JButton deposit, back;
    String pinNumber;

    public Deposit(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);

        //Set ATM image
        this.setAtmImage();

        //Set the text "Enter the amount of money you want to deposit"
        this.setTextOnTheImage();

        //Set the text field to enter the amount of money
        this.setTextFieldToEnterAmountOfMoney();

        //Set the buttons "Deposit", "Back"
        this.setButtons();


        this.setSize(900, 900);
        this.setLocation(300, 0);
        this.setVisible(true);

    }

    //region Methods
    void setAtmImage() {
        imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        atmImage = imageIcon.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        setImage = new ImageIcon(atmImage);
        image = new JLabel(setImage);
        image.setBounds(0, 0, 900, 900);
        add(image);
    }

    void setTextOnTheImage() {
        textEnter = new JLabel("Enter the amount you want to deposit");
        textEnter.setForeground(Color.WHITE);
        textEnter.setFont(new Font("System", Font.BOLD, 16));
        textEnter.setBounds(190, 300, 350, 35);
        image.add(textEnter);
    }

    void setTextFieldToEnterAmountOfMoney() {
        amountOfMoney = new JTextField();
        amountOfMoney.setFont(new Font("Raleway", Font.BOLD, 22));
        amountOfMoney.setBounds(190, 350, 280, 25);
        image.add(amountOfMoney);
    }

    void setButtons() {
        deposit = new JButton("Deposit");
        deposit.setBounds(355, 485, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
    }

    //endregion

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String amount = amountOfMoney.getText();
            Date date = new Date();
            try {
                if (amount.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
                } else {
                    SetConnectionToMySQL setConnectionToMySQL = new SetConnectionToMySQL();
                    String query = "insert into bank values('" + pinNumber + "', '" + date + "', 'Deposit', '" + amount + "')";
                    setConnectionToMySQL.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, amount + "$ deposited successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println("Mistake is " + e);
            }

        } else if (ae.getSource() == back) {
            setVisible(true);
            new Transactions(pinNumber).setVisible(true);
        }
    }
}
