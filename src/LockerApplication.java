import javax.swing.*;
import java.awt.*;

public class LockerApplication extends JFrame {
    private String password = null;
    private JTextField statusField;

    public LockerApplication() {
        setTitle("Locker Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(4, 3));
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(e -> updatePasswordField(e.getActionCommand()));
            add(button);
        }
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> statusField.setText(""));
        add(clearButton);

        JButton enterButton = new JButton("Enter");
        enterButton.addActionListener(e -> handleEnter());
        add(enterButton);
        add(new JLabel());
        statusField = new JTextField();
        statusField.setEditable(false);
        add(statusField);
        updateStatusField("Enter Passcode");
    }

    private void updatePasswordField(String digit) {
        if (statusField.getText().equals("Enter Passcode") || statusField.getText().equals("Password Set") || statusField.getText().equals("Correct Password") || statusField.getText().equals("Incorrect Password")) {
            statusField.setText(digit);
        } else {
            statusField.setText(statusField.getText() + digit);
        }
    }

    private void handleEnter() {
        String enteredPassword = statusField.getText();
        if (password == null) {
            password = enteredPassword;
            updateStatusField("Password Set");
        } else {
            if (enteredPassword.equals(password)) {
                updateStatusField("Correct Password");
            } else {
                updateStatusField("Incorrect Password");
            }
        }
    }

    private void updateStatusField(String message) {
        statusField.setText(message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LockerApplication app = new LockerApplication();
            app.setVisible(true);
        });
    }
}
