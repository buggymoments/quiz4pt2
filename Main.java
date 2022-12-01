import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {

    public static JFrame frame = new JFrame("Login");
    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");
    JTextField user = new JTextField("");
    JTextField pass = new JTextField("");
    JButton login = new JButton("Login");
    JButton clear = new JButton("Clear");

    // Authentication
    String[] adminUser = {"admin"};
    String[] adminPass = {"admin"};
    String[] regularUser = {"regular", "student"};
    String[] regularPass = {"regular", "student"};

    int count = 0;

    Main() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(325,210);
        frame.setLayout(new GridLayout(3,2));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        login.addActionListener(this);
        clear.addActionListener(e -> user.setText(""));
        clear.addActionListener(e -> pass.setText(""));
        login.setFocusable(false);
        clear.setFocusable(false);
        
        frame.add(username);
        frame.add(user);
        frame.add(password);
        frame.add(pass);
        frame.add(login);
        frame.add(clear);
    }

    
    public static void main(String[] args) {
        Main main = new Main();
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == login) {
            if (user.getText().equals(adminUser[0]) && pass.getText().equals(adminPass[0])) {
                frame.setVisible(false);
                UserScreen users = new UserScreen();
                count++;
                users.count.setText("" + count);
            } else if (user.getText().equals(regularUser[0]) || user.getText().equals(regularUser[1]) 
                    && pass.getText().equals(regularPass[0]) || pass.getText().equals(regularPass[1])) {
                frame.setVisible(false);
                UserScreen users = new UserScreen();
                users.admin.setSelectedItem(users.users[1]);
                count++;
                users.count.setText("" + count); 
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect username and password.");
            }
        }
    }
}