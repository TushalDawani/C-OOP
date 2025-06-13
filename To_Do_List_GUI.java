package Java_Gui_Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class To_Do_List_GUI extends JFrame implements ActionListener {

    JButton addButton, removeButton, deleteButton;
    JTextField taskField;
    DefaultListModel<String> taskListModel;
    JList<String> taskList;

    public To_Do_List_GUI() {
        setSize(520, 650);
        setTitle("To Do List Application");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Task input field
        taskField = new JTextField();
        taskField.setBounds(20, 20, 350, 30);
        add(taskField);

        // Add button
        addButton = new JButton("Add Task");
        addButton.setBounds(380, 20, 100, 30);
        addButton.addActionListener(this);
        add(addButton);

        // Task list and scroll pane
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(20, 60, 460, 460);
        add(scrollPane);

        // Remove All button
        removeButton = new JButton("Remove All");
        removeButton.setBounds(100, 530, 120, 30);
        removeButton.addActionListener(this);
        add(removeButton);

        // Delete Selected button
        deleteButton = new JButton("Delete Selected");
        deleteButton.setBounds(250, 530, 150, 30);
        deleteButton.addActionListener(this);
        add(deleteButton);

        // Apply the Light Blue Theme
        applyLightBlueTheme();

        setVisible(true);
    }

    private void applyLightBlueTheme() {

        Color bgColor = new Color(240, 255, 250);
        Color fgColor = new Color(33, 37, 41);
        Color buttonColor = new Color(0, 168, 150);
        Color selectionColor = new Color(77, 182, 172);



        Font font = new Font("Segoe UI", Font.PLAIN, 14);

        getContentPane().setBackground(bgColor);

        // Task input field styles
        taskField.setBackground(Color.WHITE);
        taskField.setForeground(fgColor);
        taskField.setFont(font);
        taskField.setBorder(BorderFactory.createLineBorder(buttonColor));

        // Task list styles
        taskList.setBackground(Color.WHITE);
        taskList.setForeground(fgColor);
        taskList.setFont(font);
        taskList.setSelectionBackground(buttonColor);
        taskList.setSelectionForeground(Color.WHITE);

        // Buttons styles
        JButton[] buttons = {addButton, removeButton, deleteButton};
        for (JButton button : buttons) {
            button.setBackground(buttonColor);
            button.setForeground(Color.WHITE);
            button.setFont(font);
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            }

        } else if (e.getSource() == removeButton) {
            taskListModel.clear();

        } else if (e.getSource() == deleteButton) {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        }
    }

    public static void main(String[] args) {
        new To_Do_List_GUI();
    }
}
