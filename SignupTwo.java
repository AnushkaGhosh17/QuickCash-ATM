package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {
    
    
    JTextField PANText,addressText,stateText,pinText,incomeText;
    JButton next;
    JRadioButton yes,no,yes1,no1;
    JComboBox religion ,caste,edu,occu;
    String formno;//primary key
  
    SignupTwo(String formno){
        
        this.formno = formno;
        setLayout(null);
        

        setTitle("NEW ACCOUNT APPLICATION FORM : PAGE 2");


        JLabel additional = new JLabel("PAGE 2 : ADDITIONAL DETAILS ");
        additional.setFont(new Font("Raleway",Font.BOLD,22));
        additional.setBounds(240,80,400,30);
        add(additional);

        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        String val[] = {"Hindu","Muslim","Christan","Other"};
        religion = new JComboBox(val);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        

        JLabel fname = new JLabel("Caste :");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,180,200,30);
        add(fname);
        
        String val1[] = {"General","SC","ST","OBC","Other"};
        caste = new JComboBox(val1);
        caste.setBounds(300,180,400,30);
        caste.setBackground(Color.WHITE);
        add(caste);


        JLabel dob = new JLabel("Income :");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,220,200,30);
        add(dob);
        
        incomeText = new JTextField();
        incomeText.setBounds(300, 220, 400, 30);
        add(incomeText);


        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,270,200,30);
        add(gender);

        JLabel email = new JLabel("Qualification :");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,300,200,30);
        add(email);
        
        String val2[] = {"Non Graduate","Graduate","Post Graduate","Other"};
        edu = new JComboBox(val2);
        edu.setBounds(300,300,400,30);
        edu.setBackground(Color.WHITE);
        add(edu);

        JLabel phno = new JLabel("Occupation :");
         phno.setFont(new Font("Raleway",Font.BOLD,22));
         phno.setBounds(100,340,200,30);
        add( phno);
        
        String val3[] = {"Salaried","Self-Employeed","Bussiness","Student","Home-Maker","Retired","Other"};
        occu = new JComboBox(val3);
        occu.setBounds(300,340,400,30);
        occu.setBackground(Color.WHITE);
        add(occu);

        
        JLabel ms = new JLabel("PAN Number :");
        ms.setFont(new Font("Raleway",Font.BOLD,22));
        ms.setBounds(100,380,200,30);
        add(ms);
        
        PANText = new JTextField();
        PANText.setBounds(300, 380, 400, 30);
        add(PANText);
        
        
        JLabel address = new JLabel("Adhar Number :");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,420,200,30);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("Raleway",Font.BOLD,14));
        addressText.setBounds(300,420,400,30);
        add(addressText);

        JLabel city = new JLabel("Senior citizen :");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,460,200,30);
        add(city);
        
       yes = new JRadioButton("Yes");
        yes.setBounds(300,460,100,30);
        yes.setFont(new Font("Raleway",Font.BOLD,14));
        yes.setBackground(Color.LIGHT_GRAY);
        add(yes);
        
        no = new JRadioButton("No");
        no.setBounds(450,460,100,30);
        no.setFont(new Font("Raleway",Font.BOLD,14));
        no.setBackground(Color.LIGHT_GRAY);
        add(no);
        
        ButtonGroup yn = new ButtonGroup();
        yn.add(yes);
        yn.add(no);

     

        JLabel state = new JLabel("Branch Name :");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,500,200,30);
        add(state);

         stateText = new JTextField();
        stateText.setFont(new Font("Raleway",Font.BOLD,14));
        stateText.setBounds(300,500,400,30);
        add(stateText);

        JLabel pin = new JLabel("Existing Account :");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,540,200,30);
        add(pin);
        
       yes1 = new JRadioButton("Yes");
        yes1.setBounds(300,540,100,30);
        yes1.setFont(new Font("Raleway",Font.BOLD,14));
        yes1.setBackground(Color.LIGHT_GRAY);
        add(yes1);
        
        
        no1 = new JRadioButton("No");
        no1.setBounds(450,540,100,30);
        no1.setFont(new Font("Raleway",Font.BOLD,14));
        no1.setBackground(Color.LIGHT_GRAY);
        add(no1);
        
        ButtonGroup yn2 = new ButtonGroup();
        yn2.add(yes1);
        yn2.add(no1);

        
        
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
       
        String sreligion = (String)religion.getSelectedItem();
        String scaste = (String)caste.getSelectedItem();
        String sedu = (String)edu.getSelectedItem();
        String soccu = (String)occu.getSelectedItem();
        String sincome = incomeText.getText();
        String sPAN = PANText.getText();
        String sadhar = addressText.getText();
        String sbranch = stateText.getText();
        String seniorcitizen = null;
        if(yes.isSelected()){
            seniorcitizen = "Yes";
        }
        else if(no.isSelected()){
            seniorcitizen = "No";
        }
        
        String existingacc = null;
        if(yes1.isSelected()){
            existingacc = "Yes";
        }
        else if(no1.isSelected()){
            existingacc = "No";
        }
       
       
        try{
            
             
                Conn c = new Conn();
                String query ="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scaste+"','"+sincome+"','"+sedu+"','"+soccu+"','"+sPAN+"','"+sadhar+"','"+seniorcitizen+"','"+sbranch+"','"+existingacc+"')";
                c.s.executeUpdate(query);
                
                //SignupThree obj creation
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            
            
            
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String args[]){
        new SignupTwo("");
    }
}
