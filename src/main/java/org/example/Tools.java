package org.example;

import javax.swing.*;
import java.awt.*;

public class Tools {

    public static void voltarInicioPara(Container contentPane, JPanel panel){
        contentPane.removeAll();
        contentPane.add(panel);
        contentPane.revalidate();
        contentPane.repaint();
    }

    public  static void getTela(Container container,JPanel panel){
        panel.setVisible(true);
        container.removeAll();
        container.add(panel);
        container.revalidate();
        container.repaint();
    }

    public static  void setarFrame(JFrame frame,JPanel Home){
        frame.add(Home);
        frame.setSize(400,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
