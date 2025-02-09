package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Enter the amount you want to WtihDraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(200,300,700,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("System",Font.PLAIN,14));
        amount.setBounds(250,340,200,25);
        amount.setBackground(Color.white);
        image.add(amount);

        withdraw = new JButton("WITHDRAW");
        withdraw.setFont(new Font("System",Font.PLAIN,14));
        withdraw.setBounds(390,485,120,25);
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.black);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("BACK");
        back.setFont(new Font("System",Font.PLAIN,14));
        back.setBounds(390,515,120,25);
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
        if (ae.getSource() == withdraw){
            String number = amount.getText();
            Date date = new Date();
            String type = "Withdraw";
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }else{
                try {
                    Conn conn = new Conn();
                    String query = "insert into bank values ('"+pinnumber+"' ,'"+date+"' ,'"+type+"' ,'"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs. "+number+" withdraw from your account");

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

