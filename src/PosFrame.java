import javax.swing.JFrame;

public class PosFrame extends JFrame {
    public PosFrame() {
        setTitle("Menu");
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new OrderFrame2());
        getContentPane().setLayout(null);
        setVisible(true);
    }
}