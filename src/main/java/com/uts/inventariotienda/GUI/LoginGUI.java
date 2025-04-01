package com.uts.inventariotienda.GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.uts.inventariotienda.dao.impl.LoginDAOImpl;
import com.uts.inventariotienda.dao.interfaces.ILoginDAO;
import com.uts.inventariotienda.dto.LoginDTO;
import com.uts.inventariotienda.model.Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    private ILoginDAO loginDAO;

    public LoginGUI() {
    	loginDAO = new LoginDAOImpl();
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        // Título
        setTitle("Iniciar Sesión");

        // Crear componentes
        JLabel emailLabel = new JLabel("Correo Electrónico:");
        emailLabel.setBounds(72, 186, 88, 13);
        emailField = new JTextField(20);
        emailField.setBounds(274, 183, 166, 19);
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setBounds(72, 267, 56, 13);
        passwordField = new JPasswordField(20);
        passwordField.setBounds(274, 264, 166, 19);
        loginButton = new JButton("Iniciar Sesión");
        loginButton.setBounds(184, 340, 95, 21);
        contentPane.setLayout(null);

        // Añadir los componentes al layout
        contentPane.add(emailLabel);
        contentPane.add(emailField);
        contentPane.add(passwordLabel);
        contentPane.add(passwordField);
        JLabel label = new JLabel();
        label.setBounds(506, 20, 0, 0);
        contentPane.add(label); 
        contentPane.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                
                LoginDTO loginDTO = new LoginDTO(email, password);
                
                Usuario usuario = loginDAO.login(loginDTO);

                if (usuario != null) {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Bienvenido " + usuario.getNombreUsuario());
                } else {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Correo o contraseña incorrectos");
                }
            }
        });
    }

}
