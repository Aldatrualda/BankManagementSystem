package bankManagementSystem.formAccounts;

import bankManagementSystem.actions.Deposit;
import bankManagementSystem.actions.Login;
import bankManagementSystem.connectionToSQL.SetConnectionToMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpAccountDetailsForm3 extends JFrame implements ActionListener {
    JRadioButton saving, fixedDeposit, retirementAccount, salaryAccount;
    JLabel accountDetails, accountType, cardNumber, pin, phoneNumber, serviceRequired;
    JCheckBox ATMCard, internetBanking, mobileBanking, emailAndSMSNotifications, declaration;
    JButton submit, cancel;
    String uniqueRandomNumber;

    public SignUpAccountDetailsForm3(String uniqueRandomNumber) {
        this.uniqueRandomNumber = uniqueRandomNumber;

        // Setting the label "Account details"
        this.setLabelAccountDetails();

        // Setting various types of account
        this.setLabelAccountAndButtons();

        // Setting lines of card number, PIN, phone number
        this.setLabelCardNumberAndPINAndPhoneNumber();

        // Setting the label "Service required: " and check boxes such as atm card, internet banking, mobile banking,
        // email and SMS notifications, declaration
        this.setLabelServiceRequired();

        //Setting two buttons such as submit and cancel
        this.setButtonsSubmitAndCancel();


        this.setLayout(null);
        this.setSize(800, 700);
        this.setLocation(350, 10);
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // region Methods
    void setLabelAccountDetails() {
        accountDetails = new JLabel("Form №3: Account details");
        accountDetails.setFont(new Font("Times new roman", Font.BOLD, 28));
        accountDetails.setBounds(220, 80, 400, 30);
        add(accountDetails);
    }

    void setLabelAccountAndButtons() {
        accountType = new JLabel("Account type: ");
        accountType.setFont(new Font("Times new roman", Font.BOLD, 20));
        accountType.setBounds(80, 140, 180, 30);
        add(accountType);

        //Buttons of different account's types
        saving = new JRadioButton("Saving account");
        saving.setFont(new Font("Times new roman", Font.BOLD, 18
        ));
        saving.setBounds(80, 180, 180, 30);
        saving.setBackground(Color.WHITE);
        add(saving);

        fixedDeposit = new JRadioButton("Fixed deposit account");
        fixedDeposit.setFont(new Font("Times new roman", Font.BOLD, 18));
        fixedDeposit.setBounds(80, 220, 300, 30);
        fixedDeposit.setBackground(Color.WHITE);
        add(fixedDeposit);

        retirementAccount = new JRadioButton("Retirement account");
        retirementAccount.setFont(new Font("Times new roman", Font.BOLD, 18));
        retirementAccount.setBounds(380, 180, 300, 30);
        retirementAccount.setBackground(Color.WHITE);
        add(retirementAccount);

        salaryAccount = new JRadioButton("Salary account");
        salaryAccount.setFont(new Font("Times new roman", Font.BOLD, 18));
        salaryAccount.setBounds(380, 220, 300, 30);
        salaryAccount.setBackground(Color.WHITE);
        add(salaryAccount);

        ButtonGroup accountGroup = new ButtonGroup();
        accountGroup.add(saving);
        accountGroup.add(fixedDeposit);
        accountGroup.add(retirementAccount);
        accountGroup.add(salaryAccount);
    }

    void setLabelCardNumberAndPINAndPhoneNumber() {
        cardNumber = new JLabel("Card number: ");
        cardNumber.setFont(new Font("Times new roman", Font.BOLD, 20));
        cardNumber.setBounds(80, 280, 200, 30);
        add(cardNumber);

        pin = new JLabel("PIN: ");
        pin.setFont(new Font("Times new roman", Font.BOLD, 20));
        pin.setBounds(80, 320, 200, 30);
        add(pin);

        phoneNumber = new JLabel("Phone number: ");
        phoneNumber.setFont(new Font("Times new roman", Font.BOLD, 20));
        phoneNumber.setBounds(80, 360, 200, 30);
        add(phoneNumber);
    }

    void setLabelServiceRequired() {
        serviceRequired = new JLabel("Service Required: ");
        serviceRequired.setFont(new Font("Times new roman", Font.BOLD, 20));
        serviceRequired.setBounds(80, 400, 200, 30);
        add(serviceRequired);

        ATMCard = new JCheckBox("ATM card");
        ATMCard.setFont(new Font("Times new roman", Font.BOLD, 18));
        ATMCard.setBounds(80, 440, 200, 30);
        ATMCard.setBackground(Color.WHITE);
        add(ATMCard);

        internetBanking = new JCheckBox("Internet banking");
        internetBanking.setFont(new Font("Times new roman", Font.BOLD, 18));
        internetBanking.setBounds(80, 480, 200, 30);
        internetBanking.setBackground(Color.WHITE);
        add(internetBanking);

        mobileBanking = new JCheckBox("Mobile banking");
        mobileBanking.setFont(new Font("Times new roman", Font.BOLD, 18));
        mobileBanking.setBounds(380, 440, 200, 30);
        mobileBanking.setBackground(Color.WHITE);
        add(mobileBanking);

        emailAndSMSNotifications = new JCheckBox("Email and SMS notifications");
        emailAndSMSNotifications.setFont(new Font("Times new roman", Font.BOLD, 18));
        emailAndSMSNotifications.setBounds(380, 480, 400, 30);
        emailAndSMSNotifications.setBackground(Color.WHITE);
        add(emailAndSMSNotifications);

        declaration = new JCheckBox("I hereby declare that the information provided is true and correct.");
        declaration.setFont(new Font("Times new roman", Font.BOLD, 18));
        declaration.setBounds(80, 520, 600, 30);
        declaration.setBackground(Color.WHITE);
        add(declaration);
    }

    void setButtonsSubmitAndCancel() {
        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Times new roman", Font.BOLD, 18));
        cancel.setBounds(220, 580, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        submit = new JButton("Submit");
        submit.setFont(new Font("Times new roman", Font.BOLD, 18));
        submit.setBounds(420, 580, 100, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
    }
    //endregion

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountType = "";
            if (saving.isSelected()) {
                accountType = "Saving account";
            } else if (fixedDeposit.isSelected()) {
                accountType = "Fixed deposit account";
            } else if (retirementAccount.isSelected()) {
                accountType = "Retirement account";
            } else if (salaryAccount.isSelected()) {
                accountType = "Salary account";
            }

            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if (ATMCard.isSelected()) {
                facility += " ATM card";
            } else if (internetBanking.isSelected()) {
                facility += " Internet banking";
            } else if (mobileBanking.isSelected()) {
                facility += " Mobile banking";
            } else if (emailAndSMSNotifications.isSelected()) {
                facility += " Email and SMS notifications";
            }

            try {
                if (accountType.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Account type is required.");
                } else {
                    //Connect to SQL
                    SetConnectionToMySQL setConnectionToMySQL = new SetConnectionToMySQL();
                    String queryForSignUpAccountDetails = "insert into signUpAccountDetails values ('" + uniqueRandomNumber + "', '" + accountType + "', '" + cardNumber + "', '"
                            + pinNumber + "', '" + facility + "')";

                    String queryForLogin = "insert into login values ('" + uniqueRandomNumber + "', '" + cardNumber + "', '" + pinNumber + "')";

                    //Submit queries
                    setConnectionToMySQL.s.executeUpdate(queryForSignUpAccountDetails);
                    setConnectionToMySQL.s.executeUpdate(queryForLogin);

                    //Show information such as cardNumber and PIN on screen
                    JOptionPane.showMessageDialog(null, "Card number " + cardNumber + "\nPIN: " + pinNumber);

                    setVisible(false);
                    new Deposit(pinNumber).setVisible(false);
                }
            } catch (Exception e) {
                System.out.println("Mistake is " + e);
            }

        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
}
