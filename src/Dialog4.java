import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog4 extends JFrame {
    JTextField fld = new JTextField(20);
    JButton btn = new JButton("Натиснути");
    JLabel inputLbl = new JLabel("Введіть текст:");
    JLabel outputLbl = new JLabel(" ");

    Dialog4() {
        super("Слухачі (listeners) полів та кнопок");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
        }
        setSize(400, 150);
        Container c = getContentPane();

        // Створюємо панель для поля вводу
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputLbl, BorderLayout.NORTH);
        inputPanel.add(fld, BorderLayout.CENTER);
        c.add(inputPanel, BorderLayout.CENTER);

        // Створюємо панель для кнопки
        JPanel btnPanel = new JPanel();
        btnPanel.add(btn);
        c.add(btnPanel, BorderLayout.SOUTH);

        // Створюємо панель для поля виводу
        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.add(outputLbl, BorderLayout.NORTH);
        c.add(outputPanel, BorderLayout.SOUTH);

        fld.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                outputLbl.setText("Введений текст: " + fld.getText());
            }
        });

        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                outputLbl.setText("Натиснута кнопка");
            }
        });

        WindowListener wndCloser = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };
        addWindowListener(wndCloser);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Dialog4();
    }
}