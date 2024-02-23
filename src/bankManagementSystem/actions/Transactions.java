package bankManagementSystem.actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    ImageIcon imageIcon, setImage;
    Image atmImage;
    JLabel image, text;
    JButton deposit, ministatement, withdraw, pinChange, balance, exit;
    String pinNumber;

    public Transactions(String pinNumber) {
        this.pinNumber = pinNumber;
        //Set ATM image
        this.setAtmImage();

        //Set text label "Please select your transaction"
        this.setTextLabelToSelectTransaction();

        //Set buttons such as deposit, ministatement, withdrawal, pinChange, balance, exit
        this.setButtonsOfTransactions();

        this.setSize(900, 900);
        this.setLocation(300, 0);
        this.setUndecorated(true);
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

    void setTextLabelToSelectTransaction() {
        text = new JLabel("Please select your transaction");
        text.setBounds(210, 300, 700, 35);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);
    }

    void setButtonsOfTransactions() {
        deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        ministatement = new JButton("Account information");
        ministatement.setBounds(170, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(335, 415, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        pinChange = new JButton("Change Pin");
        pinChange.setBounds(335, 450, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balance = new JButton("Balance enquiry");
        balance.setBounds(170, 485, 150, 30);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("Exit");
        exit.setBounds(335, 485, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
    }
    //endregion

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if (ae.getSource() == withdraw) {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        }
    }
}
