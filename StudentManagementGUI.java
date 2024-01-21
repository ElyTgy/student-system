import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class StudentManagementGUI extends JFrame {
    //instance variables
    private JTextField inputBox;
    private JButton sendButton;
    private JLabel statusLabel;
    private Class classroom;

    
    
    
    
    /**
     * Summary: Constructor
     * @param: [Class] classroom: the classroom that the IDs will be checked from
     * @return: None
     */
    public StudentManagementGUI(Class classroom) {
        this.classroom = classroom;
        initializeUI();
    }//End of constructor

    
    
    
    
    /**
     * Summary: Called in the constructor to draw the JFrame components to screen
     * @param: None
     * @return: None
     */
    private void initializeUI() {
        setLayout(null);

        JLabel label = new JLabel("<html>Enter the ID of the student to send their marks to their parents</html>");
        label.setBounds(10, 10, 300, 40);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);

        inputBox = new JTextField();
        inputBox.setBounds(60, 60, 200, 25);
        add(inputBox);

        sendButton = new JButton("Send");
        sendButton.setBounds(60, 90, 200, 25);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendEmail();
            }
        });
        add(sendButton);

        statusLabel = new JLabel("");
        statusLabel.setBounds(10, 120, 300, 25);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(statusLabel);

        setSize(320, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//END of initailizeUI
    
    
    
    
    
    /**
     * Summary: Checks the user input to see if the entered ID is in class and updates the GUI accordingly
     * @param: None
     * @return: None
     */
    private void sendEmail() {
        String studentID = inputBox.getText();
        boolean studentExists = classroom.classList.stream()
            .anyMatch(student -> student.studentID.equals(studentID));

        if (studentExists) {
            inputBox.setText("");
            statusLabel.setForeground(Color.GREEN);
            statusLabel.setText("Email sent");
        } else {
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("No student with that ID exists");
        }//END of if-else
    }//END of sendEmail
}//END of StudentManagementGUI