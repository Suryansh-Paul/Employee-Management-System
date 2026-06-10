import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        employee_dao dao = new employee_dao();

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Delete Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Branch: ");
                    String branch = sc.next();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    employee emp = new employee(name, age, branch, salary);
                    dao.add_employee(emp);
                    break;

                case 2:
                    dao.view_employee();
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    int deleteId = sc.nextInt();
                    dao.delete_employee(deleteId);
                    break;

                case 4:
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();

                    System.out.print("Enter New Name: ");
                    String newName = sc.next();

                    System.out.print("Enter New Age: ");
                    int newAge = sc.nextInt();

                    System.out.print("Enter New Branch: ");
                    String newBranch = sc.next();

                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();

                    employee updatedEmp = new employee(id, newName, newAge, newBranch, newSalary);
                    dao.update_employee(updatedEmp);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}