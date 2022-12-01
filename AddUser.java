import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class AddUser extends Main   {

    File f = new File("C:\\UserNamePass");
    int ln;
    
                
    void createFolder(){
        if(!f.exists()){
            f.mkdirs();
        }
    }

    void readFile(){
        try {
            FileReader fr = new FileReader (f+"\\logins.txt");
            System.err.println("File Exists");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(f+"\\logins.txt");
                System.out.println("File created");
            } catch (IOException e) {
                Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    void addData(String regularUser, String regularPass){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for(int i=0; i<ln;i++)
            {
                raf.readLine();
            }
            raf.writeBytes("\r\n");
            raf.writeBytes("\r\n");
            raf.writeBytes("Username: " + regularUser +"\r\n");
            raf.writeBytes("Password: " + regularPass +"\r\n");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*void CheckData(String regularUser, String regularPass){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            String line = raf.readLine();
            regularUser = line.substring(9);
            regularPass = raf.readLine().substring(9);
            if (regularUser.equals(regularUser) & regularPass.equals(regularPass)){
                JOptionPane.showMessageDialog(null, "Password Matched");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

    void countLines(){
        try {
            ln=1;
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "rw");
            for (int i=0;raf.readLine()!=null; i++){
                ln++;
            }
            System.out.println("Number of lines: "+ln);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void logic(String string, String string2){
        try {
            RandomAccessFile raf = new RandomAccessFile(f+"\\logins.txt", "wr");
            for (int i=0; i<ln;i+=4){
                String forUser = raf.readLine().substring(9);
                String forPswd = raf.readLine().substring(9);
                if(string.equals(forUser) & string2.equals(forPswd)){
                    JOptionPane.showMessageDialog(null, "Password matched");
                } else if(i==(ln-3)) {
                    JOptionPane.showMessageDialog(null, "Incorrect user/password");
                }
                for(int k=1;k<=2;k++){
                    raf.readLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex){
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    


}
