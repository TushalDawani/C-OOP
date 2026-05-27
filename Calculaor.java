import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    JTextField display;
    double num1, num2, result;
    String operator = "";

    String[] buttons = {
        "7","8","9","/",
        "4","5","6","*",
        "1","2","3","-",
        "C","0","=","+"
    };

    Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setPreferredSize(new Dimension(300, 60));
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.matches("[0-9]")) {
            display.setText(display.getText() + cmd);

        } else if (cmd.equals("C")) {
            display.setText("");
            num1 = num2 = result = 0;
            operator = "";

        } else if (cmd.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(display.getText());
            operator = cmd;
            display.setText("");

        } else if (cmd.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> result = num2 != 0 ? num1 / num2 : 0;
            }
            display.setText(result % 1 == 0
                ? String.valueOf((int) result)
                : String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
