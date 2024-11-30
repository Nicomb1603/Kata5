package es.ulpgc.is2.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SwingImageVisualizer extends JFrame implements ImageVisualizer {

    @Override
    public void show(byte[] imageBytes) {
        this.setTitle("es.ulpgc.dis.kata2.model.Histogram Display");
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);

        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
            ImageIcon icon = new ImageIcon(image);
            JLabel label = new JLabel(icon);
            this.add(label);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
