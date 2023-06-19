
package harvey1;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class welcome {

    public welcome() {
  
        JFrame frame = new JFrame("");
        frame.setBounds(0, 0, 1000, 1000);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load the background image
        ImageIcon backgroundImageIcon = new ImageIcon("src\\harvey1\\franklin 1.png");

        // Create a JLabel to hold the background image
        JLabel backgroundLabel = new JLabel(backgroundImageIcon);

        // Set the bounds of the backgroundLabel to cover the entire frame
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        // Add the backgroundLabel to the frame's content pane
        frame.getContentPane().add(backgroundLabel);
          
      
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0,0,100,100);
        // here we are giving the cashier option to chose , we try to use JMenu .
        JMenu menu = new JMenu("WELCOME TO NGANGU DESIGN");
        JMenuItem makeSale = new JMenuItem("START");
     
        
        menuBar.setBounds(0, 0, 800, 90);
        
         frame.setResizable(false);
        // Set the program icon
        ImageIcon programIcon = new ImageIcon("src\\harvey1\\franklin 1.png");
        frame.setIconImage(programIcon.getImage());


        makeSale.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new TASKANDREPORT();
                
                
            } 
        });
        menu.add(makeSale);
        
        // here  we gave same choose so that he cashier can be able to quit if he daesn 't want the perform the task
        JMenuItem quit = new JMenuItem("CANCEL ");
        quit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 frame.dispose();
                 JOptionPane.showMessageDialog(null,  " bye bye we wish you a nice day");
                 
            } 
        });
        menu.add(quit);
        
        menuBar.add(menu);
        
        frame.add(menuBar);
        frame.setVisible(true);
      
        

    }
    

}