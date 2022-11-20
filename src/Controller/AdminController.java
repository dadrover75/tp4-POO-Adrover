package Controller;

import Admin.Admin;
import Admin.AdminRepository;
import Client.*;
import Frames.Windows.ComponentAdmin;
import Frames.Windows.ComponentClient;
import Frames.Windows.ViewAdmin;
import Interfaces.IAdmin;
import Interfaces.IClient;
import Interfaces.IRepository;
import Interfaces.IUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

public class AdminController {
    public AdminController() {}
    public void AdminView() {
        ViewAdmin viewAdmin = new ViewAdmin();

        viewAdmin.setContentPane(viewAdmin.AdminView);
        viewAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewAdmin.pack();
        viewAdmin.setVisible(true);

        viewAdmin.clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComponentClient();
                viewAdmin.dispose();
            }
        });

        viewAdmin.empleadosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComponentAdmin();
                viewAdmin.dispose();
            }
        });
    }

    public void ComponentClient() {
        ComponentClient componentClient = new ComponentClient();
        componentClient.setContentPane(componentClient.panel1);
        componentClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentClient.pack();
        componentClient.setVisible(true);

        componentClient.textPane1.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                scrollTextPane(componentClient.textPane1, e.getWheelRotation());
            }
        });

        IRepository repository = new ClientRepository();

        componentClient.VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminView();
                componentClient.dispose();
            }
        });

        componentClient.AGREGARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IClient client = new Client();
                String name = componentClient.NombreTextField2.getText();
                String lastName = componentClient.ApellidoTextField3.getText();
                String email = componentClient.EmailTextField4.getText();
                try {
                    client.createClient(name, lastName, email);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                componentClient.NombreTextField2.setText("");
                componentClient.ApellidoTextField3.setText("");
                componentClient.EmailTextField4.setText("");
                JOptionPane.showMessageDialog(null, "Cliente "+name+" "+lastName+" agregado");
            }
        });

        componentClient.BUSCARButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String email = componentClient.SearchTextField1.getText();
                IClient user = new Client();
                try {
                    IUser client = user.readClient(email);
                    componentClient.NombreTextField2.setText(client.getFirstName());
                    componentClient.ApellidoTextField3.setText(client.getLastName());
                    componentClient.EmailTextField4.setText(client.getEmail());
                } catch (Exception exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                }
            }
        });

        componentClient.EDITARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = componentClient.NombreTextField2.getText();
                String lastName = componentClient.ApellidoTextField3.getText();
                String email = componentClient.SearchTextField1.getText();
                try {
                    new Client().updateClient(name, lastName, email);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                componentClient.SearchTextField1.setText("");
                componentClient.NombreTextField2.setText("");
                componentClient.ApellidoTextField3.setText("");
                componentClient.EmailTextField4.setText("");
                JOptionPane.showMessageDialog(null, "Cliente "+name+" "+lastName+" editado");
            }
        });

        componentClient.BORRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = componentClient.SearchTextField1.getText();
                try {
                    new Client().deleteClient(email);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                componentClient.SearchTextField1.setText("");
                componentClient.NombreTextField2.setText("");
                componentClient.ApellidoTextField3.setText("");
                componentClient.EmailTextField4.setText("");
                JOptionPane.showMessageDialog(null, "Cliente "+email+" borrado");
            }
        });

        componentClient.LISTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder clientsContent = new StringBuilder();
                    ArrayList<IUser> clients;
                    clients = (ArrayList<IUser>) repository.selectAll();

                    for (IUser client : clients) {
                        clientsContent.append("Nombre: ").append(client.getFirstName()).append("\nApellido: ").append(client.getLastName()).append("\nEmail: ").append(client.getEmail()).append("\n-------------------\n");
                    }


                    componentClient.textPane1.setText(clientsContent.toString());
                } catch (Exception exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No se pudo acceder a clientes");
                }
            }
        });

    }

    public void ComponentAdmin() {
        ComponentAdmin componentAdmin = new ComponentAdmin();
        componentAdmin.setContentPane(componentAdmin.panel);
        componentAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        componentAdmin.pack();
        componentAdmin.setVisible(true);

        componentAdmin.textPane1.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                scrollTextPane(componentAdmin.textPane1, e.getWheelRotation());
            }
        });

        IRepository repository = new AdminRepository();

        componentAdmin.VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminView();
                componentAdmin.dispose();
            }
        });

        componentAdmin.AGREGARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IAdmin admin = new Admin();
                String name = componentAdmin.NombreTextField2.getText();
                String lastName = componentAdmin.ApellidoTextField3.getText();
                String email = componentAdmin.EmailTextField4.getText();
                try {
                    admin.createAdmin(name, lastName, email);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                componentAdmin.NombreTextField2.setText("");
                componentAdmin.ApellidoTextField3.setText("");
                componentAdmin.EmailTextField4.setText("");
                JOptionPane.showMessageDialog(null, "Empleado "+name+" "+lastName+" agregado");
            }
        });

        componentAdmin.BUSCARButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String email = componentAdmin.SearchTextField1.getText();
                IAdmin user = new Admin();
                try {
                    IUser admin = user.readAdmin(email);
                    componentAdmin.NombreTextField2.setText(admin.getFirstName());
                    componentAdmin.ApellidoTextField3.setText(admin.getLastName());
                    componentAdmin.EmailTextField4.setText(admin.getEmail());
                } catch (Exception exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Empleado no encontrado");
                }
            }
        });

        componentAdmin.EDITARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = componentAdmin.NombreTextField2.getText();
                String lastName = componentAdmin.ApellidoTextField3.getText();
                String email = componentAdmin.SearchTextField1.getText();
                try {
                    new Admin().updateAdmin(name, lastName, email);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                componentAdmin.SearchTextField1.setText("");
                componentAdmin.NombreTextField2.setText("");
                componentAdmin.ApellidoTextField3.setText("");
                componentAdmin.EmailTextField4.setText("");
                JOptionPane.showMessageDialog(null, "Empleado "+name+" "+lastName+" editado");
            }
        });

        componentAdmin.BORRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = componentAdmin.SearchTextField1.getText();
                try {
                    new Admin().deleteAdmin(email);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                componentAdmin.SearchTextField1.setText("");
                componentAdmin.NombreTextField2.setText("");
                componentAdmin.ApellidoTextField3.setText("");
                componentAdmin.EmailTextField4.setText("");
                JOptionPane.showMessageDialog(null, "Empleado "+email+" borrado");
            }
        });

        componentAdmin.LISTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    StringBuilder adminsContent = new StringBuilder();
                    ArrayList<IUser> admins;
                    admins = (ArrayList<IUser>) repository.selectAll();

                    for (IUser admin : admins) {
                        adminsContent.append("Nombre: ").append(admin.getFirstName()).append("\nApellido: ").append(admin.getLastName()).append("\nEmail: ").append(admin.getEmail()).append("\n-------------------\n");
                    }


                    componentAdmin.textPane1.setText(adminsContent.toString());
                } catch (Exception exception) {
                    exception.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No se pudo acceder a clientes");
                }
            }
        });
    }

    private void scrollTextPane(JTextPane textPane1, int wheelRotation) {
        int scroll = textPane1.getScrollableBlockIncrement(textPane1.getVisibleRect(), SwingConstants.VERTICAL, wheelRotation);
        textPane1.scrollRectToVisible(new java.awt.Rectangle(0, textPane1.getY() + scroll, 1, 1));
    }
}
