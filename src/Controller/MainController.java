package Controller;

import Frames.Windows.ViewMain;

import javax.swing.*;
import java.awt.event.*;

public class MainController {

    public MainController() {
        ViewMain viewMain = new ViewMain();
        viewMain.setContentPane(viewMain.mainPanel);
        viewMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewMain.pack();
        viewMain.setVisible(true);

        viewMain.adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminController().AdminView();
                viewMain.dispose();
            }
        });

//        viewMain.vetButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                VetController vetController = new VetController();
//                viewMain.dispose();
//                vetController.VetView();
//            }
//      });

    }
//    public MainController() {
//        viewMain = new ViewMain();
//        viewMain.setVisible(true);
//        viewMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        viewMain.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
//                System.exit(0);
//            }
//        });
//    }
}
