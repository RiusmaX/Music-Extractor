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

    private JCheckBox checkBoxSelectAll;
    private JPanel panelVideoList;
    private JPanel buttonPane;

    public PlaylistSelectionPopup(ArrayList<HashMap<String, String>> videoMapList ) {

        super();

        panelVideoList.setLayout(new GridLayout( videoMapList.size(), 1));
        for (int i = 0; i < videoMapList.size(); i++){
            panelVideoList.add(new VideoItem(videoMapList.get(i)));
        }

      //  JScrollPane scrollPane = new JScrollPane(panelVideoList);
      //  scrollPane.setBounds(0,0,600,450);

//        scrollPane.add(panelVideoList);
//        scrollPane.setPreferredSize(new Dimension(200, 100));
//        scrollPane.setBounds(0, 0, 500, 500);
//        videoContentPane.add(scrollPane, BorderLayout.CENTER);
//

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx = 0;
        c.gridy = 0;
        add(panelVideoList, c);

        c.gridx = 0;
        c.gridy = 1;
        add(buttonPane, c);
        pack();
        setMaximumSize(new Dimension(600, 800));
        setVisible(true);

        /*
            TEMP
                    scrollPane.add(panelVideoList);
                    panelVideoList.setVisible(true);
                    scrollPane.setVisible(true);
                    contentPane.setVisible(true);
                    add(panelVideoList);
                    add(contentPane);
                    pack();
                    setVisible(true);

         */

        //setModal(true);
        // getRootPane().setDefaultButton(buttonOK);

        /*JPanel[] videoPanel = new JPanel[videoMapList.size()];
        JLabel[] videoTitle = new JLabel[videoMapList.size()];
        ImagePanel[] videoImg = new ImagePanel[videoMapList.size()];
        JTextArea[] videoDesc = new JTextArea[videoMapList.size()];
        JTextField[] videoDuration = new JTextField[videoMapList.size()];
        JCheckBox[] videoDl = new JCheckBox[videoMapList.size()];*/

        //JPanel mainPane = new JPanel();
/*

    // Marius Part

        panel.setLayout(new GridLayout( videoMapList.size(), 2));
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(0, 0, 1000 , 900);
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
 */


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
