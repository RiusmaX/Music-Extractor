package com.eli0te.ihm;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by Marius on 21/01/2015.
 */
public class VideoItem extends JPanel{


    private JTextArea description;
    private ImagePanel migniature;
    private JLabel titre;

    public VideoItem(HashMap<String, String> infos){
        super();
        setSize(new Dimension(150,100));
        add(description);
        description.setSize(new Dimension(50,50));
        migniature = new ImagePanel(infos.get("thumbnail"));
        add(migniature);
        add(titre);
        titre.setText(infos.get("title"));
        description.setText(infos.get("description"));
    }

    private void createUIComponents(){
        description = new JTextArea();
        migniature = new ImagePanel("");
        titre = new JLabel();
    }
}
