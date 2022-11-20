package Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn {

    private JPanel header;
    private JFormattedTextField email;
    private JButton LogIn;
    private JPasswordField sfgsResrPasswordField;

    public LogIn() {
        LogIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
