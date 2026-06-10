public class employee {
    private int Id;
    private   String Name;
    private  int Age;
    private  String Branch;
    private  double Salary;

    public employee( String Name, int Age, String Branch ,double Salary){
        this.Name=Name;
        this.Age=Age;
        this.Branch=Branch;
        this.Salary=Salary;
    }
    public employee( int Id,String Name, int Age, String Branch ,double Salary){
        this.Id=Id;
        this.Name=Name;
        this.Age=Age;
        this.Branch=Branch;
        this.Salary=Salary;
    }
    //getters
    public String getName(){return Name;}
    public int getId(){return Id;}
    public int getAge(){return Age;}
    public String getBranch(){return Branch;}
    public double getSalary(){return Salary;}

    //setters
    public void setName(String Name){ this.Name=Name;}
    public void setBranch(String Branch) { this.Branch = Branch; }
    public void setAge(int Age) { this.Age = Age; }
    public void setSalary(double Salary) { this.Salary = Salary; }


}
