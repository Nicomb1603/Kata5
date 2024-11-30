package es.ulpgc.is2;

import es.ulpgc.is2.control.LoadRandomUserCommand;
import es.ulpgc.is2.view.ImageVisualizer;
import es.ulpgc.is2.view.SwingImageVisualizer;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    LoadRandomUserCommand command;
    public MainFrame(){
        SwingImageVisualizer imageVisualizer = new SwingImageVisualizer();
        command = new LoadRandomUserCommand(1);
        command.execute();
        this.setTitle("MainFrame");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        imageVisualizer.show(command.getUsers().getFirst().getPhoto());
        this.add(imageVisualizer, BorderLayout.CENTER);

    }



}
