import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class OrderFrame2 extends JPanel {
    MenuButton MBtn[] = new MenuButton[16];
    String menu[] = {
            "아메리카노","ICE아메리카노","카페라떼","ICE카페라떼",
            "카페모카","카푸치노","바닐라라떼","ICE바닐라라떼",
            "녹차라떼","아이스티","자몽에이드","청포도에이드",
            "딸기스무디","블루베리스무디","레몬티","유자차"};
    int price[] = {
            1500,1800,2500,2500,
            3000,3000,3500,3500,
            3500,2500,3500,3500,
            4000,4000,3000,3000};
    JTextField tf = new JTextField(30);
    JButton SBtn[] = new JButton[4];
    String Str[] = {"쿠폰","선택취소","전체취소","결제"};
    String ColName[] = {"메뉴","수량","가격"};
    String Data[][] ;
    int count = 0;
    DefaultTableModel model = new DefaultTableModel(Data,ColName);
    JTable table = new JTable(model);

    class Screen extends JPanel{
        Screen(){
            setBackground(Color.WHITE);
            DefaultTableModel m = (DefaultTableModel)table.getModel();
            table.setRowHeight(30);
            table.getTableHeader().setFont(new Font("맑은고딕", Font.BOLD, 15));
            add(new JScrollPane(table));
        }
    }

    class MenuBtn extends JPanel{
        MenuBtn(){
            setLayout(new GridLayout(6,3,3,3));
            setBackground(Color.WHITE);
            for(int i=0;i<MBtn.length;i++) {
                MBtn[i]= new MenuButton(menu[i]);
                MBtn[i].setPrice(price[i]);
                add(MBtn[i]);
            }
        }
    }

    class MenuButton extends JButton{
        private int price;

        public MenuButton(String a){
            this.setText(a);
        }

        public void setPrice(int price){
            this.price=price;
        }
        public int getPrice(){
            return this.price;
        }

    }

    class StrBtn extends JPanel{
        StrBtn(){
            setBackground(Color.WHITE);
            setLayout(new GridLayout(1,4,3,3));

            for(int i=0;i<Str.length;i++) {
                SBtn[i]= new JButton(Str[i]);
                add(SBtn[i]);
            }
        }
    }

    public OrderFrame2() {
        setLayout(null);
        setBackground(Color.WHITE);
        MenuBtn mbtn = new MenuBtn();
        StrBtn sbtn = new StrBtn();
        Screen sc = new Screen();

        //금액란
        tf.setSize(450, 70);
        tf.setLocation(50, 480);
        add(tf);

        sc.setSize(500, 500);
        sc.setLocation(25, 20);
        add(sc);

        mbtn.setSize(400, 430);
        mbtn.setLocation(530, 23);
        add(mbtn);

        sbtn.setSize(400, 70);
        sbtn.setLocation(530, 480);
        add(sbtn);

        //메뉴버튼
        for(int i=0; i<MBtn.length; i++) {
            final int index = i;
            MBtn[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rowCont = table.getRowCount();
                    int flag =0;
                    MenuButton MBtn = (MenuButton) e.getSource();
                    DefaultTableModel m = (DefaultTableModel)table.getModel();
                    for(int i=0;i<rowCont;i++) {
                        if(table.getValueAt(i, 0).equals(MBtn.getText())) {
                            flag = 1;
                            table.setValueAt((int)table.getValueAt(i,1)+1,i,1);
                            table.setValueAt((int)table.getValueAt(i,2)+MBtn.getPrice(),i,2);
                            break;
                        }
                    }
                    if(flag==0) {
                        m.addRow(new Object[]{menu[index], count + 1, price[index]});
                    }
                }
            });
        }

        //쿠폰
        SBtn[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton MBtn = (JButton)e.getSource();
                table.setValueAt(0, table.getSelectedRow(), 2);
            }
        });

        //선택취소
        SBtn[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton MBtn = (JButton)e.getSource();
                DefaultTableModel m = (DefaultTableModel)table.getModel();

                m.removeRow(table.getSelectedRow());
            }
        });


        //전체취소
        SBtn[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton MBtn = (JButton)e.getSource();
                DefaultTableModel m = (DefaultTableModel)table.getModel();

                m.setRowCount(0);
                tf.setText(String.valueOf(""));
            }
        });

        //결제버튼
        SBtn[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton MBtn = (JButton)e.getSource();
                int rowCont = table.getRowCount();
                int sum =0;
                for(int i=0;i<rowCont;i++) {
                    sum += (int)table.getValueAt(i, 2);
                }
                tf.setText(String.valueOf(" 총 금액 : " + sum + "원"));
                tf.setHorizontalAlignment(JLabel.CENTER);
                tf.setFont(new Font("GOTHIC", Font.BOLD, 25));
            }
        });
    }
}