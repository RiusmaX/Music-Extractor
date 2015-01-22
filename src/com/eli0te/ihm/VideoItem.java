package com.eli0te.ihm;

import javax.swing.*;
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
        add(description);
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
