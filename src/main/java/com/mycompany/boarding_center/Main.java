
package com.mycompany.boarding_center;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new design().setVisible(true);
        });
    }
}