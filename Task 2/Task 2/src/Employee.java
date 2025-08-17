public abstract class Employee extends Person implements Eatable {
    private double salary;
    private String role;
    Employee(String name, int age, double salary, String role) {
        super(name, age);
        this.salary = salary;
        this.role = role;
    }
    public double getSalary() {
        return salary;
    }
    public String getRole() {
        return role;
    }
    abstract public void work();
}
