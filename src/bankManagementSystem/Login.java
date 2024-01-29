package bankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener {
    JButton login, sighUp, clear;
    JTextField cardTextField;
    JPasswordField PINTextField;

    public Login() {

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon mainLogo = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = mainLogo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        //*TEXT - welcoming a customer on the screen
        JLabel textOfWelcoming = new JLabel("Welcome to ATM");
        textOfWelcoming.setFont(new Font("Times New Roman", Font.BOLD, 38));
        textOfWelcoming.setBounds(200, 40, 400, 40);
        add(textOfWelcoming);

        //TEXT - the line says Card №: on the screen
        JLabel textOfAskingCardNumber = new JLabel("Card №:");
        textOfAskingCardNumber.setFont(new Font("Times New Roman", Font.BOLD, 28));
        textOfAskingCardNumber.setBounds(100, 120, 200, 40);
        add(textOfAskingCardNumber);

        cardTextField = new JTextField();
        cardTextField.setBounds(250, 120, 230, 40);
        add(cardTextField);

        //TEXT - the line says PIN on the screen
        JLabel textOfPIN = new JLabel("PIN:");
        textOfPIN.setFont(new Font("Times New Roman", Font.BOLD, 28));
        textOfPIN.setBounds(100, 200, 200, 40);
        add(textOfPIN);

        PINTextField = new JPasswordField();
        PINTextField.setBounds(250, 200, 230, 40);
        add(PINTextField);

        login = new JButton("SIGN IN");
        login.setBounds(250, 280, 100, 35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(380, 280, 100, 35);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        sighUp = new JButton("SIGN UP");
        sighUp.setBounds(250, 330, 230, 35);
        sighUp.setBackground(Color.BLACK);
        sighUp.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(sighUp);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            PINTextField.setText("");
        } else if (ae.getSource() == login) {

        } else if (ae.getSource() == sighUp) {

        }
    }
}
