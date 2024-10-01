import javax.swing.JFrame;


public class Main {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow("Моя программа", "../Images/abc_2900814.png", 500, 150);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setVisible(true);

    }
}