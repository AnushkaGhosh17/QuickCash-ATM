
package atm.simulator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LOGIN extends JFrame implements ActionListener {
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    LOGIN(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/atmicon.png"));
        Image i2 =i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,600,40);
        add(text);

        JLabel cardno = new JLabel("CARD NO");
        cardno.setFont(new Font("Raieway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont((new Font("Arial",Font.BOLD,14)));
        add(cardTextField);



        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raieway",Font.BOLD,28));
        pin.setBounds(120,220,150,30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont((new Font("Arial",Font.BOLD,14)));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,40);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.BLACK);
        login.setFont(new Font("Raleway",Font.BOLD,14));
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,40);
        clear.setBackground(Color.BLUE);
        clear.setForeground(Color.BLACK);
        clear.setFont(new Font("Raleway",Font.BOLD,14));
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,350,230,40);
        signup.setBackground(Color.BLUE);
        signup.setForeground(Color.BLACK);
        signup.setFont(new Font("Raleway",Font.BOLD,14));
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");


        }
        else if (ae.getSource() == login){
            Conn conn = new Conn();
            String cardnumber=cardTextField.getText();
            String pinnumber =pinTextField.getText();
            String query ="select * from login where cardnumber ='"+cardnumber+"'and pin ='"+pinnumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Cardnumber or PIN");
                }
                
            } catch(Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);

        }

    }
    public static void main(String args[]){
        new LOGIN();

    }

}
