package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox sr1,sr2,sr3,sr4 ,sr5,sr6,sr7;
    JButton submit,cancel,done;
    String formno;
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("Account Details");

        JLabel accountDetails = new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Poppins", Font.BOLD,28));
        accountDetails.setBounds(200,20,400,30);
        add(accountDetails);

        JLabel l2 = new JLabel("Account Type");
        l2.setFont(new Font("Poppins", Font.BOLD,22));
        l2.setBounds(100,70,200,30);
        add(l2);

        r1 = new JRadioButton("Saving Account Account");
        r1.setBackground(Color.white);
        r1.setFont(new Font("Poppins",Font.BOLD,16));
        r1.setBounds(100,120,250,30);
        add(r1);


        r2 = new JRadioButton("Current Account");
        r2.setBackground(Color.white);
        r2.setFont(new Font("Poppins",Font.BOLD,16));
        r2.setBounds(400,120,250,30);
        add(r2);

        r3 = new JRadioButton("Reccuring-Deposit Account");
        r3.setBackground(Color.white);
        r3.setFont(new Font("Poppins",Font.BOLD,16));
        r3.setBounds(100,170,270,30);
        add(r3);

        r4 = new JRadioButton("Fixed-Deposit Account");
        r4.setBackground(Color.white);
        r4.setFont(new Font("Poppins",Font.BOLD,16));
        r4.setBounds(400,170,250,30);
        add(r4);


        ButtonGroup accTyp = new ButtonGroup();
        accTyp.add(r1);
        accTyp.add(r2);
        accTyp.add(r3);
        accTyp.add(r4);

        JLabel l3 = new JLabel("Card No: ");
        l3.setFont(new Font("Poppins",Font.BOLD,22));
        l3.setBounds(100,220,200,30);
        add(l3);

        JLabel l4 = new JLabel("XXXX-XXXX-XXXX-3112");
        l4.setFont(new Font("Poppins",Font.PLAIN,22));
        l4.setBounds(300,220,300,30);
        add(l4);

        JLabel l7 = new JLabel("Your 16 digit card number");
        l7.setFont(new Font("Poppins",Font.BOLD,12));
        l7.setBounds(100,250,300,15);
        add(l7);


        JLabel l5 = new JLabel("Pin: ");
        l5.setFont(new Font("Poppins",Font.BOLD,22));
        l5.setBounds(100,280,200,30);
        add(l5);

        JLabel l6 = new JLabel("XXXX");
        l6.setFont(new Font("Poppins",Font.PLAIN,22));
        l6.setBounds(300,280,300,30);
        add(l6);

        JLabel l8 = new JLabel("This is your 4 digit pin");
        l8.setFont(new Font("Poppins",Font.BOLD,12));
        l8.setBounds(100,310,300,15);
        add(l8);

        JLabel services = new JLabel("Services ");
        services.setFont(new Font("Poppins",Font.BOLD,22));
        services.setBounds(100,340,200,30);
        add(services);

        sr1 = new JCheckBox("ATM Card");
        sr1.setBackground(Color.WHITE);
        sr1.setFont(new Font("Poppins",Font.BOLD,16));
        sr1.setBounds(100,390,250,20);
        add(sr1);


        sr2 = new JCheckBox("Internet Banking");
        sr2.setBackground(Color.white);
        sr2.setFont(new Font("Poppins",Font.BOLD,16));
        sr2.setBounds(400,390,250,20);
        add(sr2);

        sr3 = new JCheckBox("Mobile Banking");
        sr3.setBackground(Color.white);
        sr3.setFont(new Font("Poppins",Font.BOLD,16));
        sr3.setBounds(100,430,270,20);
        add(sr3);

        sr4 = new JCheckBox("SMS & E-Mail Alerts");
        sr4.setBackground(Color.white);
        sr4.setFont(new Font("Poppins",Font.BOLD,16));
        sr4.setBounds(400,430,250,20);
        add(sr4);

        sr5 = new JCheckBox("CheckBook");
        sr5.setBackground(Color.white);
        sr5.setFont(new Font("Poppins",Font.BOLD,16));
        sr5.setBounds(100,470,270,20);
        add(sr5);

        sr6 = new JCheckBox("E Statement");
        sr6.setBackground(Color.white);
        sr6.setFont(new Font("Poppins",Font.BOLD,16));
        sr6.setBounds(400,470,250,20);
        add(sr6);


        sr7 = new JCheckBox("I, hereby ,declares that the information given above is 100% correct to my knowledge.");
        sr7.setBackground(Color.white);
        sr7.setFont(new Font("Poppins",Font.BOLD,14));
        sr7.setBounds(100,520,600,15);
        sr7.addActionListener(this);
        add(sr7);

        submit = new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Noto Sans",Font.BOLD,15));
        submit.setBounds(350,560,120,20);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Noto Sans",Font.BOLD,15));
        cancel.setBounds(500,560,120,20);
        cancel.addActionListener(this);
        add(cancel);

        done = new JButton("DONE");
        done.setBackground(Color.BLACK);
        done.setForeground(Color.white);
        done.setFont(new Font("Noto Sans",Font.BOLD,15));
        done.setBounds(500,600,120,20);
        done.addActionListener(this);
        add(done);


        setSize(800,750);
        setVisible(true);
        setLocation(550,150);
        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String AccountType = null;
            if(r1.isSelected()){
                AccountType = "Saving";
            } else if (r2.isSelected()) {
                AccountType = "Current";
            } else if (r4.isSelected()) {
                AccountType = "Fixed Deposit";
            } else if (r3.isSelected()) {
                AccountType = "Reccuring Deposit";
            }

            Random random = new Random();
            long first7 = Math.abs(random.nextLong() % 90000000L) + 9811830000000000L;
            String CardNo = ""+ first7 ;

            Random randomPin = new Random();
            long first4 = Math.abs(randomPin.nextLong() % 9000L) + 1000L;
            String CardPinNo = ""+ first4;

            String facility = "";
            if (sr1.isSelected()){
                facility += "ATM Card";
            }
            if (sr2.isSelected()){
                facility += " Internet Banking";
            }
            if (sr3.isSelected()){
                facility += " Moblile Banking";
            }
            if (sr4.isSelected()){
                facility += " SMS & E-Mail Alerts";
            }
            if (sr5.isSelected()){
                facility += " CheckBook";
            }
            if (sr6.isSelected()){
                facility += " E Statement";
            }

            try{
                if (AccountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account type is must.");
                }
                if(!sr7.isSelected()){
                   JOptionPane.showMessageDialog(null,"Check this option to continue further");
                }
                else {
                    Conn c = new Conn();
                    String query = "insert into signupthree values('"+formno+"','"+AccountType+"','"+facility+"','"+CardNo+"','"+CardPinNo+"')";
                    String query2 = "insert into login values('"+formno+"','"+CardNo+"','"+CardPinNo+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Your CardNo is :"+CardNo+"\nYour Pin is: "+CardPinNo);
                    setVisible(false);
                    new Withdrawl(CardPinNo).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);;
            }
        }
        else if(ae.getSource() == done){
            new Login();
        }
        else if(ae.getSource() == cancel){
                setVisible(false);
                new Login().setVisible(true);
        }
    }
    public static void main(String[] args){

        new SignupThree("");
    }
}
