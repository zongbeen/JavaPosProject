import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    JPanel MainPanel = new JPanel();
    JPanel InfoPanel = new JPanel();
    JPanel LoginPanel = new JPanel();
    JPanel LastPanel = new JPanel();

    JLabel idLabel = new JLabel("아이디");
    JLabel pwLabel = new JLabel("비밀번호");

    JTextField id = new JTextField();
    JPasswordField pw = new JPasswordField();

    JButton LoginBtn = new JButton("로그인");
    JButton JoinBtn = new JButton("회원가입");
    JButton ExitBtn = new JButton("종료");

    MainFrame m1 = null;

    LoginFrame(MainFrame m2){
        int x=85, y=70;
        m1 = m2;

        setTitle("로그인");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idLabel.setPreferredSize(new Dimension(50, 30));
        pwLabel.setPreferredSize(new Dimension(50, 30));

        id.setPreferredSize(new Dimension(170, 30));
        pw.setPreferredSize(new Dimension(170, 30));
        pw.addKeyListener(new LoginListener());

        LoginBtn.setPreferredSize(new Dimension(75, 68));
        JoinBtn.setPreferredSize(new Dimension(135, 30));
        ExitBtn.setPreferredSize(new Dimension(135, 30));

        setContentPane(MainPanel);
        MainPanel.setLayout(null);
        MainPanel.setBackground(Color.WHITE);

        InfoPanel.setBounds(x,y,250,70);
        LoginPanel.setBounds(x+260,y,75,70);
        LastPanel.setBounds(x+30,y+75,280,40);
        InfoPanel.setBackground(Color.WHITE);
        LoginPanel.setBackground(Color.WHITE);
        LastPanel.setBackground(Color.WHITE);


        InfoPanel.add(idLabel); InfoPanel.add(id);
        InfoPanel.add(pwLabel); InfoPanel.add(pw);
        LoginPanel.add(LoginBtn);
        LastPanel.add(ExitBtn); LastPanel.add(JoinBtn);

        MainPanel.add(InfoPanel);
        MainPanel.add(LoginPanel);
        MainPanel.add(LastPanel);

        /* Button 이벤트 리스너 추가 */
        ButtonListener bl = new ButtonListener();

        LoginBtn.addActionListener(bl);
        ExitBtn.addActionListener(bl);
        JoinBtn.addActionListener(bl);

        setVisible(true);
        setResizable(false);

        ExitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(1);
            }
        });

    }
    class LoginListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_ENTER)
            new PressLogin().PressLogins();
            }
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new PressLogin().PressLogins();
        }
    }

    class PressLogin {
        public void PressLogins() {
            String uid = id.getText();
            String upass = "";
            for(int i=0; i<pw.getPassword().length; i++) {
                upass = upass + pw.getPassword()[i];
            }

            if(uid.equals("") || upass.equals("")) {
                JOptionPane.showMessageDialog(null, "아이디와 비밀번호 모두 입력해주세요",
                        "로그인 실패", JOptionPane.ERROR_MESSAGE);
            }

            else if(uid != null && upass != null) {
                if(m1.db.logincheck(uid, upass)) {	//이 부분이 데이터베이스에 접속해 로그인 정보를 확인하는 부분이다.
                    JOptionPane.showMessageDialog(null, "로그인에 성공하였습니다");
                    setVisible(false);
                    new OrderFrame();

                }
                else {
                    JOptionPane.showMessageDialog(null, "로그인에 실패하였습니다");
                }
            }
        }

    }
}
