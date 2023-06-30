
package restaurant.menu;

        
        

   
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 *
 */
public class MENU {
    static int numClicks ;
    static double totalCost = 0;
    int  nBeef = 0;
    int nChicken = 0;
  int   nCrispy = 0;
    int lol = 0;
    int werra = 0;
    int web = 0;
    int willy = 0;
    public MENU(){
        makeOrder();

    }
    
    public void makeOrder(){
        //  here , we made samething that each time the cashier would like to place order , the cashier will need to press the 
        //  button so that the order can be placed.
        JFrame frame = new JFrame(" OUR MENU ");
        frame.setBounds(0, 0, 2000, 2000);
        frame.setLayout(null);
        
        JLabel vie = new JLabel("WELCOME,WHAT DO YOU WANT TO ORDER");
        vie.setBounds(0,0,500,70);
        vie.setHorizontalAlignment(SwingConstants.CENTER);
        vie.setFont(new Font("Serif", Font.BOLD, 25));
         frame.getContentPane().setBackground(Color.BLACK);
        
        JLabel total = new JLabel("TOTAL: ");
        total.setBounds(350, 420, 100, 30);
        
        JTextArea show = new JTextArea();
        show.setBounds(50, 100, 380, 300);
        show.setBackground(Color.lightGray);
        
        JButton Beef = new JButton(" POT-STEAMED BLACK MUSSELS ");
        Beef.setBounds(50, 50, 150, 30);
        Beef.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                show.append("R125 POT - STEAMED BLACK MUSSELS\n");
                totalCost = totalCost + 125;
                nBeef += 1;
                total.setText("TOTAL: " + totalCost);
            }
        });
        JButton Chicken = new JButton(" BUTTER - BASTED GARLIC PRAWNS ");
        Chicken.setBounds(200, 50, 150, 30);
        Chicken.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                show.append("R145 BUTTER - BASTED GARLIC PRAWNS \n");
                totalCost = totalCost + 145;
                nCrispy += 1;
                total.setText("TOTAL: " + totalCost);
            }
        });
        
          JButton Chick = new JButton("  CRISPY CURLY BABY PRAWNS ");
        Chick.setBounds(350, 50, 250, 30);
        Chick.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                show.append("R135 CRISPY CURLY BABY PRAWNS\n");
                totalCost = totalCost + 135;
                nChicken += 1;
                total.setText("TOTAL: " + totalCost);
            }
        });
        
         JButton C= new JButton("  BEEF CARPAGGIO ");
        C.setBounds(600, 50, 300, 30);
        C.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                show.append("R115 BEEF CARPAGGIO \n");
                totalCost = totalCost + 115;
                lol += 1;
                total.setText("TOTAL: " + totalCost);
            }
        });
        
        
        
        
         JButton wewe= new JButton("  SIGNATURE CHIKEN WINGS  ");
        wewe.setBounds(800, 50, 400, 30);
        wewe.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                show.append("R135 SIGNATURE CHIKEN WINGS \n");
                totalCost = totalCost + 135;
                werra += 1;
                total.setText("TOTAL: " + totalCost);
                   }
        });
        
         JButton we= new JButton("  COATED & FRIED HALLOUMI ");
        we.setBounds(500, 10, 200, 40);
        we.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                show.append("R115 COATED & FRIED HALLOUMI   \n");
                totalCost = totalCost + 115;
                web += 1;
                total.setText("TOTAL: " + totalCost);
                   }
        });
          JButton six= new JButton("  RIP & DIP HUMMUS ");
        six.setBounds(500, 90, 90, 70);
        six.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                show.append("R105 RIP & DIP HUMMUS   \n");
                totalCost = totalCost + 105;
                willy += 1;
                total.setText("TOTAL: " + totalCost);
                   }
        });
        
        
        
        
        JButton btnClear = new JButton("cancel");
        btnClear.setBounds(50, 420, 100, 30);
        btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                show.setText("");
                totalCost = 0;
                nBeef = 0;
                nChicken = 0;
                total.setText("TOTAL: " + totalCost);
            }
        });
        
        JButton btnSubmit = new JButton("PLEASE PLACE YOUR ORDER");
        btnSubmit.setBounds(180, 420, 500, 30);
        btnSubmit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                reportSale();
                
                frame.dispose();
            }
        });
        frame.add(wewe);
        frame.add(vie);
        frame.add(Beef);
        frame.add(Chicken);
        frame.add(show);
        frame.add(total);
        frame.add(btnClear);
        frame.add(btnSubmit);
         frame.add( Chick);
          frame.add( C);
          frame.add(we);
          frame.add(six);
        frame.setVisible(true);
    }
    
    public void reportSale(){
        numClicks = numClicks + 1;
        String message = "Your ticket: MK00" + numClicks;
        message = message + "\nYou ordered the following items :";
        message = message + "\n    POT-STEAMED BLACK MUSSELS: " + nBeef;
        message = message + "\n    BUTTER - BASTED GARLIC PRAWNS: " + nChicken;
        message = message + "\n    CRISPY CURLY BABY PRAWNS : " + nCrispy;
        message = message + "\n BEEF CARPAGGIO   " + lol;
       
        message = message + "\n SIGNATURE CHIKEN WINGS " + werra;
        message = message + "\n COATED & FRIED HALLOUMI" + web; 
          message = message + "\n RIP & DIP HUMMUS " + willy;
        
         message = message + "\nTotal cost: " + totalCost;
        JOptionPane.showMessageDialog(null, message , " well done .Order completed", JOptionPane.INFORMATION_MESSAGE);
        
        
    }
        
        
              
        }
                
                
                                   
        



        
        
                
    





        
        
     
        
        
        
        
        
    