package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener {
    JButton login, sighUp, clear;
    JTextField cardTextField;
    JPasswordField PINTextField;
    JLabel textOfWelcoming, textOfAskingCardNumber, textOfPIN, label;


    public Login() {

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        //LOGO OF FRAME - Setting a logo for the frame
        setTheFramesLogo();

        //*TEXT - welcoming a customer on the main screen
        printTextOfWelcomingTheCustomer();

        //TEXT - the line says Card №: on the screen
        printingTextToAskTheCardOfCustomer();

        //TEXT FIELD - the field to enter the data of a customer's card (number)
        createFieldToEnterDataCard();

        //TEXT - the line says PIN on the screen
        printingTextToAskThePINOfCustomersCard();

        //TEXT FIELD - the field to enter the data of a customer's card (pin)
        createFieldToEnterPinCard();

        //BUTTON - create a button to sign in
        createButtonToSignIn();

        //BUTTON - create a button to clear the text fields
        createButtonToClearTextFields();

        //BUTTON - create a button to sign up
        createButtonToSighUp();

        //Set the background
        getContentPane().setBackground(Color.WHITE);

        //Set the main frame
        this.setSize(800, 480);
        this.setVisible(true);
        this.setLocation(350, 200);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    // region Methods
    void setTheFramesLogo() {
        ImageIcon mainLogo = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = mainLogo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
    }

    void printTextOfWelcomingTheCustomer() {
        textOfWelcoming = new JLabel("Welcome to ATM");
        textOfWelcoming.setFont(new Font("Times New Roman", Font.BOLD, 38));
        textOfWelcoming.setBounds(200, 40, 400, 40);
        add(textOfWelcoming);
    }

    void printingTextToAskTheCardOfCustomer() {
        textOfAskingCardNumber = new JLabel("Card №:");
        textOfAskingCardNumber.setFont(new Font("Times New Roman", Font.BOLD, 28));
        textOfAskingCardNumber.setBounds(100, 120, 200, 40);
        add(textOfAskingCardNumber);
    }

    void createFieldToEnterDataCard() {
        cardTextField = new JTextField();
        cardTextField.setBounds(250, 120, 230, 40);
        add(cardTextField);
    }

    void printingTextToAskThePINOfCustomersCard() {
        textOfPIN = new JLabel("PIN:");
        textOfPIN.setFont(new Font("Times New Roman", Font.BOLD, 28));
        textOfPIN.setBounds(100, 200, 200, 40);
        add(textOfPIN);
    }

    void createFieldToEnterPinCard() {
        PINTextField = new JPasswordField();
        PINTextField.setBounds(250, 200, 230, 40);
        add(PINTextField);
    }

    void createButtonToSignIn() {
        login = new JButton("SIGN IN");
        login.setBounds(250, 280, 100, 35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
    }

    void createButtonToClearTextFields() {
        clear = new JButton("CLEAR");
        clear.setBounds(380, 280, 100, 35);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
    }

    void createButtonToSighUp() {
        sighUp = new JButton("SIGN UP");
        sighUp.setBounds(250, 330, 230, 35);
        sighUp.setBackground(Color.BLACK);
        sighUp.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(sighUp);
    }
    // endregion

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            PINTextField.setText("");
        } else if (ae.getSource() == login) {

        } else if (ae.getSource() == sighUp) {
            new SignUpPersonalDetails().setVisible(true);
        }
    }
}
