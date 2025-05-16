package Final_Lab_Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Final_Lab_Task_01 implements ActionListener {

    JButton nextBut = new JButton("NEXT");
    JButton backBut = new JButton("BACK");
    JLabel label = new JLabel("1");
    int number = 1; // global counter variable

  // Constructor:
    public Final_Lab_Task_01() {
      
        nextBut.addActionListener(this);
        backBut.addActionListener(this);

        // Creating JFrame and its settings:
        JFrame frame = new JFrame("Counter_App_Final_Lab_Task");
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().setBackground(Color.PINK);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Add components
        frame.add(nextBut);
        frame.add(backBut);
        frame.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Final_Lab_Task_01();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nextBut) {
            number++;
        } else if (e.getSource() == backBut) {
            if (number > 1) {
                number--;
            } else {
                JOptionPane.showMessageDialog(null, "Number cannot go below 1");
            }
        }

      
        label.setText(String.valueOf(number)); // visible number next and back in the JLabel
        System.out.println(number); // also visible in the output screen
    }
}
