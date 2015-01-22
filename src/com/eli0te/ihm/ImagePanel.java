package com.eli0te.ihm;

/**
 * Created by eLi0tE on 21/01/15.
 */
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{

    private Image image;

    public ImagePanel(String url) {
        try {
            image = ImageIO.read(new URL((url)));
        } catch (IOException ex) {
            // handle exception...
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, 200, 200, null); // see javadoc for more info on the parameters
    }

}