package taskmanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class TaskManagerGUI extends JFrame {
    
    private final DefaultListModel<String> taskListModel = new DefaultListModel<>();
    private final JList<String> taskList = new JList<>(taskListModel);
    private final JTextField inputTask = new JTextField();
    private final JLabel titleLabel = new JLabel("TASK MANAGER", SwingConstants.CENTER);

    public TaskManagerGUI() {
    initUI();
    refreshTaskList();
}


    private void initUI() {
        setTitle("Task Manager GUI");
        setSize(500, 400);
        setLocationRelativeTo(null); // posisi di tengah
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Judul
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(titleLabel, BorderLayout.NORTH);

        // Panel Tengah - daftar tugas
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createTitledBorder("Daftar Tugas"));
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        centerPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // Panel Bawah - tombol dan input
        JPanel bottomPanel = new JPanel(new BorderLayout(5, 5));
        bottomPanel.add(inputTask, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton addBtn = new JButton("Tambah");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Hapus");
        JButton clearBtn = new JButton("Kosongkan");

        buttonPanel.add(addBtn);
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(clearBtn);

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);

        // === Aksi Tombol ===
        addBtn.addActionListener((ActionEvent e) -> addTask());
        editBtn.addActionListener((ActionEvent e) -> editTask());
        deleteBtn.addActionListener((ActionEvent e) -> deleteTask());
        clearBtn.addActionListener((ActionEvent e) -> clearTasks());
    }
    
    private void refreshTaskList() {
    taskListModel.clear();
    for (String task : TaskDAO.getAllTasks()) {
        taskListModel.addElement(task);
    }
}


    private void addTask() {
    String task = inputTask.getText().trim();
    if (!task.isEmpty()) {
        TaskDAO.addTask(task);
        refreshTaskList();
        inputTask.setText("");
    } else {
        JOptionPane.showMessageDialog(this, "Masukkan nama tugas!");
    }
}


    private void editTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            String newTask = JOptionPane.showInputDialog(this, "Edit tugas:", taskListModel.get(selectedIndex));
            if (newTask != null && !newTask.trim().isEmpty()) {
                taskListModel.set(selectedIndex, newTask.trim());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih tugas yang ingin diedit!");
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Hapus tugas terpilih?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                taskListModel.remove(selectedIndex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih tugas yang ingin dihapus!");
        }
    }

    private void clearTasks() {
        int confirm = JOptionPane.showConfirmDialog(this, "Hapus semua tugas?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            taskListModel.clear();
        }
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TaskManagerGUI().setVisible(true);
        });
    }
}

