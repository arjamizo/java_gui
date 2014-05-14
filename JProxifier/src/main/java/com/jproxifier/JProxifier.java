/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jproxifier;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;

/**
 *
 * @author azochniak
 */
public class JProxifier {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Template: sout[tab]
            System.out.println("We are loading main JFrame using this wrapper because if there are any problems with dependencies, this class will be executed and will throw NoClassDefExcaption, in consequence at least error message will be shown.");
            MainWindow window = new MainWindow();
        } catch  (Throwable ex) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos);
            ps.println("Error: "+ ex + " \ncause for this ex: " + ex.getCause() + " \nCWD: "+System.getProperty("user.dir"));
            ps.println();
            ex.printStackTrace(ps);
            JOptionPane.showMessageDialog(null, baos.toString());
        }
    }
    
}
