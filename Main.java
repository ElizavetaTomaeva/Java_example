package com.company;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame ("Window");
        frame.setSize (500, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        frame.setVisible(true);

        final JLabel label1 = new JLabel ();
        label1.setSize(100,15);
        label1.setLocation(30, 85);

        final JProgressBar progress1 = new JProgressBar();
        progress1.setSize(150,30);
        progress1.setLocation(30,40);
        progress1.setStringPainted(true);
        progress1.setMinimum(0);
        progress1.setMaximum(99);

        final JLabel label2 = new JLabel ();
        label2.setSize(100,15);
        label2.setLocation(300, 85);

        final JTextArea text1 = new JTextArea();
        text1.setSize(10, 10);
        text1.setLayout(new FlowLayout(FlowLayout.RIGHT, 3,3));
        text1.setBorder (new LineBorder (Color.BLACK));



//        300,440

        final JProgressBar progress2 = new JProgressBar();
        progress2.setSize(150,30);
        progress2.setLocation(300,40);
        progress2.setStringPainted(true);
        progress2.setMinimum(0);
        progress2.setMaximum(99);


        frame.add (progress1);
        frame.add (progress2);
        frame.add (label1);
        frame.add (label2);
        frame.add (text1);


        class Hello1 implements Runnable {


            public void run ()
            {for (int i = 0; i < 100; ++i) {

                System.out.println("1");
                try{
                    Thread.sleep(100);}
                catch (Exception e) {}


                progress1.setValue(i);
                label1.setText ("Loading...");



            }
                label1.setText ("Done!");

            } }

        class Hello2 implements Runnable {


            public void run ()
            {for (int i = 0; i < 100; ++i) {

                System.out.println("2");
                try{
                    Thread.sleep(70);}
                catch (Exception e) {}

                progress2.setValue(i);
                label2.setText ("Loading...");



            }
                label2.setText ("Done!");

            } }

        Thread t1 = new Thread (new Hello1());
        Thread t2 = new Thread (new Hello2());


        t1.start();
        t2.start();




    }
}
