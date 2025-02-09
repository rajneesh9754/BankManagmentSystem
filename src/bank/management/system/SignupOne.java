package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameTextField,fnameTextField,dobTextField,mailTextField,addressTextField,cityTextField,StateTextField,PCodeTextField;
    JRadioButton single,married,male ,female;
    JButton next;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L)+1000L);

        JLabel formno = new JLabel("Application no: " + random);
        formno.setFont(new Font("Poppins",Font.BOLD,38));
        formno.setBounds(200,20,600,40);
        add(formno);

        JLabel PersonalDetails = new JLabel("PersonalDetails: Page 1 ");
        PersonalDetails.setFont(new Font("Poppins",Font.BOLD,24));
        PersonalDetails.setBounds(270,80,600,30);
        add(PersonalDetails);


        JLabel Name = new JLabel("Name:");
        Name.setFont(new Font("Poppins",Font.BOLD,22));
        Name.setBounds(100,130,100,30);
        add(Name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Noto Sans",Font.BOLD,15));
        nameTextField.setBounds(300,130,400,30);
        add(nameTextField);

        JLabel fName = new JLabel("Father's Name:");
        fName.setFont(new Font("Poppins",Font.BOLD,22));
        fName.setBounds(100,180,200,30);
        add(fName);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Noto Sans",Font.BOLD,15));
        fnameTextField.setBounds(300,180,400,30);
        add(fnameTextField);

        JLabel DOB = new JLabel("Date Of Birth:");
        DOB.setFont(new Font("Poppins",Font.BOLD,22));
        DOB.setBounds(100,230,200,30);
        add(DOB);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,230,400,30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Poppins",Font.BOLD,22));
        gender.setBounds(100,280,100,30);
        add(gender);

        male = new JRadioButton("male");
        male.setBounds(300,280,100,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("female");
        female.setBounds(450,280,100,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Poppins",Font.BOLD,22));
        email.setBounds(100,330,100,30);
        add(email);

        mailTextField = new JTextField();
        mailTextField.setFont(new Font("Noto Sans",Font.BOLD,15));
        mailTextField.setBounds(300,330,400,30);
        add(mailTextField);

        JLabel MStatus = new JLabel("Marital Status:");
        MStatus.setFont(new Font("Poppins",Font.BOLD,22));
        MStatus.setBounds(100,380,200,30);
        add(MStatus);

        married = new JRadioButton("married");
        married.setBounds(300,380,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        single = new JRadioButton("single");
        single.setBounds(450,380,100,30);
        single.setBackground(Color.white);
        add(single);

        ButtonGroup mStat = new ButtonGroup();
        mStat.add(married);
        mStat.add(single);

        JLabel Address = new JLabel("Address:");
        Address.setFont(new Font("Poppins",Font.BOLD,22));
        Address.setBounds(100,430,100,30);
        add(Address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Noto Sans",Font.BOLD,15));
        addressTextField.setBounds(300,430,400,30);
        add(addressTextField);

        JLabel City = new JLabel("City:");
        City.setFont(new Font("Poppins",Font.BOLD,22));
        City.setBounds(100,480,100,30);
        add(City);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Noto Sans",Font.BOLD,15));
        cityTextField.setBounds(300,480,400,30);
        add(cityTextField);

        JLabel State = new JLabel("State:");
        State.setFont(new Font("Poppins",Font.BOLD,22));
        State.setBounds(100,530,100,30);
        add(State);

        StateTextField = new JTextField();
        StateTextField.setFont(new Font("Noto Sans",Font.BOLD,15));
        StateTextField.setBounds(300,530,400,30);
        add(StateTextField);

        JLabel PCode = new JLabel("PinCode:");
        PCode.setFont(new Font("Poppins",Font.BOLD,22));
        PCode.setBounds(100,580,130,30);
        add(PCode);

        PCodeTextField = new JTextField();
        PCodeTextField.setFont(new Font("Noto Sans",Font.BOLD,15));
        PCodeTextField.setBounds(300,580,400,30);
        add(PCodeTextField);

        next = new JButton("NEXT");
        next.setForeground(Color.white);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Poppins",Font.BOLD,16));
        next.setBounds(600,660,100,30);
        next.addActionListener(this);
        add(next);


        setSize(880,850);
        setLocation(350,40);
        setVisible(true);

        getContentPane().setBackground(Color.white);

    }

    public void actionPerformed(ActionEvent ae) {
        String formno = ""+ random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if (female.isSelected()){
            gender = "female";
        }
        String email = mailTextField.getText();
        String mariStat = null;
        if(married.isSelected()) {
            mariStat = "Married";
        }
        else if (single.isSelected()){
                mariStat = "Single";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = StateTextField.getText();
        String pCode = PCodeTextField.getText();

        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Mandatory");
            }else {
                Conn c = new Conn();

                String query = "insert into signup values('"+formno+"' ,'"+name+"' ,'"+fname+"' ,'"+dob+"' ,'"+gender+"' ,'"+email+"' , '"+mariStat+"' ,'"+address+"' ,'"+city+"' ,'"+state+"' ,'"+pCode+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupOne();
    }
}