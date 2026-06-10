import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class employee_dao {
    public void add_employee(employee emp) {
        String SQL = "INSERT INTO employees(Name,Age,Branch,Salary) VALUES(?,?,?,?)";
        try {
            Connection con = db_connection.getConnectio();

            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1,emp.getName());
            ps.setString(3,emp.getBranch());
            ps.setInt(2,emp.getAge());
            ps.setDouble(4,emp.getSalary());

            int rows= ps.executeUpdate();
            if(rows>0){
                System.out.println("employee added successfully :)");
            }
            else{
                System.out.println("addition failed lol :(");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void view_employee() {

        String SQL = "SELECT * FROM employees";

        try {
            Connection con = db_connection.getConnectio();

            PreparedStatement ps = con.prepareStatement(SQL);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("Id");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String branch = rs.getString("Branch");
                double salary = rs.getDouble("Salary");

                System.out.println(id + " | " + name + " | " + age + " | " + branch + " | " + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete_employee(int id) {

        String SQL = "DELETE FROM employees WHERE Id=?";

        try {
            Connection con = db_connection.getConnectio();

            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("employee deleted successfully");
            } else {
                System.out.println("no employee found with that id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void update_employee(employee emp) {

        String SQL = "UPDATE employees SET Name=?, Age=?, Branch=?, Salary=? WHERE Id=?";

        try {
            Connection con = db_connection.getConnectio();

            PreparedStatement ps = con.prepareStatement(SQL);

            ps.setString(1, emp.getName());
            ps.setInt(2, emp.getAge());
            ps.setString(3, emp.getBranch());
            ps.setDouble(4, emp.getSalary());
            ps.setInt(5, emp.getId());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("employee updated successfully");
            } else {
                System.out.println("update failed, id not found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}










