package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PinChange extends JFrame implements ActionListener {
    JButton change,back;
    JTextField pinfield,repinfield;
    String pinnumber;

    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);


        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("Noto Sans",Font.BOLD,20));
        text.setBounds(250,290,400,30);
        image.add(text);

        JLabel pin = new JLabel("New Pin:");
        pin.setForeground(Color.white);
        pin.setFont(new Font("Noto Sans",Font.PLAIN,16));
        pin.setBounds(155,420,180,20);
        image.add(pin);

        JLabel repin = new JLabel("Re-Enter New Pin:");
        repin.setForeground(Color.white);
        repin.setFont(new Font("Noto Sans",Font.PLAIN,16));
        repin.setBounds(155,450,180,20);
        image.add(repin);

        pinfield = new JPasswordField();
        pinfield.setBounds(305,420,180,20);
        pinfield.setBackground(Color.white);
        image.add(pinfield);

        repinfield = new JPasswordField();
        repinfield.setBounds(305,450,180,20);
        repinfield.setBackground(Color.white);
        image.add(repinfield);

        change = new JButton("CHANGE");
        change.setForeground(Color.black);
        change.setBackground(Color.white);
        change.setBounds(410,490,100,25);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setForeground(Color.black);
        back.setBackground(Color.white);
        back.setBounds(410,520,100,25);
        back.addActionListener(this);
        image.add(back);



        setSize(900,900);
//        setUndecorated(true);
        setLocation(500,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change){
            try{
                String npin = pinfield.getText();
                String repin = repinfield.getText();
                if (!npin.equals(repin)){
                    JOptionPane.showMessageDialog(null,"Pin is not matching with the above pin");
                    return;
                }
                if ((npin.equals("") )){
                    JOptionPane.showMessageDialog(null,"New pin field cannot be left empty");
                    return;
                }
                if ( (repin.equals(""))){
                    JOptionPane.showMessageDialog(null,"New repin field cannot be left empty");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pinno = '"+repin+"' where pinno = '"+pinnumber+"'";
                String query2 = "update login set pinno = '"+repin+"' where pinno = '"+pinnumber+"'";
                String query3 = "update signupthree set Pin = '"+repin+"' where Pin = '"+pinnumber+"'";

                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Your pin is changed successfully.\nYour new Pin is: "+repin
                +"returning to the Transactions");
                setVisible(false);
                new Transactions(repin).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }


    }
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
