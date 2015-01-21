package com.eli0te.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PlaylistSelectionPopup extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JPanel mainPane;
    private JCheckBox checkBoxSelectAll;

    public PlaylistSelectionPopup(ArrayList<HashMap<String, String>> videoMapList ) {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        JPanel[] videoPanel = new JPanel[videoMapList.size()];
        JLabel[] videoTitle = new JLabel[videoMapList.size()];
        ImagePanel[] videoImg = new ImagePanel[videoMapList.size()];
        JTextArea[] videoDesc = new JTextArea[videoMapList.size()];
        JTextField[] videoDuration = new JTextField[videoMapList.size()];
        JCheckBox[] videoDl = new JCheckBox[videoMapList.size()];

        mainPane.setLayout(new GridLayout( videoMapList.size(), 2));

        for (int i = 0; i < videoMapList.size(); i++){
            videoPanel[i] = new JPanel(new GridLayout(3,2));
            videoTitle[i] = new JLabel(videoMapList.get(i).get("title"));
            videoImg[i] = new ImagePanel(videoMapList.get(i).get("thumbnail"));
            videoDesc[i] = new JTextArea(videoMapList.get(i).get("description"));
            videoDuration[i] = new JTextField(videoMapList.get(i).get("duration"));
            videoDl[i] = new JCheckBox("À télécharger ? ", true);

            videoPanel[i].add(videoTitle[i]);
            videoPanel[i].add(videoImg[i]);
            videoPanel[i].add(videoDesc[i]);
            videoPanel[i].add(videoDuration[i]);
            videoPanel[i].add(videoDl[i]);


            mainPane.add(videoPanel[i]);
            videoPanel[i].setVisible(true);
        }

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        pack();
        setVisible(true);
    }

    private void onOK() {
    // add your code here
        dispose();
    }

    private void onCancel() {
    // add your code here if necessary
        dispose();
    }
}
