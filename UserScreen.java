import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class UserScreen extends Login{

    JFrame frame = new JFrame("Users");
    JLabel username2 = new JLabel("Username"); 
    JLabel password2 = new JLabel("Password"); 
    JLabel usertype = new JLabel("User Type"); 
    JLabel logincount = new JLabel("Login Count");
    JTextField user2 = new JTextField();
    JTextField pass2 = new JTextField();
    String[] users = {"Administrator", "Regular"};
    JComboBox admin = new JComboBox<>(users);
    JLabel count = new JLabel("");
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JButton add = new JButton("Add");
    JButton edit = new JButton("Edit");
    JButton delete = new JButton("Delete");
    JButton previous = new JButton("Previous");
    JButton next = new JButton("Next");
    JButton back = new JButton("Back");

    UserScreen() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,220);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5,2));
        frame.setVisible(true);

        panel.setLayout(new GridLayout());
        panel2.setLayout(new GridLayout());
        panel.add(add);
        panel.add(edit);
        panel.add(delete);
        panel2.add(previous);
        panel2.add(next);
        panel2.add(back);
        
        add.setFocusable(false);
        edit.setFocusable(false);
        delete.setFocusable(false);
        previous.setFocusable(false);
        next.setFocusable(false);
        back.setFocusable(false);
        admin.setFocusable(false);
        admin.setEnabled(false);
        UIManager.put("ComboBox.disabledForeground", Color.black);

        frame.add(username2);
        frame.add(user2);
        frame.add(password2);
        frame.add(pass2);
        frame.add(usertype);
        frame.add(admin);
        frame.add(logincount);
        frame.add(count);
        frame.add(panel);
        frame.add(panel2);

        

        add.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               
               createFolder(); 
               readFile();
               countLines();
               addData(user2.getText(),pass2.getText());
               
            }
            
        });

        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Main.frame.setVisible(true);
            }
        });

        edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Desktop.getDesktop().open(new java.io.File("C:/UserNamePass/logins.txt"));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Desktop.getDesktop().open(new java.io.File("C:/UserNamePass/logins.txt"));
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}