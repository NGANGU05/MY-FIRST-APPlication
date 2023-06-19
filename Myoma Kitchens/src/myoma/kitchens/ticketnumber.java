
package myoma.kitchens;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Flranklin
 */
public class ticketnumber {

    public ticketnumber() {
        
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        int ticketnumber;

        frame.setSize(900,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
        
        frame.setVisible(true);   
        
        JLabel ticketLabel =  new JLabel("TICKET NUMBER");
        ticketLabel.setBounds(100,30,200,25);
        panel.add(ticketLabel);

        JTextField ticketText = new JTextField();
        ticketText.setBounds(200,30,265,25);
        panel.add(ticketText);
        

    
    }
}