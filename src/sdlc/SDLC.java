/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdlc;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author frche1699
 */
public class SDLC {
    private static JFrame f;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        // show the JFrame
        f = new JFrame("SDLC") {
            {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Windows".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
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

}
