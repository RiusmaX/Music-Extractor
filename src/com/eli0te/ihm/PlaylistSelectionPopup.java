package com.eli0te.ihm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PlaylistSelectionPopup extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;

    private JCheckBox checkBoxSelectAll;
    private JPanel buttonsContainer;
    private JPanel OkCabcelContainer;

    public PlaylistSelectionPopup(ArrayList<HashMap<String, String>> videoMapList ) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        //setModal(true);
        // getRootPane().setDefaultButton(buttonOK);

        /*JPanel[] videoPanel = new JPanel[videoMapList.size()];
        JLabel[] videoTitle = new JLabel[videoMapList.size()];
        ImagePanel[] videoImg = new ImagePanel[videoMapList.size()];
        JTextArea[] videoDesc = new JTextArea[videoMapList.size()];
        JTextField[] videoDuration = new JTextField[videoMapList.size()];
        JCheckBox[] videoDl = new JCheckBox[videoMapList.size()];*/

        JPanel mainPane = new JPanel();
        //mainPane.setLayout(new GridLayout( videoMapList.size(), 2));
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 500 , 400);
        contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500, 400));
        contentPane.add(scrollPane);
        for (int i = 0; i < videoMapList.size(); i++){
            panel.add(new VideoItem(videoMapList.get(i)));
        }
        contentPane.add(buttonsContainer);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

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
