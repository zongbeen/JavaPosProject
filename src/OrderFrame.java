import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class OrderFrame extends JFrame {
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");

    OrderFrame() {
        next();
        setTitle("OrderFrame");
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        button1.setBounds(50,300,200,150);
        button2.setBounds(287,300,200,150);
        button3.setBounds(517,300,200,150);
        button4.setBounds(747,300,200,150);
        button5.setBounds(50,500,200,150);
        button6.setBounds(287,500,200,150);
        button7.setBounds(517,500,200,150);
        button8.setBounds(747,500,200,150);
        getContentPane().add(button1);
        getContentPane().add(button2);
        getContentPane().add(button3);
        getContentPane().add(button4);
        getContentPane().add(button5);
        getContentPane().add(button6);
        getContentPane().add(button7);
        getContentPane().add(button8);
        setVisible(true);
    }
    public void next(){
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new OrderFrame2();
            }
        });
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new OrderFrame2();
            }
        });
        button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new OrderFrame2();
            }
        });
        button4.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new OrderFrame2();
            }
        });
        button5.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new OrderFrame2();
            }
        });
        button6.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new OrderFrame2();
            }
        });
        button7.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new OrderFrame2();
            }
        });
        button8.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new OrderFrame2();
            }
        });
    }
}