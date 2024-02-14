package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpAdditionalInformation extends JFrame implements ActionListener {
    JLabel additionalDetails, clintStatus, income, VIP, existingAccount;
    JComboBox status, incomeBox;
    JRadioButton VIPYes, VIPNo, existing, notExisting;
    JButton next;

    String uniqueRandomNumber;

    public SignUpAdditionalInformation(String uniqueRandomNumber) {
        this.uniqueRandomNumber = uniqueRandomNumber;
        //Setting the Label "Additional details"
        this.setLabelAdditionalDetails();

        //Setting the label "Clint status" and setting the comboBox
        this.setLabelStatusOfClintAndSetComboBox();

        //Setting the label "Income" and setting the comboBox
        this.setLabelIncomeAndSetComboBox();

        //Setting the label "VIP" and setting the radio buttons
        this.setLabelVIPAndAddRadioButton();

        //Setting the label "Existing account" and setting the radio buttons
        this.setLabelExistingAccount();

        //Setting the NEXT button
        this.setNextButton();

        //Setting the second frame of additional details
        this.setLayout(null);
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(800, 600);
        this.setLocation(350, 10);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    void setLabelAdditionalDetails() {
        additionalDetails = new JLabel("Form №2: Additional details");
        additionalDetails.setFont(new Font("Times new roman", Font.BOLD, 28));
        additionalDetails.setBounds(280, 80, 400, 30);
        add(additionalDetails);
    }

    void setLabelStatusOfClintAndSetComboBox() {
        clintStatus = new JLabel("Clint status: ");
        clintStatus.setFont(new Font("Times new roman", Font.BOLD, 20));
        clintStatus.setBounds(80, 140, 180, 30);
        add(clintStatus);

        String[] validStatusOfClint = {"Legal entity", "Individual entity"};
        status = new JComboBox(validStatusOfClint);
        status.setFont(new Font("Times new roman", Font.BOLD, 20));
        status.setBounds(300, 140, 300, 30);
        status.setBackground(Color.WHITE);
        add(status);
    }

    void setLabelIncomeAndSetComboBox() {
        income = new JLabel("Income: ");
        income.setFont(new Font("Times new roman", Font.BOLD, 20));
        income.setBounds(80, 180, 180, 30);
        add(income);

        String[] validIncomeOfClint = {"< 10.000", "< 100.000", "< 1.000.000", "Other"};
        incomeBox = new JComboBox(validIncomeOfClint);
        incomeBox.setFont(new Font("Times new roman", Font.BOLD, 20));
        incomeBox.setBounds(300, 180, 300, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
    }

    // region Methods
    //    void setLabelFormNumber() {
//
//        //The label to print on the screen the line
//        JLabel formNumber = new JLabel("APPLICATION FORM №" + randomDigital);
//        formNumber.setFont(new Font("Times new roman", Font.BOLD, 38));
//        formNumber.setBounds(140, 20, 600, 40);
//        add(formNumber);
//    }
    void setLabelVIPAndAddRadioButton() {
        VIP = new JLabel("VIP: ");
        VIP.setFont(new Font("Times new roman", Font.BOLD, 20));
        VIP.setBounds(80, 220, 180, 30);
        add(VIP);

        //Add buttons to choose either the clint is VIP or no
        VIPYes = new JRadioButton("Yes");
        VIPYes.setBounds(300, 220, 100, 30);
        VIPYes.setBackground(Color.WHITE);
        add(VIPYes);

        VIPNo = new JRadioButton("No");
        VIPNo.setBounds(420, 220, 100, 30);
        VIPNo.setBackground(Color.WHITE);
        add(VIPNo);

        ButtonGroup VIPGroup = new ButtonGroup();
        VIPGroup.add(VIPYes);
        VIPGroup.add(VIPNo);
    }

    void setLabelExistingAccount() {
        existingAccount = new JLabel("Existing account: ");
        existingAccount.setFont(new Font("Times new roman", Font.BOLD, 20));
        existingAccount.setBounds(80, 260, 180, 30);
        add(existingAccount);

        //Add buttons to choose either the clint has an existing account or no
        existing = new JRadioButton("Yes");
        existing.setBounds(300, 260, 100, 30);
        existing.setBackground(Color.WHITE);
        add(existing);

        notExisting = new JRadioButton("No");
        notExisting.setBounds(420, 260, 100, 30);
        notExisting.setBackground(Color.WHITE);
        add(notExisting);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(existing);
        existingGroup.add(notExisting);
    }

    void setNextButton() {
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);

        next.setFont(new Font("Times new roman", Font.BOLD, 18));
        next.setBounds(660, 510, 80, 30);
        next.addActionListener(this);
        add(next);
    }

    // endregion

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formNumber = uniqueRandomNumber;
        String statusOfClient = (String) status.getSelectedItem();
        String income = (String) incomeBox.getSelectedItem();
        String VIP = null;
        if (VIPYes.isSelected()) {
            VIP = "Yes";
        } else if (VIPNo.isSelected()) {
            VIP = "NO";
        }
        String existingAccount = null;
        if (existing.isSelected()) {
            existingAccount = "Yes";
        } else if (notExisting.isSelected()) {
            existingAccount = "NO";
        }

        try {
            SetConnectionToMySQL setConnectionToMySQL = new SetConnectionToMySQL();
            String query = "insert into signUpAdditionalInformation values ('" + formNumber + "', '" + statusOfClient + "', '" + income + "', '"
                    + VIP + "', '" + existingAccount + "')";
            setConnectionToMySQL.s.executeUpdate(query);

            setVisible(false);
            new SignUpAccountDetails(formNumber).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
