// GUIInterface.java (GUI implementation using Swing or JavaFX)
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiInterface extends JFrame {
    private Library library = new Library();
    private JTextArea outputArea;
    private JTextField inputField;

    public GuiInterface() {
        this.setTitle("Library System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLayout(new BorderLayout());

        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);
        outputArea.setEditable(false);

        inputField = new JTextField();
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String command = inputField.getText();
                processCommand(command);
                inputField.setText("");
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(new JLabel("Enter command: "), BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private void processCommand(String command) {
        // Implement logic to process commands
    }

    public static void main(String[] args) {
        new GuiInterface();
    }
}
