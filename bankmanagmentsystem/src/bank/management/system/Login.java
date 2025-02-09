package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;



public class Login extends JFrame implements ActionListener {
    JButton signup,clear,signin;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("Automatic Teller Machine");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Arial",Font.BOLD,40));
        text.setBounds(200,40,400,40);
        add(text);


        JLabel card = new JLabel("Card No:");
        card.setFont(new Font("SF Pro Display",Font.BOLD,30));
        card.setBounds(150,150,150,30);
        add(card);

        cardTextField = new JTextField();
        cardTextField.setFont(new Font("Open Sans",Font.BOLD,14));
        cardTextField.setBounds(300,150,230,30);
        add(cardTextField);


        JLabel pin = new JLabel("Pin: ");
        pin.setFont(new Font("SF Pro Display",Font.BOLD,30));
        pin.setBounds(150,200,150,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,200,230,30);
        pinTextField.setFont(new Font("Open Sans",Font.BOLD,14));
        add(pinTextField);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,250,100,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        clear = new JButton("CLEAR");
        clear.setBounds(430,250,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        signin = new JButton("SIGN IN");
        signin.setBounds(300,300,230,30);
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);

        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setVisible(true);
        setLocation(550,300);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);

        }else if (ae.getSource() == signin){

            try{
                Conn c = new Conn();
                String cardnumber = cardTextField.getText();
                String pinnumber = pinTextField.getText();
                String query = "select * from login where cardno = '"+cardnumber+"' and pinno = '"+pinnumber+"'";

                ResultSet res = c.s.executeQuery(query);
                if (res.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);

                }else {
                    JOptionPane.showMessageDialog(null,"Incorrect CardNo or Pin");
                }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        }
    }
    public static void main(String[] args) { 
        new Login();
    }

}
