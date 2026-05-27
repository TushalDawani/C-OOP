import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {

    JLabel label1, label2, label3;
    JTextField amountField, resultField;
    JComboBox<String> fromBox, toBox;
    JButton convertBtn;

    String[] currencies = {"USD", "EUR", "GBP", "PKR", "INR", "JPY", "AED"};
    double[] rates      = { 1.0,  0.92,  0.79, 278.5,  83.1, 149.5,  3.67};

    CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(400, 280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);

        label1 = new JLabel("Amount:");
        label1.setBounds(30, 30, 80, 25);
        add(label1);

        amountField = new JTextField();
        amountField.setBounds(120, 30, 220, 25);
        add(amountField);

        label2 = new JLabel("From:");
        label2.setBounds(30, 75, 80, 25);
        add(label2);

        fromBox = new JComboBox<>(currencies);
        fromBox.setBounds(120, 75, 220, 25);
        add(fromBox);

        label3 = new JLabel("To:");
        label3.setBounds(30, 120, 80, 25);
        add(label3);

        toBox = new JComboBox<>(currencies);
        toBox.setBounds(120, 120, 220, 25);
        toBox.setSelectedIndex(3);
        add(toBox);

        convertBtn = new JButton("Convert");
        convertBtn.setBounds(120, 165, 100, 30);
        convertBtn.addActionListener(this);
        add(convertBtn);

        resultField = new JTextField();
        resultField.setBounds(120, 210, 220, 25);
        resultField.setEditable(false);
        add(resultField);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            int from = fromBox.getSelectedIndex();
            int to   = toBox.getSelectedIndex();
            double result = (amount / rates[from]) * rates[to];
            resultField.setText(String.format("%.2f %s", result, currencies[to]));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input!");
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
