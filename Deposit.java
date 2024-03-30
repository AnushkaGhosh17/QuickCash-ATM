
package atm.simulator;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.*;
public class Deposit extends JFrame implements ActionListener {
    JTextField amount;
    JButton deposit,back;
    String pinnumber;
    
    
    Deposit(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
    
    
        ImageIcon i1=new  ImageIcon(ClassLoader.getSystemResource("icon/ATM.jpeg"));
        Image i2=i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text = new JLabel ("Enter the amount you want to deposit");
        text.setForeground(Color.black);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(140, 170, 350, 35);
        
        
        image.add(text);
        
         amount =new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,20));
        amount.setForeground(Color.black);
        amount.setBounds(140, 230, 270, 25);
        amount.setBackground(Color.LIGHT_GRAY);
        image.add(amount);
        
         deposit = new JButton("Deposit");
        deposit.setBounds(310, 355, 130, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
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
        if(ae.getSource()== deposit){
            Conn c = new Conn();
            int balance = 0;
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin ='"+pinnumber+"'");

                while (rs.next()) {
                    if (rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));

                    }
                }
            }catch (Exception e){
                        System.out.println(e);
            }
            String money =amount.getText();
            Date date  = new Date();
            if(money.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else if (balance == 0){
                if (Integer.parseInt(money)<500){
                    JOptionPane.showMessageDialog(null, "For new you have to deposit minimum 500 Rs or more");
                }
                else{
                    try{
                Conn conn=new Conn();
                String query ="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+money+"' )";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+money+" Deposited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                        }
                catch(Exception e){
                    System.out.println(e);
                }
                    
                }
                
                
            }
            else{
                try{
                Conn conn=new Conn();
                String query ="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+money+"' )";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+money+" Deposited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                        }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()== back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
        
    }
    public static void main (String args[]){
        new Deposit("");
        
    }
    
}
