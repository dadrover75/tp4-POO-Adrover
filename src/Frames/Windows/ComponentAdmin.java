package Frames.Windows;

import javax.swing.*;


    public class ComponentAdmin extends JFrame {
        public JPanel panel;
        public JTextField SearchTextField1;
        public JButton BUSCARButton;
        public JButton LISTARButton;
        public JTextField NombreTextField2;
        public JTextField ApellidoTextField3;
        public JTextField EmailTextField4;
        public JButton AGREGARButton;
        public JButton EDITARButton;
        public JButton BORRARButton;
        public JTextPane textPane1;
        public JButton VOLVERButton;

        public ComponentAdmin() {
            super("ComponentAdmin");

        }

        public void setData(ComponentClient data) {
        }

        public void getData(ComponentClient data) {
        }

        public boolean isModified(ComponentClient data) {
            return false;
        }
    }
