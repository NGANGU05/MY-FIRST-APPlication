
package myoma.kitchens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Flranklin
 */
public class MyomaKitchens {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
   
        JPanel panel = new JPanel();
        JFrame frame = new JFrame(" MYONA KITCHENS");
       
        

        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        // here i am just trying to create a welcome page that will make the first page intrested
        JLabel menulabel = new JLabel ("WELCOME TO MYOMAKITCHENS ");
        menulabel.setBounds(100,20,600,25);
        panel.add(menulabel);
        
        
        JLabel Makesale =  new JLabel("MAKE SALE");
        Makesale.setBounds(10,50,80,25);
        panel.add(Makesale);
        

        JButton makesale = new JButton();
        makesale.setBounds(100,50,100,25);
        
        makesale.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new ticketnumber();
              
            }
             }); 
        panel.add(makesale);

        JLabel passwordLabel = new JLabel("PRINT REPORT");
        passwordLabel.setBounds(10,90,180,40);
        panel.add(passwordLabel);
          
        JButton  print = new JButton();
        print.setBounds(100,100,100,25);
        panel.add(print);
        
        JLabel Quit = new JLabel("QUIT");
        Quit.setBounds(10,150,180,40);
        panel.add( Quit);
        
        JButton  quit = new JButton();
        quit.setBounds(100,150,100,25);
        panel.add(quit);
        
        frame.setVisible(true);
      
     
        panel.add(makesale);
        
        


   
    }
        }
                
