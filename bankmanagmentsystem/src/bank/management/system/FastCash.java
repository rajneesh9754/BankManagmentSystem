package bank.management.system;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import  java.util.*;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit,withdrawl,FastCash,balanceenquiry,ministatement,exit,pinChange;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Withdrawl amount");
        text.setBounds(225,300,700,35);
        text.setFont(new Font("SF Pro Display",Font.PLAIN,16));
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(160,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 200");
        withdrawl.setBounds(360,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        FastCash = new JButton("Rs 500");
        FastCash.setBounds(160,450,150,30);
        FastCash.addActionListener(this);
        image.add(FastCash);

        ministatement = new JButton("Rs 1000");
        ministatement.setBounds(360,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinChange = new JButton("Rs 5000");
        pinChange.setBounds(160,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(360,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("BACK");
        exit.setBounds(360,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,800);
        setLocation(500,200);
        setUndecorated(true);
        setVisible(true);

        getContentPane().setBackground(Color.white);
    }

    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            String query2 = "select * from bank where pinno = '"+pinnumber+"'";
            int Balance = 0;
            try{
                ResultSet rs = conn.s.executeQuery(query2);
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        Balance += Integer.parseInt(rs.getString("amount"));

                    }
                    else {
                        Balance -= Integer.parseInt(rs.getString("amount"));

                    }
                }
                if(ae.getSource() != exit && Balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Your balance is not sufficient");

                }

                java.util.Date date = new java.util.Date();

                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"');";
                conn.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Rs. "+amount+" debited successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }


        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
