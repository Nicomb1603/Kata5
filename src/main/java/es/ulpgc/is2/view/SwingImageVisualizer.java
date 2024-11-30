package es.ulpgc.is2.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SwingImageVisualizer extends JPanel implements ImageVisualizer {

    @Override
    public void show(byte[] imageBytes) {
        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
            ImageIcon icon = new ImageIcon(image);
            JLabel label = new JLabel(icon);
            this.add(label, BorderLayout.CENTER);
            this.revalidate();
            this.repaint();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
