
package atm.simulator;


import javax.swing.*;
import java.awt.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener {
    
    int random;
    JTextField nameText,fnameText,dobText,emailText,addressText,stateText,pinText,cityText,phnoText;
    JButton next;
    JRadioButton male,fmale,other,married,unmarried,others;
    JDateChooser dateChooser;
  
    SignupOne(){
        
        
        setLayout(null);
        

        Random ran = new Random();
         random = Math.abs(ran.nextInt());
         random = random/1000000;

        JLabel formno = new JLabel("APPLICATION FORM NO "+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel personal = new JLabel("PAGE 1 : PERSONAL DETAILS ");
        personal.setFont(new Font("Raleway",Font.BOLD,22));
        personal.setBounds(240,80,400,30);
        add(personal);

        JLabel name = new JLabel("Name :");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        
        nameText = new JTextField();
        nameText.setFont(new Font("Raleway",Font.BOLD,14));
        nameText.setBounds(300,140,400,30);
        add(nameText);

        JLabel fname = new JLabel("Father's Name :");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,180,200,30);
        add(fname);

        fnameText = new JTextField();
        fnameText.setFont(new Font("Raleway",Font.BOLD,14));
        fnameText.setBounds(300,180,400,30);
        add(fnameText);

        JLabel dob = new JLabel("Date Of Birth :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,220,200,30);
        add(dob);
        
        dateChooser =new JDateChooser();
        dateChooser.setBounds(300, 220, 400, 30);
        add(dateChooser);


        JLabel gender = new JLabel("Gender :");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,260,200,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,260,100,30);
        male.setFont(new Font("Raleway",Font.BOLD,14));
        male.setBackground(Color.LIGHT_GRAY);
        add(male);
        
        
        fmale = new JRadioButton("Female");
        fmale.setBounds(450,260,100,30);
        fmale.setFont(new Font("Raleway",Font.BOLD,14));
        fmale.setBackground(Color.LIGHT_GRAY);
        add(fmale);
       
        
        other = new JRadioButton("Other");
        other.setBounds(600,260,100,30);
        other.setFont(new Font("Raleway",Font.BOLD,14));
        other.setBackground(Color.LIGHT_GRAY);
        add(other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(fmale);
        gendergroup.add(other);

        JLabel email = new JLabel("Email :");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,300,200,30);
        add(email);

        emailText = new JTextField();
        emailText.setFont(new Font("Raleway",Font.BOLD,14));
        emailText.setBounds(300,300,400,30);
        add(emailText);
        
        JLabel phno = new JLabel("Phone No :");
         phno.setFont(new Font("Raleway",Font.BOLD,22));
         phno.setBounds(100,340,200,30);
        add( phno);

        phnoText = new JTextField();
        phnoText.setFont(new Font("Raleway",Font.BOLD,14));
        phnoText.setBounds(300,340,400,30);
        add(phnoText);

        JLabel ms = new JLabel("Marital Status :");
        ms.setFont(new Font("Raleway",Font.BOLD,22));
        ms.setBounds(100,380,200,30);
        add(ms);
        
        married = new JRadioButton("Married");
        married.setBounds(300,380,100,30);
        married.setFont(new Font("Raleway",Font.BOLD,14));
        married.setBackground(Color.LIGHT_GRAY);
        add(married);
        
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,380,100,30);
        unmarried.setFont(new Font("Raleway",Font.BOLD,14));
        unmarried.setBackground(Color.LIGHT_GRAY);
        add(unmarried);
       
        
        others = new JRadioButton("Other");
        others.setBounds(600,380,100,30);
        others.setFont(new Font("Raleway",Font.BOLD,14));
        others.setBackground(Color.LIGHT_GRAY);
        add(others);
        
        ButtonGroup msgroup = new ButtonGroup();
        msgroup.add(married);
        msgroup.add(unmarried);
        msgroup.add(others);

        

        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,420,200,30);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("Raleway",Font.BOLD,14));
        addressText.setBounds(300,420,400,30);
        add(addressText);

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,460,200,30);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Raleway",Font.BOLD,14));
        cityText.setBounds(300,460,400,30);
        add(cityText);

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,500,200,30);
        add(state);

         stateText = new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,14));
        stateText.setBounds(300,500,400,30);
        add(stateText);

        JLabel pin = new JLabel("Pin Code :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,540,200,30);
        add(pin);

         pinText = new JTextField();
        pinText.setFont(new Font("Raleway",Font.BOLD,14));
        pinText.setBounds(300,540,400,30);
        add(pinText);
        
        
        
         next = new JButton("NEXT");
        next.setBounds(620,600,80,30);
        next.setBackground(Color.BLUE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.addActionListener(this);
        add(next);

        setSize(900,800);
        setLocation(350,10);
        setVisible(true);
        getContentPane().setBackground(Color.lightGray);
        
        
    }
    public void actionPerformed (ActionEvent ae){
        String formno =""+ random;
        String name = nameText.getText();
        String fname = fnameText.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }
        else if(fmale.isSelected()){
            gender = "Female";
        }
        else if(other.isSelected()){
            gender = "Other";
        }
        String email = emailText.getText();
        String phno = phnoText.getText();
        String marital = null;
        if(married.isSelected()){
            marital = "Married";
        }
        else if(unmarried.isSelected()){
            marital = "Unmarried";
        }
        else if(others.isSelected()){
            marital = "Other";
        }
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pin = pinText.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }
            else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name is required");
            }
            else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date Of Birth is required");
            }
            else if(phno.equals("")){
                JOptionPane.showMessageDialog(null, "Phone No is required");
            }
            else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is required");
            }
            else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City is required");
            }
            else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is required");
            }
            else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "Pin Code is required");
            }
            else {
                Conn c = new Conn();
                String query ="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+phno+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String args[]){
        new SignupOne();
    }
}
