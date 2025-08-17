import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("-----------ArrayList<E>-----------");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Ahmed");
        arrayList.add("John");
        arrayList.add("Omar");
        arrayList.add("Khaled");
        arrayList.add("Mariam");
        System.out.println(arrayList);
        arrayList.remove("Ahmed");
        System.out.println(arrayList);
        System.out.println(arrayList.get(2));

        System.out.println("-----------------------------------");
        System.out.println("----------------LinkedList<E>----------------");
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Ahmed");
        linkedList.add("John");
        linkedList.add("Omar");
        linkedList.add("Khaled");
        linkedList.add("Mariam");
        System.out.println(linkedList);
        linkedList.remove("Omar");
        System.out.println(linkedList);
        System.out.println(linkedList.get(2));
        System.out.println("-----------------------------------");

        System.out.println("----------------Stack<Integer>----------------");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        System.out.println(stack.peek());

        System.out.println("--------------------------------------------");
        System.out.println("----------------Queue<Integer>----------------");
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        System.out.println(queue);
        queue.poll();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println("--------------------------------------------");

        System.out.println("----------------HashMap----------------");
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 5);
        map.put("Banana", 4);
        map.put("Orange", 3);
        map.put("Pear", 2);
        System.out.println(map);
        System.out.println("Apples are "+map.get("Apple"));
        map.remove("Apple");
        System.out.println(map.entrySet());
        System.out.println(map);
        System.out.println("--------------------------------------------");

        System.out.println("----------------HashTable----------------");

        Map<String, Integer> hashTable = new Hashtable<>();
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter the number of elements in the HashTable: ");
//        int size = scanner.nextInt();
//        for (int i = 0; i < size; i++) {
//            System.out.println("Enter the key of element " + (i + 1) + ": ");
//            String key = scanner.next();
//            System.out.println("Enter the value of element " + (i + 1) + ": ");
//            int value = scanner.nextInt();
//            if(!hashTable.containsKey(key)) {
//
//                hashTable.put(key, value);
//            }
//            else {
//                int num=hashTable.get(key);
//                hashTable.put(key, num+value);
//            }
//
//        };
//        System.out.println(hashTable);

        System.out.println("Calculator ");

        try {
            System.out.println("Enter the first number: ");
            int num1=scanner.nextInt();
            System.out.println("Enter the second number: ");
            int num2=scanner.nextInt();
            double result=num1/num2;
            System.out.println(result);
        }catch (InputMismatchException e) {
            System.err.println("invalid input");
        }catch (ArithmeticException e){
            System.err.println("Can't divide by zero");
        }finally {
            System.out.println("-------------Thanks for usic calc--------------");
        }





    }
}