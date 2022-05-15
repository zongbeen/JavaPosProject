import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.util.Arrays;

public class OrderFrame2 extends JFrame {

    JButton[] menuBtn = new JButton[16];
    String[] menu = {
            "아메리카노","카페라떼","카페모카","카푸치노",
            "바닐라라떼","딸기라떼","초코라떼","녹차라떼",
            "아이스티","레몬에이드","자몽에이드","청포도에이드",
            "딸기스무디","블루베리스무디","바나나스무디","초코스무디"};
    int[] price = {
            1500,2000,2500,2500,
            3000,3000,3000,3000,
            2000,2500,2500,2500,
            4000,4000,4000,4000};

    JButton orderBtn = new JButton("주문");
    JButton backBtn = new JButton("뒤로가기");
    JTextField totalPrice = new JTextField(30);


    String columnNames[] = {"No.", "품명", "수량", "가격"};
    String check[] = {};
    Object rowdata[][] = {
            {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""},
            {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""},
            {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""},
            {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""},
            {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""},
            {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}, {"", "", "", ""}
    };

    JTable table = new JTable(rowdata, columnNames);

    JScrollPane scrollPane = new JScrollPane(table);


    public OrderFrame2() {
        choice();
        setTitle("Menu");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        scrollPane.setLocation(10, 10);
        scrollPane.setSize(500, 500);

        for(int i=0; i<menuBtn.length; i++) {
            menuBtn[i]= new JButton(menu[i]);
            menuBtn[0].setBounds(525, 50, 100, 80);
            menuBtn[1].setBounds(635, 50, 100, 80);
            menuBtn[2].setBounds(745, 50, 100, 80);
            menuBtn[3].setBounds(855, 50, 100, 80);
            menuBtn[4].setBounds(525, 140, 100, 80);
            menuBtn[5].setBounds(635, 140, 100, 80);
            menuBtn[6].setBounds(745, 140, 100, 80);
            menuBtn[7].setBounds(855, 140, 100, 80);
            add(menuBtn[i]);
        }

        orderBtn.setBounds(525,700,100,80);
        backBtn.setBounds(855, 700, 100, 80);
        totalPrice.setBounds(10, 700, 450, 70);
        add(totalPrice);

        add(orderBtn);
        add(backBtn);
        add(scrollPane);
        setVisible(true);
    }

    public void choice() {
        final int MAX = 100;
        for(int i=0; i<menuBtn.length; i++) {
            menuBtn[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    for (int i = 0; i <= MAX; i++) {
                        if (table.getValueAt(i, 0) == "") {
                            table.setValueAt(i + 1, i, 0);
                            table.setValueAt(menuBtn[i].getText(), i, 1);
                            table.setValueAt(1, i, 2);
                            table.setValueAt(2000, i, 3);
                            break;
                        } else if (table.getValueAt(i, 1) == menuBtn[i].getText()) {
                            int count = (int) table.getValueAt(i, 2);
                            table.setValueAt(count + 1, i, 2);
                            int price = (int) table.getValueAt(i,3);
                            table.setValueAt(price + 2000, i, 3);
                            break;
                        }
                    }
                }
            });
        }

        /*orderBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton orderBtn = (JButton)e.getSource();
                int rowCont = table.getRowCount();
                int sum =0;
                for(int i=0;i<rowCont;i++) {
                    sum += (int)table.getValueAt(i, 2);
                }
                totalPrice.setText(String.valueOf(" 총 금액 : "+sum));
                totalPrice.setFont(new Font("Gothic", Font.BOLD, 40));
            }
        });*/

        /*orderBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new OrderFrame();
            }
        });*/

        backBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setVisible(false);
                new OrderFrame();
            }
        });

    }
}