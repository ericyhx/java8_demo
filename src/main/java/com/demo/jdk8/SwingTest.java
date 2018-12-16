package com.demo.jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {
    public static void main(String[] args) {
        JFrame jFrame=new JFrame("My Jframe");
        JButton button=new JButton("My Jbutton");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("button pressed");
            }
        });
        button.addActionListener(event-> System.out.println("button pressed"));
        jFrame.add(button);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
