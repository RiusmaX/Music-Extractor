package com.eli0te.ihm;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

/**
 * Created by eLi0tE on 22/01/15.
 */
public class VideoItem extends JPanel {
    private JLabel titre;
    private JCheckBox àTéléchargerCheckBox;
    private JPanel miniature;
    private JScrollPane myScroll;
    private JTextArea description;
    private String imageURL;

    public VideoItem(HashMap<String, String> infos) {
        setLayout(new GridLayout(2,2));

        description = new JTextArea(infos.get("description"));

        miniature = new ImagePanel(infos.get("thumbnail"));
        titre = new JLabel(infos.get("title"));


        myScroll = new JScrollPane(description);

        add(titre);
        add(myScroll);
        add(miniature);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        miniature = new ImagePanel("");
    }
}
