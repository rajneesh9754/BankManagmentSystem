package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener{
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Enter the amount you want to Deposit");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(200,300,700,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System",Font.PLAIN,14));
        amount.setBounds(250,340,200,25);
        amount.setBackground(Color.white);
        image.add(amount);

        deposit = new JButton("DEPOSIT");
        deposit.setFont(new Font("System",Font.PLAIN,14));
        deposit.setBounds(410,485,100,25);
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.black);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("BACK");
        back.setFont(new Font("System",Font.PLAIN,14));
        back.setBounds(410,515,100,25);
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setUndecorated(true);
        setLocation(500,100);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            String type = "Deposit";
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values ('"+pinnumber+"' ,'"+date+"' ,'"+type+"' ,'"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+number+" deposited to your account");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }else if (ae.getSource() == back){
            JOptionPane.showMessageDialog(null,"Transaction is Canceled,\nGoing back to Transction window.");
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args){
        new Withdrawl("");
    }
}
