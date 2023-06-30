package PoePart2;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import javax.swing.JPanel;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

import javax.swing.*;

public class Main {
    
     JFrame frame = new JFrame("Welcome to EasyKanban");

        
        
    final static String SENTINAL = "TheEndOfUserInformation";

    public static void main(String[] args) {
        JPanel mypanel = new JPanel();
        JFrame Frame = new JFrame();
     
        Frame.setTitle("Sign Up");
        Frame.setSize(500, 500);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.add(mypanel);

        mypanel.setLayout(null);
        Frame.getContentPane().setBackground(Color.PINK);

        JLabel FirstName = new JLabel();
        FirstName.setBounds(50, 50, 75, 25);
        FirstName.setText("First Name");
        FirstName.setForeground(Color.WHITE);
        Frame.add(FirstName);

        JTextField TtxtfieldFirstName = new JTextField();
        TtxtfieldFirstName.setBounds(125, 50, 150, 25);
        Frame.add(TtxtfieldFirstName);

        JLabel LastName = new JLabel();
        LastName.setBounds(50, 100, 75, 25);
        LastName.setText("Last Name");
        LastName.setForeground(Color.WHITE);
        Frame.add(LastName);

        JTextField fieldLastName = new JTextField();
        fieldLastName.setBounds(125, 100, 150, 25);
        Frame.add(fieldLastName);

        JLabel myUsername = new JLabel();
        myUsername.setBounds(50, 150, 75, 25);
        myUsername.setText("Username");
        myUsername.setForeground(Color.WHITE);
        Frame.add(myUsername);

        JTextField TtxtfieldUserID = new JTextField();
        TtxtfieldUserID.setBounds(125, 150, 150, 25);
        Frame.add(TtxtfieldUserID);

        JLabel myPassword = new JLabel();
        myPassword.setBounds(50, 200, 75, 25);
        myPassword.setText("Password");
        myPassword.setForeground(Color.WHITE);
        Frame.add(myPassword);

        JPasswordField TtxtfieldPassword = new JPasswordField();
        TtxtfieldPassword.setBounds(125, 200, 150, 25);
        Frame.add(TtxtfieldPassword);

        JButton NextPage = new JButton("Login");
        NextPage.setBounds(125, 300, 150, 25);

        ImageIcon programIcon = new ImageIcon("src\\PoePart2\\favicon.png");
        Frame.setIconImage(programIcon.getImage());

        // Set the background image
        ImageIcon backgroundImage = new ImageIcon("src\\PoePart2\\Sign Up.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, Frame.getWidth(), Frame.getHeight());
        mypanel.add(backgroundLabel);

        NextPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });
        Frame.setResizable(false);

        Frame.add(NextPage);

        JButton Login = new JButton("Register");
        Login.setBounds(125, 250, 150, 25);

        Login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                boolean usernameValid = CheckUsername(TtxtfieldUserID);
                boolean passwordValid = checkPasswordComplexity(TtxtfieldPassword);

                if (usernameValid && passwordValid) {
                    String userName = TtxtfieldUserID.getText();
                    String password = new String(TtxtfieldPassword.getPassword());
                    registerUser(userName, password, TtxtfieldFirstName.getText());
                    new Login();
                }

            }
        });

        mypanel.add(Login);

        Frame.add(mypanel);

        Frame.setVisible(true);
    }

    private static boolean CheckUsername(JTextField usernameText) {
        boolean isValid = false;
        String Username = usernameText.getText();
        if (Username.length() <= 5 && Username.contains("_")) {
            isValid = true;
            System.out.println("Username is successfully captured");

        } else {
            JOptionPane.showMessageDialog(null,
                    "Username is not formatted. Please ensure that your username contains an underscore and is not more than 5 characters.");
            isValid = false;
        }
        return isValid;
    }

    public static boolean checkPasswordComplexity(JPasswordField password) {
        String passwordText = new String(password.getPassword());
        boolean isValid = false;
        boolean lengthValid = false;
        boolean uppercaseValid = false;
        boolean numbersValid = false;
        boolean lowercaseValid = false;
        boolean specialCharsValid = false;

        if (passwordText.length() >= 8) {
            lengthValid = true;
        }

        String upperCaseChars = "(.*[A-Z].*)";
        if (passwordText.matches(upperCaseChars)) {
            uppercaseValid = true;
        }

        String lowerCaseChars = "(.*[a-z].*)";
        if (passwordText.matches(lowerCaseChars)) {
            lowercaseValid = true;
        }

        String numbers = "(.*[0-9].*)";
        if (passwordText.matches(numbers)) {
            numbersValid = true;
        }

        String specialChars = "(.*[!,^,*,(,),-,_,=,+,`,~,?,/,:,@,#,$,%].*$)";
        if (passwordText.matches(specialChars)) {
            specialCharsValid = true;
        }

        if (lengthValid && uppercaseValid && numbersValid && lowercaseValid && specialCharsValid) {
            isValid = true;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Password is not correctly formatted. Please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.",
                    "Password", 0);
        }

        return isValid;
    }

    public static void registerUser(String userName, String password, String nameAndSurname) {

        boolean finishedReading = false;
        boolean finishedWriting = false;

        LinkedList<String> previousInfo = new LinkedList<String>();

        // Ensuring that the old information isn't lost
        try {
            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
            String data;

            while ((data = reader.readLine()) != null) {
                previousInfo.add(data);
            }
            reader.close();
            finishedReading = true;

        } catch (Exception e) {
            System.out.println("Error occurred while trying to read from the database");
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
            finishedWriting = true;

        } catch (Exception e) {
            System.out.println("Error occurred while trying to write to the database");
            e.printStackTrace();

        }
    }
}




       

