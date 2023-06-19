
package harvey1;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static harvey1.REGISTRATION.main;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * 
 */
public class LOGIN   {
    
    public static final String SENTINAL = "zzzzzzz";
   
public JLabel myLabel;
    public LOGIN() {
        LabelBackground() ;


   
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        
 
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        frame.getContentPane().setBackground(Color.cyan);
         
        
        
        JLabel hjjjjjjj =  new JLabel("UserName");
        hjjjjjjj.setBounds(10,20,80,25);
        panel.add(hjjjjjjj);

        JTextField ghhjjjj = new JTextField();
        ghhjjjj.setBounds(100,20,265,25);
        panel.add(ghhjjjj);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,90,180,40);
        panel.add(passwordLabel);
          
        JPasswordField jjkkkkkk = new JPasswordField();
        jjkkkkkk.setBounds(80,100,300,25);
        panel.add(jjkkkkkk);
        JButton Login = new JButton("Login");
        Login.setBounds(20, 180, 200, 25);
        frame.setVisible(true);
         frame.setResizable(false);  
          frame.add(Login);
        panel.add(Login);
        
         // Set the program icon
        ImageIcon programIcon = new ImageIcon("src\\harvey1\\maxresdefault.jpg");
        frame.setIconImage(programIcon.getImage());

        // Set the background image
        ImageIcon backgroundImage = new ImageIcon("src\\harvey1\\maxresdefault.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.add(backgroundLabel);
        
        frame.setResizable(false);

        frame.setVisible(true);
        
       
        Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String userName = ghhjjjj.getText();
                String password = new String(jjkkkkkk.getPassword());
                loginUser(userName, password);
                new welcome();
                
            }
        } );
               
                
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
                  
            } // here i just put same condition on my program which will be each time that the user would like to input stuff he will 
           // will need to respect the condition
            String upperCaseChars = "(.*[A-Z].*)";
            if (passwordText.matches(upperCaseChars ))
            {
                    UppercaseValid = true;
                    System.out.println("upp");
            }
            String lowerCaseChars = "(.*[a-z].*)";
            if (passwordText.matches(lowerCaseChars ))
            {
                    lowerValid = true;
                    System.out.println("low");
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
    
    private boolean CheckUsername(JTextField usernameText) {
        boolean isValid = false;
        String Username = usernameText.getText();
        if (Username.length()<= 5 && Username.contains("_") ){
            isValid = true ;
            System.out.println("Username is successfully captured");



        }else{ 


            JOptionPane.showMessageDialog(null,"Username is not formatted please ensure that you username contains an underscaore and is not more than 5 characters); ");
            isValid = false;
        }
        return isValid;
    }
    
    public static void loginUser(String userName, String password){
        String account;
        String name;
        String lastName;
        boolean found = false;
        LinkedList<String> info = new LinkedList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
            while ((account = reader.readLine()) != null) {
                if (account.equals(userName) || found){
                    found = true;

                    // these are the lines between the user 
                    if (account.equals(SENTINAL)){
                        found = false;
                    }else {
                        info.add(account);
                    }
                }
            }

        reader.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        if (!info.isEmpty()){
            if (password.equals(info.get(2))) {
                name = info.get(1);

                String outputMessage = "Welcome  " ;
                JOptionPane.showMessageDialog(null, outputMessage);
              
            }else{
                JOptionPane.showMessageDialog(null, "Username or password is incorrect,please try again");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No accounts have been registered yet, please try again");
            
        }
        
    }
    
    public   void LabelBackground() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                // Load the background image
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new File("amazon-music-02-seatheme-standard-thumb-medium-1000x563-1.jpg"));
                } catch (IOException ex) {
                    Logger.getLogger(LOGIN.class.getName()).log(Level.SEVERE, null, ex);
                }
                // Create the frame...
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // Set the frames content pane to use a JLabel
                // whose icon property has been set to use the image
                // we just loaded
                frame.setContentPane(new JLabel(new ImageIcon(img)));
                // Supply a layout manager for the body of the content
                frame.setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                // Add stuff...
                frame.add(new JLabel(), gbc);
                frame.add(new JLabel(), gbc);
                frame.add(new JButton(), gbc);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                
                

            }
        });
    }
    

}




