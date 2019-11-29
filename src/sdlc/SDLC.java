/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlc;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
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

        // TODO read study notes
        // show the JFrame
        f = new JFrame("SDLC") {
            {
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.setContentPane(new Welcome());
                this.setPreferredSize(new Dimension(500, 500));
                this.setResizable(false);
                this.pack();
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
}
