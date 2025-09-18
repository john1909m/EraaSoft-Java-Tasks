public class Person {
    private String name;
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void introduce(){
        System.out.println("Name is "+name);
        System.out.println("Age is "+age);
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }


}
