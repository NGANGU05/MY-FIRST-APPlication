package PoePart2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TASK {

    String Last3;
    String DevDetail;
    String TaskNam;

    String TaskD;
    String Tn;
    String Duration;
    static int TaskNum = 0;

    public TASK() {

        String[] Options = {"ADD TASK", "STOP"};

        int val = JOptionPane.showOptionDialog(null,
                "Please select an option",
                "Welcome To EasyKanBan",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE, null,
                Options,
                0);
        System.out.println(val);

        while (val != 1) {
            if (val == 0) {

                TaskNum();
                break;
            }
            if (val == 2) {
                break;
            }
        }
    }

    public static boolean TaskNum() {
        String Number = JOptionPane.showInputDialog("Please add number of tasks");
        int x = Integer.parseInt(Number);
        for (int i = 0; i < x; i++) {
            TaskMaker();
        }
        return true;

    }

    public static boolean TaskMaker() {
        String TaskNam = JOptionPane.showInputDialog("Enter Task Name");

        //This alllows us to input a task description with a character limit of 50 characters
        String TaskD = JOptionPane.showInputDialog("Task Description");
        Pattern P = Pattern.compile("((?=.*[a-z]).{0,50})");
        Matcher M = P.matcher(TaskD);
        boolean exitLoop = false;
        while (exitLoop == false) {

            P = Pattern.compile("((?=.*[a-z]).{0,50})");
            M = P.matcher(TaskD);
            if (M.matches()) {
                JOptionPane.showMessageDialog(null, "Task successfully caputured");
                exitLoop = true;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                JOptionPane.showInputDialog("Task Description");
                return exitLoop = true;

            }
        }

        String DevDetail = JOptionPane.showInputDialog("Developer Details (First and Last Name)");
        String Duration = JOptionPane.showInputDialog("Task Duration (hours)");

        //Allows us to select first two letters of task name entered
        String Tn = TaskNam.substring(0, 2);
        String Last3 = DevDetail.substring(DevDetail.length() - 3);
        System.out.println(Tn);
        System.out.println(Last3);

        JOptionPane.showMessageDialog(null, "Task ID is " + (Tn + ":" + TaskNum + ":" + Last3).toUpperCase());

        //ID that contains first 2 lessons of Task Name, Task Number, last 3 letters of developer name
        String[] Status = {"To Do", "Doing", "Done"};

        int status = JOptionPane.showOptionDialog(null,
                "Please select Task Status",
                "Status",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                Status,
                0);

        String statusMessage = "";
        if (status == 0) {
            statusMessage = "TO DO ";
        } else if (status == 1) {
            statusMessage = "do";
        } else if (status == 2) {
            statusMessage = "Done";
        }

        //This will be displayed in the following order: Task Status, Developer Details, Task Number, Task Name, Task Description, Task ID and Duration
        JOptionPane.showMessageDialog(null,
                "Task Status: " + statusMessage + "\n"
                + "Developer Details: " + DevDetail + "\n"
                + "Task Number: " + TaskNum + "\n"
                + "Task Name: " + TaskNam + "\n"
                + "Task Description: " + TaskD + "\n"
                + "Task ID is " + ((Tn + ":" + TaskNum + ":" + Last3).toUpperCase()) + "\n"
                + "Task Duration: " + Duration + " hours");

        //This will be displayed in the following order: Task Status, Developer Details, Task Number, Task Name, Task Description, Task ID and Duration
        TaskNum = TaskNum + 1;
        
        
        
        
        return true;
    }
    
    TASK app = new TASK();

    public boolean myboolean(boolean myboo) {

        String taskdes = app.DevDetail;
        if (taskdes.length() <= 50) {
            myboo = true;
        } else {
            myboo = false;
        }
        return myboo;
    }

    public String mystring(String mystring) {
        String taskid = app.TaskD;

        return taskid;
    }

    public String duration(String time) {
        String num = app.Duration;
        time = num;

        return time;

    }

    public String mystring2(String display) {
        display = app.DevDetail;
        return display;
    }

}


