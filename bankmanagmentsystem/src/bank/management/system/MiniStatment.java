package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;


public class MiniStatment extends JFrame {
    MiniStatment(String pinnumber){
        setTitle("MiniStatement");
        setLayout(null);

        JLabel text = new JLabel();
        add(text);

        JLabel bank = new JLabel("UP National Bank");
        bank.setFont(new Font("Noto Sans",Font.BOLD,15));
        bank.setBounds(120,20,150,15);
        add(bank);

        JLabel card = new JLabel();
        card.setFont(new Font("Noto Sans",Font.PLAIN,14));
        card.setBounds(50,80,300,20);
        add(card);

        JLabel mini = new JLabel();
        mini.setBounds(50,120,450,200);
        add(mini);
        JLabel balance = new JLabel();
        balance.setBounds(20,300,400,20);
        balance.setFont(new Font("Noto Sans",Font.BOLD,16));
        add(balance);

        try{
            Conn conn = new Conn();
            String query = "SELECT * FROM login where pinno = '"+pinnumber+"'";


            ResultSet rs = conn.s.executeQuery(query);
            while (rs.next()){
                card.setText("Card Number : "+rs.getString("cardno").substring(0,4) + "-XXXX-XXXX-"+rs.getString("cardno").substring(12,16));

            }
        }catch (Exception e){
            System.out.println(e);
        }

        try{
            Conn conn = new Conn();
            int bal = 0;
            String query2  = "SELECT * FROM bank WHERE pinno = '"+pinnumber+"'";
            ResultSet res = conn.s.executeQuery(query2);

            while (res.next()){
                mini.setText(mini.getText() +"<html>" +res.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + res.getString("type")  +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + res.getString("amount") +"<br><html>" );
                if (res.getString("type").equals("Deposit")){
                    bal += Integer.parseInt(res.getString("amount"));

                }
                else {
                    bal -= Integer.parseInt(res.getString("amount"));

                }
            }
            balance.setText("Account Balance: Rs."+bal);


        }catch (Exception e){
            System.out.println(e);
        }
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MiniStatment("");
    }

}
