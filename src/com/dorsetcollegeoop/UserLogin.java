package com.dorsetcollegeoop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UserLogin extends JFrame {


    private JTextField textField;
    private JPasswordField passwordField;
    private JPanel contentPane;
    private JButton btnNewButton;


    public static void main(String[] args) {
        // write your code here
        System.out.println("this is user login ");

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Login Label
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);


        //Username Label
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        textField.setColumns(1);
        contentPane.add(textField);


        //Password Label
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);

        // Password Field
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 31));
        passwordField.setBounds(481, 286, 281, 68);
        passwordField.setColumns(1);
        contentPane.add(passwordField);

//Button
        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 73);


        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = textField.getText();
                String password = passwordField.getText();
                System.out.println("Button is pressed:" + userName + ": " + password);

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/titanicmanifest", "root", "root");

                    PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement("select name, password from student where name=? and password = ?");


                    preparedStatement.setString(1, userName);
                    preparedStatement.setString(2, password);


                    ResultSet rs = preparedStatement.executeQuery();
                    if (rs.next()) {
                        System.out.println("Logging IN");
                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
                    } else {
                        System.out.println("Not allowed to login");
                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
                    }


                } catch (Exception ex) {
                    System.out.println(ex);
                } finally {

                }


            }
        });


        contentPane.add(btnNewButton);

    }


}
