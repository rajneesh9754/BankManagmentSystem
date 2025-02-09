package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit,withdrawl,FastCash,balanceenquiry,ministatement,exit,pinChange,returntologin;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your transaction");
        text.setBounds(225,300,700,35);
        text.setFont(new Font("SF Pro Display",Font.PLAIN,16));
        text.setForeground(Color.white);
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(160,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(360,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        FastCash = new JButton("Fastcash");
        FastCash.setBounds(160,450,150,30);
        FastCash.addActionListener(this);
        image.add(FastCash);

        ministatement = new JButton("MiniStatement");
        ministatement.setBounds(360,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(160,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(360,485,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        returntologin = new JButton("Return");
        returntologin.setBounds(160,520,150,30);
        returntologin.addActionListener(this);
        image.add(returntologin);

        exit = new JButton("Exit");
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
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == FastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource() == pinChange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource() == ministatement) {
            new MiniStatment(pinnumber).setVisible(true);
        }
        else if (ae.getSource() == returntologin){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("");
    }
}
