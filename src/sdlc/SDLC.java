/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlc;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author frche1699
 */
public class SDLC {

    private static JFrame f;
    private static Question questions[];
    private static String[] topics, texts;
    private static boolean mac;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // set windows / mac os look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        
        String system = System.getProperty("os.name").toLowerCase();
        mac = system.contains("mac");

        // read datafile
        File qf = new File("questions");
        Scanner scq = null;
        try {
            scq = new Scanner(qf);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Question bank not found", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

        // read them into the questions
        int n = scq.nextInt();
        scq.nextLine();
        if (n < 10) {
            JOptionPane.showMessageDialog(null, "The number of questions should not be less than 10", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(2);
        }
        questions = new Question[n];
        for (int i = 0; i < n; i++) {
            String q = scq.nextLine();
            String o1 = scq.nextLine();
            String o2 = scq.nextLine();
            String o3 = scq.nextLine();
            String o4 = scq.nextLine();
            String oc = scq.nextLine();
            questions[i] = new Question(q, new String[]{o1, o2, o3, o4}, oc);
        }

        // read study notes
        ArrayList<String> topics = new ArrayList();
        ArrayList<String> texts = new ArrayList();
        try {
            File f = new File("notes");
            Scanner s = new Scanner(f);
            
            s.nextLine();
          
            topics.add(s.nextLine());
            
            String txt = "";
            while (s.hasNextLine()) {
                String ss = s.nextLine();
                
                if (ss.equals("---")) {
                    topics.add(s.nextLine());
                    texts.add(txt);
                    txt = "";
                } else {
                    txt += ss;
                }
            }
            texts.add(txt);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Study notes not found", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(3);
        }
        SDLC.setTopics(topics.toArray(new String[0]));
        SDLC.setTexts(texts.toArray(new String[0]));

        // show the JFrame
        f = new JFrame("SDLC") {
            {
                this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                this.setContentPane(new Welcome());
                this.setPreferredSize(new Dimension(510, 500));
                this.setMinimumSize(new Dimension(510, 500));
                this.setResizable(false);
                this.pack();
                this.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        // window closing confirmation
                        int choice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            System.exit(0);
                        }
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {
                        // prevents the user from minimizing the window
                        ((JFrame) e.getWindow()).setState(JFrame.NORMAL);
                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {
                    }

                    @Override
                    public void windowActivated(WindowEvent e) {
                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {
                    }
                });
            }
        };
        SwingUtilities.invokeLater(() -> {
            f.setVisible(true);
        });
    }

    public static void setMainContentPane(JPanel j) {
        f.setContentPane(j);
        f.pack();
    }

    public static Question[] getQuestions() {
        // randomly choose 10 questions out of the question bank
        Question[] q = new Question[10];
        int[] qi = new int[10];
        for (int i = 0; i < 10; i++) {
            qi[i] = 999999999;
        }
        for (int i = 0; i < 10; i++) {
            qi[i] = generateNotContaining(qi, questions.length);
        }
        for (int i = 0; i < 10; i++) {
            q[i] = questions[qi[i]];
        }
        return q;
    }

    public static int generateNotContaining(int arr[], int max) {
        int n = 0;
        do {
            n = (int) (Math.random() * (max));
        } while (contains(arr, n));
        return n;
    }

    private static boolean contains(int arr[], int e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return the topics
     */
    public static String[] getTopics() {
        return topics;
    }

    /**
     * @param aTopics the topics to set
     */
    private static void setTopics(String[] aTopics) {
        topics = aTopics;
    }

    /**
     * @return the texts
     */
    public static String[] getTexts() {
        return texts;
    }

    /**
     * @param aTexts the texts to set
     */
    private static void setTexts(String[] aTexts) {
        texts = aTexts;
    }
    
    public static void setResizable(boolean b) {
        f.setResizable(b);
    }

    /**
     * @return the mac
     */
    public static boolean isMac() {
        return mac;
    }

    /**
     * @param aMac the mac to set
     */
    public static void setMac(boolean aMac) {
        mac = aMac;
    }
}
