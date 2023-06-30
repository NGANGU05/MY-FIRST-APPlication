package PoePart2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class welcome {

    public welcome() {
        
        JFrame frame = new JFrame("Sound Click: Welcome to EasyKanban");
        frame.setBounds(0, 0, 900, 900);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image
        ImageIcon backgroundImageIcon = new ImageIcon("src\\PoePart2\\Welcome.png");

        // Create a JLabel to hold the background image
        JLabel backgroundLabel = new JLabel(backgroundImageIcon);

        // Set the bounds of the backgroundLabel to cover the entire frame
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        // Add the backgroundLabel to the frame's content pane
        frame.getContentPane().add(backgroundLabel);
          
        JLabel welcomeLabel = new JLabel("Welcome to EasyKanban");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setBounds(300, 400, 300, 50);

        frame.getContentPane().add(welcomeLabel);

        // Set the program icon
        ImageIcon programIcon = new ImageIcon("src\\PoePart2\\favicon.png");
        frame.setIconImage(programIcon.getImage());

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 800, 100);

        JMenu menu = new JMenu("Menu");
        JMenuItem startItem = new JMenuItem("START");
        startItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Part2();
            }
        });
        menu.add(startItem);

        JMenuItem printReportItem = new JMenuItem("PRINT REPORT");
        printReportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Report();
            }
        });
        menu.add(printReportItem);

        JMenuItem quitItem = new JMenuItem("QUIT");
        quitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank you for using my Program");
            }
        });
        menu.add(quitItem);

        menuBar.add(menu);
        frame.setResizable(false);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        welcome welcomeScreen = new welcome();
    }
}
