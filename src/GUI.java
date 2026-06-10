import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GUI extends JFrame {

    employee_dao dao = new employee_dao();
    DefaultTableModel model;
    JTable table;

    public GUI() {

        setTitle("Employee Management System");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Background
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10)); // spacing added
        panel.setBackground(new Color(173, 216, 230)); // light blue
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // padding

        // 🔹 NAVBAR (buttons)
        JPanel navBar = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // spacing + center
        navBar.setBackground(Color.WHITE);
        navBar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton addBtn = createButton("Add");
        JButton viewBtn = createButton("View");
        JButton updateBtn = createButton("Update");
        JButton deleteBtn = createButton("Delete");

        navBar.add(addBtn);
        navBar.add(viewBtn);
        navBar.add(updateBtn);
        navBar.add(deleteBtn);

        // 🔹 TABLE
        String[] columns = {"ID", "Name", "Age", "Branch", "Salary"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);

        // table styling
        table.setRowHeight(25);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        table.getTableHeader().setBackground(Color.WHITE);
        table.setGridColor(Color.LIGHT_GRAY);
        table.setSelectionBackground(new Color(200, 200, 255));

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(navBar, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        // 🔹 BUTTON ACTIONS

        // ADD
        addBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
            String branch = JOptionPane.showInputDialog("Enter Branch:");
            double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter Salary:"));

            employee emp = new employee(name, age, branch, salary);
            dao.add_employee(emp);
        });

        // VIEW
        viewBtn.addActionListener(e -> loadTable());

        // DELETE
        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to delete:"));
            dao.delete_employee(id);
            loadTable();
        });

        // UPDATE
        updateBtn.addActionListener(e -> {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Enter ID to update:"));
            String name = JOptionPane.showInputDialog("Enter New Name:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter New Age:"));
            String branch = JOptionPane.showInputDialog("Enter New Branch:");
            double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter New Salary:"));

            employee emp = new employee(id, name, age, branch, salary);
            dao.update_employee(emp);
            loadTable();
        });
    }

    // 🔹 LOAD TABLE DATA FROM DB
    public void loadTable() {

        model.setRowCount(0);

        try {
            Connection con = db_connection.getConnectio(); // fixed typo
            String sql = "SELECT * FROM employees";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("Id"),
                        rs.getString("Name"),
                        rs.getInt("Age"),
                        rs.getString("Branch"),
                        rs.getDouble("Salary")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔹 CLEAN BUTTON (NO SCALE, ONLY HOVER COLOR)
    public JButton createButton(String text) {

        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(Color.WHITE);
        btn.setForeground(Color.BLACK);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setPreferredSize(new Dimension(120, 40));

        btn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));

        btn.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(180, 180, 180)); // soft grey hover
                btn.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                btn.setBackground(Color.WHITE);
                btn.setForeground(Color.BLACK);
            }
        });

        return btn;
    }

    public static void main(String[] args) {
        new GUI().setVisible(true);
    }
}