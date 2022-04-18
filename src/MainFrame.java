public class MainFrame {
    Database db = null;
    LoginFrame lf = null;

    public static void main(String[] args) {
        MainFrame m = new MainFrame();
        m.db = new Database();
        m.lf = new LoginFrame(m);
    }
}