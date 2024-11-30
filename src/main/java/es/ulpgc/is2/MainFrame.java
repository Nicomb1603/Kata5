package es.ulpgc.is2;

import es.ulpgc.is2.control.LoadRandomUserCommand;
import es.ulpgc.is2.view.SwingImageVisualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    LoadRandomUserCommand command;
    SwingImageVisualizer imageVisualizer;
    JLabel name;
    JLabel email;
    JLabel gender;
    JButton randomUserButton;

    public MainFrame(){

        initializeComponents();

        this.setTitle("MainFrame");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        JPanel userInfoPanel = new JPanel(new GridLayout(3, 1));
        userInfoPanel.add(name);
        userInfoPanel.add(email);
        userInfoPanel.add(gender);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(imageVisualizer, BorderLayout.WEST);
        mainPanel.add(userInfoPanel, BorderLayout.CENTER);

        this.add(randomUserButton, BorderLayout.NORTH);
        this.add(mainPanel, BorderLayout.SOUTH);


    }

    private void initializeComponents() {
        imageVisualizer = new SwingImageVisualizer();
        name = new JLabel();
        email = new JLabel();
        gender = new JLabel();
        randomUserButton = new JButton("Load New User");
        randomUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getRandomUser();
                displayUser();
            }
        });
    }

    private void displayUser() {
        imageVisualizer.show(command.getUsers().getFirst().getPhoto());
        name.setText( "NAME: " + command.getUsers().getFirst().getName() + command.getUsers().getFirst().getSurname());
        gender.setText( "GENDER: " + command.getUsers().getFirst().getGender());
        email.setText( "EMAIL: " + command.getUsers().getFirst().getEmail());

    }

    private void getRandomUser() {
        command = new LoadRandomUserCommand(1);
        command.execute();
    }


}
