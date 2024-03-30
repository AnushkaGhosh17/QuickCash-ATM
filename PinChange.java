
package atm.simulator;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
public class PinChange extends JFrame implements ActionListener {
    String pinnumber;
    JPasswordField pin,cpin;
    JButton change,back;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1=new  ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpeg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text = new JLabel("Change Your PIN");
        text.setForeground(Color.black);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(210, 170, 350, 30);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN");
        pintext.setForeground(Color.black);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        pintext.setBounds(130, 210, 100, 30);
        image.add(pintext);
        
          pin =new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,20));
        pin.setForeground(Color.black);
        pin.setBounds(290, 210, 150, 25);
        pin.setBackground(Color.LIGHT_GRAY);
        image.add(pin);
        
        JLabel cpintext = new JLabel("Confirm Your PIN");
        cpintext.setForeground(Color.black);
        cpintext.setFont(new Font("Raleway",Font.BOLD,16));
        cpintext.setBounds(130, 250, 350, 35);
        image.add(cpintext);
        
          cpin =new JPasswordField();
        cpin.setFont(new Font("Raleway",Font.BOLD,20));
        cpin.setForeground(Color.black);
        cpin.setBounds(290, 250, 150, 25);
        cpin.setBackground(Color.LIGHT_GRAY);
        image.add(cpin);
        
         change = new JButton("Change");
        change.setBounds(310, 355, 130, 30);
        change.addActionListener(this);
        image.add(change);
        
         back = new JButton("Back");
        back.setBounds(310, 390, 130, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                String npin = pin.getText();
                String conpin =cpin.getText();
                if(!npin.equals(conpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                else if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter  PIN");
                    return;
                }
                else if(conpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Confirm  PIN");
                    return;
                }
                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+conpin+"' where pin ='"+pinnumber+"'";
                String query2 = "update login set pin = '"+conpin+"' where pin ='"+pinnumber+"'";
                String query3 = "update signupthree set pin = '"+conpin+"' where pin ='"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(conpin).setVisible(true);
                    
                
                



            }catch(Exception e){
                System.out.println(e);
            }
        
    }
        else{
            setVisible(false);
            new Transactions("").setVisible(true);
        }
    }
    
    public static void main (String args[]){
        new PinChange("").setVisible(true);
    }
    
}
