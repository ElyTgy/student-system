import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementGUI extends JFrame {
    private JTextField inputBox;
    private JButton sendButton;
    private JLabel statusLabel;
    private Class classroom;

    public StudentManagementGUI(Class classroom) {
        this.classroom = classroom;
        initializeUI();
    }

    private void initializeUI() {
        // Set layout to null for absolute positioning
        setLayout(null);

        // Label with updated text
        JLabel label = new JLabel("<html>Enter the ID of the student to send their marks to their parents</html>");
        label.setBounds(10, 10, 300, 40);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);

        // Input Box
        inputBox = new JTextField();
        inputBox.setBounds(60, 60, 200, 25);
        add(inputBox);

        // Send Button
        sendButton = new JButton("Send");
        sendButton.setBounds(60, 90, 200, 25);
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendEmail();
            }
        });
        add(sendButton);

        // Status Label
        statusLabel = new JLabel("");
        statusLabel.setBounds(10, 120, 300, 25);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(statusLabel);

        // Frame settings
        setSize(320, 200);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

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
        }
    }
}