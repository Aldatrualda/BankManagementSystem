package bankManagementSystem.formAccounts;

import bankManagementSystem.connectionToSQL.SetConnectionToMySQL;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpPersonalDetailsForm1 extends JFrame implements ActionListener {
    long randomDigital;
    Random randomNumber;
    JTextField nameTextField, surnameTextField, emailTextField, addressTextField, PinCodeTextField;
    JButton next;
    JRadioButton male, female;
    JDateChooser dateChooser;

    public SignUpPersonalDetailsForm1() {
        this.setLayout(null);

        // Setting label form number
        this.setFormNumber();

        // Setting label personal details
        this.setLabelPersonalDetails();

        // Setting label name and text field
        this.setNameLabelAndTextField();

        //Setting label surname and text field
        this.setSurnameLabelAndTextField();

        //Setting label - birthday and text field
        this.setBirthdayLabelAndTextField();

        //Setting label - gender and ...
        this.setGenderLabelAndRadioButton();

        //Setting label - email and text field
        this.setEmailLabelAndTextField();

        //Setting label - address and text field
        this.setFullAddressAndTextField();

        //Setting PinCode
        this.setPinCodeAndTextField();

        //Setting NEXT button to switch the application form
        this.setNextButton();

        //Settings of signUps frame
        this.getContentPane().setBackground(Color.WHITE);
        this.setSize(800, 600);
        this.setLocation(350, 10);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // region Methods
    void setFormNumber() {
        //Getting a random number to use it for the application form
        randomNumber = new Random();
        randomDigital = (Math.abs((randomNumber.nextLong() % 9000L) + 1000L));

        //The label to print on the screen the line
        JLabel formNumber = new JLabel("APPLICATION FORM №" + randomDigital);
        formNumber.setFont(new Font("Times new roman", Font.BOLD, 38));
        formNumber.setBounds(140, 20, 600, 40);
        add(formNumber);
    }

    void setLabelPersonalDetails() {
        JLabel personalDetails = new JLabel("Form №1: Personal details");
        personalDetails.setFont(new Font("Times new roman", Font.BOLD, 28));
        personalDetails.setBounds(280, 80, 400, 30);
        add(personalDetails);
    }

    void setNameLabelAndTextField() {
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Times new roman", Font.BOLD, 20));
        name.setBounds(80, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Times new roman", Font.BOLD, 18));
        nameTextField.setBounds(300, 140, 300, 30);
        add(nameTextField);
    }

    void setSurnameLabelAndTextField() {
        JLabel surname = new JLabel("Surname: ");
        surname.setFont(new Font("Times new roman", Font.BOLD, 20));
        surname.setBounds(80, 180, 100, 30);
        add(surname);

        surnameTextField = new JTextField();
        surnameTextField.setFont(new Font("Times new roman", Font.BOLD, 18));
        surnameTextField.setBounds(300, 180, 300, 30);
        add(surnameTextField);
    }

    void setBirthdayLabelAndTextField() {
        JLabel dateOfBirthday = new JLabel("Date of birthday: ");
        dateOfBirthday.setFont(new Font("Times new roman", Font.BOLD, 20));
        dateOfBirthday.setBounds(80, 220, 220, 30);
        add(dateOfBirthday);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 220, 300, 30);
        add(dateChooser);
    }

    void setGenderLabelAndRadioButton() {
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Times new roman", Font.BOLD, 20));
        gender.setBounds(80, 260, 100, 30);
        add(gender);

        //Added buttons to choose the sex of the customer and restrict the choice only between one of them
        male = new JRadioButton("Male");
        male.setBounds(300, 260, 100, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(420, 260, 100, 30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
    }

    void setEmailLabelAndTextField() {
        JLabel email = new JLabel("Email: ");
        email.setFont(new Font("Times new roman", Font.BOLD, 20));
        email.setBounds(80, 300, 100, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Times new roman", Font.BOLD, 18));
        emailTextField.setBounds(300, 300, 300, 30);
        add(emailTextField);
    }

    void setFullAddressAndTextField() {
        JLabel address = new JLabel("The full address:  ");
        address.setFont(new Font("Times new roman", Font.BOLD, 20));
        address.setBounds(80, 340, 180, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Times new roman", Font.BOLD, 18));
        addressTextField.setBounds(300, 340, 300, 30);
        add(addressTextField);
    }

    void setPinCodeAndTextField() {
        JLabel pinCode = new JLabel("Pin code: ");
        pinCode.setFont(new Font("Times new roman", Font.BOLD, 20));
        pinCode.setBounds(80, 380, 100, 30);
        add(pinCode);

        PinCodeTextField = new JTextField();
        PinCodeTextField.setFont(new Font("Times new roman", Font.BOLD, 18));
        PinCodeTextField.setBounds(300, 380, 300, 30);
        add(PinCodeTextField);
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

    //Read information from the text fields in the first form
    @Override
    public void actionPerformed(ActionEvent ae) {
        String formNumber = "" + randomDigital; // long digital
        String name = nameTextField.getText();
        String surname = surnameTextField.getText();
        String dateOfBirthday = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String address = addressTextField.getText();

        try {
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is required");
            } else {
                SetConnectionToMySQL setConnectionToMySQL = new SetConnectionToMySQL();
                String query = "insert into signup values ('" + formNumber + "', '" + name + "', '" + surname + "', '"
                        + dateOfBirthday + "', '" + gender + "', '" + address + "', '" + email + "')";
                setConnectionToMySQL.s.executeUpdate(query);

                setVisible(false);
                new SignUpAdditionalInformationForm2(formNumber).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println("Mistake is " + e);
        }
    }
}
