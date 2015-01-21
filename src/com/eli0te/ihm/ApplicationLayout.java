package com.eli0te.ihm;

import com.eli0te.helpers.YoutubeHelper;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by eLi0tE on 16/01/15.
 */
public class ApplicationLayout extends JFrame implements  ActionListener, PropertyChangeListener{

	private static final long serialVersionUID = 1L;

	// Swing Components
    private JTabbedPane serviceChooserPane;
    private JPanel mainPanel;
    private JPanel youtubePaneContent;
    private JTextField youtubeURLField;
    private JButton downloadButton;
    private JProgressBar progressBar1;
    private JTextField directoryTextField;
    private JButton directoryButton;
    private JList myEventsList;
    private JPanel SoundcloudPaneContent;
    private JFileChooser chooser;
    private DefaultListModel model;

    // Other Components
    private String homeDirectory = System.getProperty("user.home");
    public final ApplicationLayout al = this;
    public int progress = 0;
    private Task task;

    public ApplicationLayout(){
        directoryTextField.setText(homeDirectory);
        youtubeURLField.setText("https://www.youtube.com/watch?v=2F6d6crjRyU");



        // Log console init
        model = new DefaultListModel();
        updateEventList("Bienvenue sur Music Extractor");
        myEventsList.setModel(model);

        // directory chooser button event.
        directoryButton.setActionCommand("fileChooser");
        directoryButton.addActionListener(this);


        // download button event
        downloadButton.setActionCommand("download");
        downloadButton.addActionListener(this);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frame = new JFrame("Music Extractor");
        frame.setTitle("Music Extractor");
        frame.setContentPane(new ApplicationLayout().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        switch (command){
            case "download":
                downloadButton.setEnabled(false);
                setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                task = new Task();
                task.addPropertyChangeListener(this);
                task.execute();
                break;
            case "fileChooser":
                chooser = new JFileChooser();
                chooser.setCurrentDirectory(new java.io.File(directoryTextField.getText()));
                chooser.setDialogTitle("Répertoire de sauvegarde");
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(getParent()) == JFileChooser.APPROVE_OPTION) {
                    directoryTextField.setText(chooser.getSelectedFile().getAbsolutePath());
                    updateEventList("Sélection du dossier de téléchargement : " + chooser.getSelectedFile().getAbsolutePath());
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid Action Event Command : "+command);
        }
    }


    class Task extends SwingWorker<Void, Void> {
        @Override
        public Void doInBackground() {
            System.out.println("Début du processus");
            YoutubeHelper yh = new YoutubeHelper();
            setProgress(0);
            try {
                if(!youtubeURLField.getText().isEmpty() && !directoryTextField.getText().isEmpty())
                    yh.getAudio(youtubeURLField.getText(), directoryTextField.getText(), al);
            } catch (Exception ex){
                ex.printStackTrace();
            }
            return null;
        }


        @Override
        protected void done() {
            try {
                System.out.println("Processus terminé");
                downloadButton.setEnabled(true);
            } catch (Exception ignore) {
            }
        }
    }

    /**
     * Invoked when task's progress property changes.
     */
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            progressBar1.setValue(progress);
            System.out.println(String.format("Completed %d%% of task.\n", task
                    .getProgress()));
        }
    }



    // TODO: Perform update of the console in real time !!! (It seems we need to extends SwingWorker Class)
    // http://www.coderanch.com/t/499248/GUI/java/setText-updating-promptly

    public void updateProgressBar(int percentage){
        progressBar1.setValue(percentage);
    }
    public void updateEventList(String myEvent) {
        // Log into listbox
        model.addElement(myEvent);
    }
}
