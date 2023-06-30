package PoePart2;

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
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import javax.swing.ImageIcon;

public class Login {
    public static final String SENTINEL = "999999999999";

    public Login() {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        
        frame.setTitle("Login");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        panel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.setLayout(null);
        frame.add(panel);

        JLabel userNameLabel = new JLabel("Username");
        userNameLabel.setBounds(10, 20, 80, 25);
        userNameLabel.setForeground(Color.WHITE);
        panel.add(userNameLabel);

       

        JTextField usernameText = new JTextField();
        usernameText.setBounds(100, 20, 265, 25);
        panel.add(usernameText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 90, 180, 40);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 100, 265, 25);
        panel.add(passwordText);

        JButton login = new JButton("Login");
        login.setBounds(100, 180, 265, 25);
        panel.add(login);

        // Set the program icon
        ImageIcon programIcon = new ImageIcon("src\\PoePart2\\favicon.png");
        frame.setIconImage(programIcon.getImage());

        // Set the background image
        ImageIcon backgroundImage = new ImageIcon("src\\PoePart2\\login.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        panel.add(backgroundLabel);
        
        frame.setResizable(false);

        frame.setVisible(true);

        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String userName = usernameText.getText();
                String password = new String(passwordText.getPassword());
                loginUser(userName, password);
                new welcome();
            }
        });
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
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted. Please ensure that the password " +
                    "contains at least 8 characters, a capital letter, a number, and a special character.", "Password", JOptionPane.ERROR_MESSAGE);
        }

        return isValid;
    }

    private boolean checkUsername(JTextField usernameText) {
        boolean isValid = false;
        String username = usernameText.getText();
        if (username.length() <= 5 && username.contains("_")) {
            isValid = true;
            System.out.println("Username is successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not formatted. Please ensure that your username " +
                    "contains an underscore and is not more than 5 characters.", "Username", JOptionPane.ERROR_MESSAGE);
        }
        return isValid;
    }

    public static void loginUser(String userName, String password) {
        String account;
        String name;
        String lastName;
        boolean found = false;
        LinkedList<String> info = new LinkedList<String>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"));
            while ((account = reader.readLine()) != null) {
                if (account.equals(userName) || found) {
                    found = true;

                    // These are the lines between the user
                    if (account.equals(SENTINEL)) {
                        found = false;
                    } else {
                        info.add(account);
                    }
                }
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!info.isEmpty()) {
            if (password.equals(info.get(2))) {
                name = info.get(1);
                String outputMessage = "Welcome to EasyKanban!";
                JOptionPane.showMessageDialog(null, outputMessage);
            } else {
                JOptionPane.showMessageDialog(null, "Username or password is incorrect. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No accounts have been registered yet. Please try again.", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}








