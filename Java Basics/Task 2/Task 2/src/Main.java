import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<Employee>();
//        employees.add(new Employee("John",21,3000,"Engineer"));
//        employees.add(new Employee("Moahmed",21,3000,"Engineer"));
        employees.add(new Chef("Ahmed",21,3000));
        employees.add(new Chef("Karim",21,3000));
        employees.add(new Waiter("Omar",21,3000));
        employees.add(new Waiter("Salma",21,3000));
        for(Employee e:employees){
            e.introduce();
            e.work();
            e.eat();
            System.out.println("----------------------------");
        }


        //---------------------Sheet Asyout-------------------------//

        //-----------------------------------------------O----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        int num1=scanner.nextInt();
//        char op=scanner.next().charAt(0);
//        int num2=scanner.nextInt();
//        if(op=='+'){
//            System.out.println(num1+num2);
//        }else if(op=='-'){
//            System.out.println(num1-num2);
//        } else if(op=='*'){
//            System.out.println(num1*num2);
//        } else if(op=='/'){
//            if(num2!=0){
//                System.out.println(num1/num2);
//            }else{
//                System.out.println("Cannot divide by zero");
//            }
//        }



        //-----------------------------------------------P----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        char number=scanner.next().charAt(0);
//        int num=(int)number;
//        if(num%2==0){
//            System.out.println("Even");
//        } else if (num%2!=0) {
//            System.out.println("Odd");
//        }



    }
}
