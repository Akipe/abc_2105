package spring.myapp;

import javax.swing.*;

public class App
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Ma super APP");
        frame.setSize(600, 400);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.setContentPane(panel);

        JButton button = new JButton("Mon buton");
        panel.add(button);
    }
}