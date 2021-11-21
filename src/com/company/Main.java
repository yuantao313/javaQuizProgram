package com.company;
import com.company.mainWindow;
public class Main {
    public static void main(String[] args) {
        //thread
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                mainWindow a = new mainWindow();
            }
        });
    }
}
