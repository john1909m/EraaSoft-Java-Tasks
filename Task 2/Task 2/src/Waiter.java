public class Waiter extends Employee implements Eatable {
    public Waiter(String name, int age,double salary) {
        super(name,age,salary,"Waiter");
    }
    @Override
    public void work() {
        System.out.println("Waiter "+ getName() + " is serving customers");
    }
    @Override
    public void eat() {
        System.out.println("Waiter " + getName() + " is having a quick meal break.");
    }
}
