/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurant.menu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static restaurant.menu.REGISTRATION.SENTINAL;

/**
 *
 * @author Flranklin
 */
public class TASKANDREPORT {

    public TASKANDREPORT() {
        
        
        
        
        
        
        
        
       JPanel mypanel = new JPanel();
        JFrame Frame = new JFrame();
     
        Frame.setTitle("EMPLOYEES INFORMATION");
        Frame.setSize(2000, 2000);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.add(mypanel);

        mypanel.setLayout(null);
        Frame.getContentPane().setBackground(Color.BLACK);

        JLabel FirstName = new JLabel();
        FirstName.setBounds(50, 50, 75, 25);
        FirstName.setText("FIRST NAME ");
        FirstName.setForeground(Color.BLACK);
        Frame.add(FirstName);

        JTextField TtxtfieldFirstName = new JTextField();
        TtxtfieldFirstName.setBounds(125, 50, 150, 25);
        Frame.add(TtxtfieldFirstName);

        JLabel LastName = new JLabel();
        LastName.setBounds(50, 100, 75, 25);
        LastName.setText("Last Name");
        LastName.setForeground(Color.BLACK);
        Frame.add(LastName);

        JTextField fieldLastName = new JTextField();
        fieldLastName.setBounds(125, 100, 150, 25);
        Frame.add(fieldLastName);

        JLabel myUsername = new JLabel();
        myUsername.setBounds(50, 150, 75, 25);
        myUsername.setText("SURNAME");
        myUsername.setForeground(Color.BLACK);
        Frame.add(myUsername);

        JTextField TtxtfieldUserID = new JTextField();
        TtxtfieldUserID.setBounds(125, 150, 150, 25);
        Frame.add(TtxtfieldUserID);

        JLabel myPassword = new JLabel();
        myPassword.setBounds(50, 200, 75, 25);
        myPassword.setText("Password");
        myPassword.setForeground(Color.BLACK);
        Frame.add(myPassword);

        JPasswordField TtxtfieldPassword = new JPasswordField();
        TtxtfieldPassword.setBounds(125, 200, 150, 25);
        Frame.add(TtxtfieldPassword);

        JButton NextPage = new JButton("Login");
        NextPage.setBounds(125, 300, 150, 25);

        ImageIcon programIcon = new ImageIcon("src\\harvey1\\amazon-music-02-seatheme-standard-thumb-medium-1000x563-1.jpg");
        Frame.setIconImage(programIcon.getImage());

        // Set the background image
        ImageIcon backgroundImage = new ImageIcon("src\\harvey1\\amazon-music-02-seatheme-standard-thumb-medium-1000x563-1.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, Frame.getWidth(), Frame.getHeight());
        mypanel.add(backgroundLabel);
        NextPage.addActionListener(new ActionListener() {
            private LOGIN login;

            public void actionPerformed(ActionEvent e){
                new TASK2();
                
            }

        }); 
         Frame.setResizable(false);

        Frame.add(NextPage);

        JButton Login = new JButton("Register");
        Login.setBounds(125, 250, 150, 25);
         Frame.add(NextPage);
        

        Login.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                boolean usernameValid = CheckUsername( TtxtfieldUserID );
                boolean passwordValid = checkPasswordComplexity(TtxtfieldPassword);
            
                if (usernameValid == true && passwordValid == true ){
                    String userName = TtxtfieldUserID .getText();
                    String password = new String(TtxtfieldPassword.getPassword());
                    if (CheckUsername(TtxtfieldUserID ) && checkPasswordComplexity(TtxtfieldPassword) )
                        StringregisterUser(userName, password, TtxtfieldFirstName.getText());
                    new LOGIN();                    
                }
                
            }
        });
        
        

      
      
        mypanel.add(Login);

        Frame.add(mypanel);

        Frame.setVisible(true);
    
        Frame.setVisible(true);  
        
  
    }
    
    private static boolean CheckUsername(JTextField usernameText) {
        boolean isValid = false;
        String Username = usernameText.getText();
        if (Username.length()<= 5 && Username.contains("_") ){
            isValid = true ;
            System.out.println("Username is successfully captured" );
           

        }else{ 
            JOptionPane.showMessageDialog(null,"Username is not formatted please ensure that you username contains an underscaore and is not more than 5 characters ");
            isValid = false;
        }
        return isValid;
    }
    
    public static boolean checkPasswordComplexity(JPasswordField password)
            
    {
        String passwordText = new String(password.getPassword());
        //passwordText = passwordText.getText();
        boolean isValid = false;
        boolean lengthValid = false;
        boolean UppercaseValid = false;
        boolean numbersValid = false;
        boolean lowerValid = false;
        boolean specialChartsValid = false;
        if (passwordText.length() >=8  )
            {
                    lengthValid = true;;
              
            }
            String upperCaseChars = "(.*[A-Z].*)";
            if (passwordText.matches(upperCaseChars ))
            {
                    UppercaseValid = true;
             
            }
            String lowerCaseChars = "(.*[a-z].*)";
            if (passwordText.matches(lowerCaseChars ))
            {
                    lowerValid = true;
              
            }
            String numbers = "(.*[0-9].*)";
            if (passwordText.matches(numbers ))
            {
                    numbersValid = true;
                
            }
            String specialChars = "(.*[!,^,*,(,),-,_,=,+,`,~,?,/,:,@,#,$,%].*$)";
            if (passwordText.matches(specialChars ))
            {
                    specialChartsValid= true;
                
            }
            
            if (lengthValid == true && UppercaseValid == true && numbersValid == true && lowerValid == true && specialChartsValid == true ){
                System.out.println("Password is successfully captured ");
                
                isValid = true;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted ,please ensure that the password contains at least 8 characters , a capital letter , number and a special charater click ok to resart","Password",0);
                
            }

        return isValid ; 
    }
    
    public static void StringregisterUser(String userName, String password, String nameAndSurname) {
        
        Boolean finishedReading = false;
        Boolean finishedWiting = false;

        LinkedList<String> previousInfo = new LinkedList<String>();

        // Ensuring that the old infomaton isn't lost
        try {
            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
            String data;
            
            while ((data = reader.readLine()) != null) {
                previousInfo.add(data);
            }
            reader.close();
            finishedReading = true;

        }catch (Exception e) {
            System.out.println("Error occured while trying to read from database");
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt"));
            for (String line : previousInfo) {
                writer.write(line);
                writer.write("\n");
            }
            // write new data to file:
            writer.write(userName);
            writer.write("\n" + nameAndSurname);
            writer.write("\n" + password);
            writer.write("\n" + SENTINAL);

            writer.close();
            finishedWiting = true;
        
        } catch (Exception e) {
            System.out.println("Error occured while trying to write to database");
            e.printStackTrace();
                  
        }

    }

    

    }


        
        
        
        
        
        
        
        
        
        
        
    