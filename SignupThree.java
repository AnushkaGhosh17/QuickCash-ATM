
package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*; 

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit ,cancel;
    String formno;
    SignupThree(String formno){
        this.formno = formno;
        setLayout(null);
        JLabel l1 = new JLabel("Page 3 :Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,26));
        l1.setBounds(280, 20, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100, 100, 150, 30);
        add(type);
        r1= new JRadioButton("Saving Account");
        r1.setBounds(100, 140, 250, 20);
        r1.setFont(new Font("Raleway",Font.BOLD,16));

        add(r1);
        
        r2= new JRadioButton("Fixed Deposite Account");
        r2.setBounds(350, 140, 250, 20);
        r2.setFont(new Font("Raleway",Font.BOLD,16));

        add(r2);
        
        r3= new JRadioButton("Curret Account");
        r3.setBounds(100, 180, 150, 20);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
  
        add(r3);
        
        r4= new JRadioButton("Recurring Deposite Account");
        r4.setBounds(350, 180, 250, 20);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
 
        add(r4);
        
        ButtonGroup groupacc = new ButtonGroup();
        groupacc.add(r1);
        groupacc.add(r2);
        groupacc.add(r3);
        groupacc.add(r4);
        
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100, 230, 150, 20);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(350, 230, 350, 20);
        add(number);
        
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100, 280, 150, 30);
        add(pin);
        
        JLabel pnumber = new JLabel("****");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(350, 280, 350, 30);
        add(pnumber);
        
        JLabel service = new JLabel("Services Required");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100, 350, 350, 30);
        add(service);
        
        c1 = new JCheckBox("ATM CARD");
        
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,400,200,30);
        add(c1);
        
        c2 = new JCheckBox("Internet Bnaking");

        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(350,400,200,30);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");

        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,450,200,30);
        add(c3);
        
        c4 = new JCheckBox("Email or SMS Alerts");

        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(350,450,200,30);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,500,200,30);
        add(c5);
        
        c6 = new JCheckBox("ATM CARD");
     
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(350,500,200,30);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that that the above entered details are correct to the best of my knowledge ");
        
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,550,600,14);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(500,600,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLUE);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(650,600,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(800,820);
        setLocation(350,0);
        setVisible(true);
     
        
        
    }
    
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()== submit){
            String accounttype = null;
            if(r1.isSelected()){
                accounttype = "Saving Account";
            }
            else if(r2.isSelected()){
                accounttype = "Fixed Deposite Account";
            }
            else if(r3.isSelected()){
                accounttype = "Current Account";
            }
            else if(r4.isSelected()){
                accounttype = "Recurring Deposite Account";
            }
            Random random = new Random();
            String cardnumber ="" + Math.abs((random.nextLong()% 9000L)+1000L)+" "+ Math.abs((random.nextLong()% 9000L)+1000L)+" "+ Math.abs((random.nextLong()% 9000L)+1000L)+" "+ Math.abs((random.nextLong()% 9000L)+1000L);
            String pinnumber ="" + Math.abs((random.nextLong()% 9000L)+1000L);
            String facility = "";
            if (c1.isSelected()){
                facility = facility +" ATM Card ";
            }
            else if (c2.isSelected()){
                facility = facility +" Internet Banking ";
            }
            else if (c3.isSelected()){
                facility = facility +" Mobile Banking ";
            }
            else if (c4.isSelected()){
                facility = facility +" Email or SMS Alerts ";
            }
            else if (c5.isSelected()){
                facility = facility +"Cheque Book";
            }
            else if (c6.isSelected()){
                facility = facility +" E-statement";
            }
            try {
                if(accounttype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                }
                else {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values ('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values ('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number : "+cardnumber+"\n PIN : "+pinnumber);
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
                
            }catch(Exception e){
                System.out.println(e);
                
            }
                         

         
        } 
        else if(ae.getSource()== cancel){
            setVisible(false);
            new LOGIN().setVisible(true);
            
        }
    }
    public static void main(String args[]) {
        new SignupThree("");
    }
    
}
