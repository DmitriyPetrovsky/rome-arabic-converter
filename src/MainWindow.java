import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainWindow extends JFrame{
    private String iconPath;
   // private ImageIcon iconFile;
    private JPanel buttonsPanel, labelPanel, textPanel, labelPanel2;
    private JButton start, stop, exit;
    private JLabel label, label2;
    private GridLayout gridLayout;
    private JTextField smallField;
    private JRadioButton arabToRome, romeToArab;

    int testNum = 0;
    String testString = "";
    private final int width, heihgt;

    public MainWindow(String winTitle, String path, int w, int h){
        super(winTitle);
        iconPath = path;
        width = w;
        heihgt = h;
        //iconFile = new ImageIcon(MainWindow.class.getResource(path));
       // setIconImage(iconFile.getImage());
        setSize(width, heihgt);
        buttonsPanel = new JPanel();
        labelPanel2 = new JPanel();
        labelPanel = new JPanel();
        gridLayout = new GridLayout(1,8,50,30);

        textPanel = new JPanel();

        arabToRome = new JRadioButton("Арабские в римские");
        romeToArab = new JRadioButton("Римские в арабские");
        ButtonGroup group = new ButtonGroup();
        group.add(arabToRome);
        group.add(romeToArab);

        start = new JButton("Перевести");
        stop = new JButton("Сброс");
        exit = new JButton("Выход");
        label = new JLabel("Введите число арабскими цифрамии и нажмите \"Перевести\"");
        label2 = new JLabel("");
        smallField = new JTextField(10);
        smallField.setToolTipText("2015");
        ActionListener myButtonsListener = new ButtonsListener();
        start.setActionCommand("Запустить");
        stop.setActionCommand("Остановить");
        exit.setActionCommand("Выход");

        start.addActionListener(myButtonsListener);
        stop.addActionListener(myButtonsListener);
        exit.addActionListener(myButtonsListener);
        arabToRome.addActionListener(myButtonsListener);
        romeToArab.addActionListener(myButtonsListener);

        buttonsPanel.add(start);
        buttonsPanel.add(stop);
        buttonsPanel.add(exit);
        labelPanel.add(label);
        labelPanel.add(label2);
        textPanel.add(smallField);
        labelPanel2.add(arabToRome);
        labelPanel2.add(romeToArab);
        getContentPane().add(BorderLayout.SOUTH, buttonsPanel);
        getContentPane().add(BorderLayout.PAGE_START, labelPanel);
        getContentPane().add(BorderLayout.WEST, labelPanel2);
        getContentPane().add(BorderLayout.CENTER, textPanel);
        arabToRome.setSelected(true);
    }
    private class ButtonsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            boolean rome = true;
            String command = e.getActionCommand();
            //JRadioButton rbutton = (JRadioButton) e.getSource();
            if (command.equals("Остановить")) {
                if (arabToRome.isSelected()) {
                    label.setText("Введите число арабскими цифрамии и нажмите \"Перевести\"");
                } else if (romeToArab.isSelected()) {
                    label.setText("Введите римские цифры и нажмите \"Перевести\"");
                }
                smallField.setText("");
                smallField.grabFocus();
            } else if (command.equals("Запустить")){
                if (arabToRome.isSelected()) {
                    try {
                        testNum = Integer.parseInt(smallField.getText());
                        label.setText("Число " + testNum + " римскими цифрами: " + RomeCalc.Calculate(testNum));
                    }
                    catch (Exception exp) {
                        label.setText("Неверный формат ввода, попробуйте снова.");
                    }
                } else if (romeToArab.isSelected()) {
                    testString = smallField.getText();
                    if (ArabicCalc.Calculate(testString) != 0) {
                        label.setText("Римские цифры " + testString + " образуют число: " + ArabicCalc.Calculate(testString));
                    }
                    else {
                        label.setText("Неверный формат ввода, попробуйте снова.");
                    }
                }

            } else if (command.equals("Выход")) {
                System.exit(0);
            } //
            if (romeToArab.hasFocus()) {
                label.setText("Введите римские цифры и нажмите \"Перевести\"");
                rome = false;
            } else if (arabToRome.hasFocus()) {
                label.setText("Введите число арабскими цифрамии и нажмите \"Перевести\"");
                rome = true;
            }
        }
    }
}
