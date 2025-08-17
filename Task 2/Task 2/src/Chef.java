public class Chef extends Employee implements Eatable {

    public Chef(String name, int age, double salary) {
        super(name, age, salary, "Chef");
    }
    @Override
    public void eat() {
        System.out.println("Chef "+ getName() + " is tasting the food.");

    }

    @Override
    public void work(){
        System.out.println("Chef "+ getName() + " is preparing dishes");
    }
}
