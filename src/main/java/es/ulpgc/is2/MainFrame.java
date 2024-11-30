package es.ulpgc.is2;

import es.ulpgc.is2.control.LoadRandomUserCommand;
import es.ulpgc.is2.view.SwingImageVisualizer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    LoadRandomUserCommand command;
    SwingImageVisualizer imageVisualizer;

    public MainFrame(){
        imageVisualizer = new SwingImageVisualizer();
        getRandomUser();
        this.setTitle("MainFrame");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        showPhoto();
        this.add(imageVisualizer, BorderLayout.CENTER);

    }

    private void showPhoto() {
        imageVisualizer.show(command.getUsers().getFirst().getPhoto());
    }

    private void getRandomUser() {
        command = new LoadRandomUserCommand(1);
        command.execute();
    }


}
