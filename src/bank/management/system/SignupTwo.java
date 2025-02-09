package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class SignupTwo extends JFrame implements ActionListener {

    JTextField PANTextField,aadharTextField;
    JRadioButton yes,no,syes ,sno;
    JButton next;
    JComboBox category,relegion,Incomecategory,Qualification,occupation;
    String formno;

    SignupTwo(String formno){
        formno = this.formno;
        setLayout(null);
        setTitle("New Account Application : Part 2");

        JLabel AdditionalDetails = new JLabel("Page 2: AdditionalDetails");
        AdditionalDetails.setFont(new Font("Poppins",Font.BOLD,24));
        AdditionalDetails.setBounds(270,80,600,30);
        add(AdditionalDetails);


        JLabel Relegion = new JLabel("Religion:");
        Relegion.setFont(new Font("Poppins",Font.BOLD,22));
        Relegion.setBounds(100,130,100,30);
        add(Relegion);

        String valRelegion[] = {"Hindu","Muslim","Sikh","Christian","Others",};
        relegion = new JComboBox(valRelegion);
        relegion.setBackground(Color.white);
        relegion.setFont(new Font("Noto Sans",Font.BOLD,15));
        relegion.setBounds(300,130,400,30);
        add(relegion);



        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Poppins",Font.BOLD,22));
        Category.setBounds(100,180,200,30);
        add(Category);

        String cate[] = {"General","OBC","SC/ST","General EWS","Others"};
        category = new JComboBox(cate);
        category.setBackground(Color.white);
        category.setFont(new Font("Noto Sans",Font.BOLD,15));
        category.setBounds(300,180,400,30);
        add(category);

        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Poppins",Font.BOLD,22));
        Income.setBounds(100,230,200,30);
        add(Income);

        String Incomecate[] = {"0-1,00,000","1,00,000-5,00,000","5,00,000-10,00,000","10,00,000 & above"};
        Incomecategory = new JComboBox(Incomecate);
        Incomecategory.setBackground(Color.white);
        Incomecategory.setFont(new Font("Noto Sans",Font.BOLD,15));
        Incomecategory.setBounds(300,230,400,30);
        add(Incomecategory);


        JLabel gender = new JLabel("Educational:");
        gender.setFont(new Font("Poppins",Font.BOLD,22));
        gender.setBounds(100,280,150,30);
        add(gender);

        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Poppins",Font.BOLD,22));
        email.setBounds(100,320,170,30);
        add(email);

        String education[] = {"Illiterate","High School","Intermediate","Graduation","Post-Graduation"};
        Qualification = new JComboBox(education);
        Qualification.setBackground(Color.white);
        Qualification.setFont(new Font("Noto Sans",Font.BOLD,15));
        Qualification.setBounds(300,330,400,30);
        add(Qualification);


        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Poppins",Font.BOLD,22));
        Occupation.setBounds(100,380,200,30);
        add(Occupation);

        String Occup[] = {"Agriculture","Business","Salaried","Retired","Student"};
        occupation = new JComboBox(Occup);
        occupation.setBackground(Color.white);
        occupation.setFont(new Font("Noto Sans",Font.BOLD,15));
        occupation.setBounds(300,380,400,30);
        add(occupation);


        JLabel PAN = new JLabel("PAN No.:");
        PAN.setFont(new Font("Poppins",Font.BOLD,22));
        PAN.setBounds(100,430,100,30);
        add(PAN);

        PANTextField = new JTextField();
        PANTextField.setFont(new Font("Noto Sans",Font.BOLD,15));
        PANTextField.setBounds(300,430,400,30);
        add(PANTextField);

        JLabel Aadhar = new JLabel("Aadhar No:");
        Aadhar.setFont(new Font("Poppins",Font.BOLD,22));
        Aadhar.setBounds(100,480,150,30);
        add(Aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Noto Sans",Font.BOLD,15));
        aadharTextField.setBounds(300,480,400,30);
        add(aadharTextField);

        JLabel SrCitizen = new JLabel("Senior Citizen:");
        SrCitizen.setFont(new Font("Poppins",Font.BOLD,22));
        SrCitizen.setBounds(100,530,200,30);
        add(SrCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300,530,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450,530,100,30);
        sno.setBackground(Color.white);
        add(sno);

        ButtonGroup Srgroup = new ButtonGroup();
        Srgroup.add(syes);
        Srgroup.add(sno);


        JLabel PCode = new JLabel("Existing Acc:");
        PCode.setFont(new Font("Poppins",Font.BOLD,22));
        PCode.setBounds(100,580,200,30);
        add(PCode);


        yes = new JRadioButton("Yes");
        yes.setBounds(300,580,100,30);
        yes.setBackground(Color.WHITE);
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(450,580,100,30);
        no.setBackground(Color.white);
        add(no);

        ButtonGroup accgroup = new ButtonGroup();
        accgroup.add(syes);
        accgroup.add(sno);


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
        String srelegion =(String) relegion.getSelectedItem();
        String scategory =(String) category.getSelectedItem();
        String sIncomecategory =(String) Incomecategory.getSelectedItem();
        String sQual =(String) Qualification.getSelectedItem();
        String soccupation = (String)  occupation.getSelectedItem();

        String panNo = PANTextField.getText();
        String aadharNo = aadharTextField.getText();

        String Senior = null;
        if(syes.isSelected()){
            Senior = "Yes";
        }
        else if (sno.isSelected()){
            Senior = "No";
        }

        String accStat = null;
        if(yes.isSelected()) {
            accStat = "Existing Customer";
        }
        else if (no.isSelected()){
            accStat = "New Customer";
        }


        try{
            if (panNo.equals("")){
                JOptionPane.showMessageDialog(null,"Pan No is required");
            }
            else if (aadharNo.equals("")){
                JOptionPane.showMessageDialog(null,"Aadhar No is required");
            }else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('"+formno+"' ,'"+srelegion+"' ,'"+scategory+"' ,'"+sIncomecategory+"' ,'"+sQual+"' ,'"+soccupation+"' , '"+Senior+"' ,'"+accStat+"' ,'"+panNo+"' ,'"+aadharNo+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
