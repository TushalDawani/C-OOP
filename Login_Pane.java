package JAVA_GUI_BASICS;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Page extends JFrame implements ActionListener {

    // Creating JButton:
    JButton loginButton = new JButton("Login");


    JTextField nameTextField = new JTextField();
    JPasswordField passwordTextField = new JPasswordField();

    public Login_Page(){

        Border border1 = BorderFactory.createLineBorder(Color.BLACK, 2);

        // Some Method for JButton:
        loginButton.setFont(new Font("Arial", Font.BOLD, 13));
        loginButton.setForeground(Color.black);
        loginButton.setBackground(Color.YELLOW);
        loginButton.setBounds(59, 269, 165, 22);
        loginButton.addActionListener(this);


        // Creating JLabels:
        JLabel loginLabel = new JLabel();
        loginLabel.setText("Login");
        loginLabel.setFont(new Font("Script Fonts", Font.BOLD, 40));
        loginLabel.setForeground(Color.black);
        loginLabel.setBounds(88,9,200,50);

        JLabel nameLabel = new JLabel();
        nameLabel.setText("CMS ID");
        nameLabel.setForeground(Color.black);
        nameLabel.setBounds(59, 125,100,12);
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 13));

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password");
        passwordLabel.setForeground(Color.black);
        passwordLabel.setBounds(59,190,100,12);
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 13));


        // Creating Border:
        Border border = BorderFactory.createLineBorder(Color.BLUE,2);


        // TextField:
        nameTextField.setBackground(Color.WHITE);
        nameTextField.setBounds(60, 140, 165, 22);
        nameTextField.setBorder(border);



        // JPasswordField --> it hides the password
        passwordTextField.setBackground(Color.white);
        passwordTextField.setBounds(60,205, 165, 22);
        passwordTextField.setBorder(border);


        // Some Methods for JFrame:
        setSize(350,410);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setResizable(false);


        // Adding Components into JFrame:
        add(loginLabel);
        add(nameLabel);
        add(nameTextField);
        add(passwordLabel);
        add(passwordTextField);
        add(loginButton);


        setVisible(true); // sets the visibillity of the JFrame

    }

    public static void main(String[] args) {
        new Login_Page();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton){

            String cmsId = nameTextField.getText();
            String password = passwordTextField.getText();

            if (cmsId.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(this, "Kindly fill all the records!", "Warning", JOptionPane.WARNING_MESSAGE);
            }


            // Check if username is correct
            if (!cmsId.equals("023-24-0487")) {
                JOptionPane.showMessageDialog(this, "Incorrect CMS ID", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
            // Username is correct, now check password
            else if (!password.equals("admin123")) {
                JOptionPane.showMessageDialog(this, "Incorrect Password", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
            // Both correct
            else {
                JOptionPane.showMessageDialog(this, "Login Successful!", "Welcome", JOptionPane.INFORMATION_MESSAGE);
            }

            }

        }
    }
