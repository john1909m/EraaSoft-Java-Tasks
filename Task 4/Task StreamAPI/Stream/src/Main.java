import java.beans.Introspector;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 5, 3, 7, 2, 10, 5, 8, 9, 1, -3, 4);
        List<String> names = Arrays.asList("Ali", "Mona", "Ahmed", "Sara", "Amr", "Laila", "Kareem", "Nada", "Nour", "Samy", "", null);
        List<Student> students = Arrays.asList(
                new Student("Ali", "IT", 85),
                new Student("Mona", "CS", 92),
                new Student("Ahmed", "IT", 60),
                new Student("Sara", "CS", 70),
                new Student("Omar", "IS", 45),
                new Student("Laila", "IS", 78)
        );
        List<Employee> employees = Arrays.asList(
                new Employee("Ali", 30, "HR", 5000),
                new Employee("Mona", 25, "IT", 7000),
                new Employee("Ahmed", 30, "HR", 5500),
                new Employee("Sara", 27, "IT", 7200),
                new Employee("Omar", 40, "Finance", 8000),
                new Employee("Laila", 35, "Finance", 8200)
        );
        List<List<String>> nestedWords = Arrays.asList(
                Arrays.asList("Java", "Stream"),
                Arrays.asList("API", "Lambda"),
                Arrays.asList("FlatMap", "Map")
        );



        //-----------------------🔹 Basic Stream Operations----------------------------//
        //-----------------------Filter even numbers from a list of integers.------------------//
        System.out.println("-----------------------Filter even numbers from a list of integers.------------------");
        List<Integer> evenNumbers=numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println(evenNumbers);
        System.out.println("-----------------------------------------------");

        //-----------------------Find names starting with a specific letter from a list of strings.------------------//
        System.out.println("-----------------------Find names starting with a specific letter from a list of strings.------------------");
        char letter = 'A';
        List<String> startWith=names.stream().filter(name -> name!=null && !name.isEmpty() && name.charAt(0) == letter ).collect(Collectors.toList());
        System.out.println(startWith);
        System.out.println("--------------------------------------------");

        //-----------------------Convert all strings to uppercase using stream.------------------//
        System.out.println("-------Convert all strings to uppercase using stream.---------------");
        List<String> upperCaseNames =names.stream().filter(name -> name!=null && !name.isEmpty()).map(c -> c.toUpperCase()).collect(Collectors.toList());
        System.out.println(upperCaseNames);
        System.out.println("-----------------------------------------");

        //-----------------------Sort a list of integers in descending order using streams.------------------//
        System.out.println("--------------Sort a list of integers in descending order using streams.-------------");
        List<Integer> descendingNumbers = numbers.stream().sorted().collect(Collectors.toList()).reversed();
        System.out.println(descendingNumbers);
        System.out.println("--------------------------------------");

        //-----------------------Remove duplicate elements from a list using distinct().------------------//
        System.out.println("---------------------Remove duplicate elements from a list using distinct().------------------");
        List<Integer> duplicateNumbers = numbers.stream().sorted().distinct().toList();
        System.out.println(duplicateNumbers);
        System.out.println("=================================================");

        //-----------------------🔹 Intermediate Stream Tasks------------------------
        //------------------------Count the number of strings longer than 5 characters.---------------------
        System.out.println("----------------Count the number of strings longer than 5 characters.---------------");
        Long count=names.stream().filter(name -> name!=null && !name.isEmpty() && name.length()>5).count();
        System.out.println(count);
        System.out.println("------------------------------------------");

        //------------------------Find the first element in a stream that matches a given condition.---------------------
        System.out.println("------------Find the first element in a stream that matches a given condition.-------------");
        Optional<String> fName=names.stream().filter(name-> !name.isEmpty() && name.startsWith("A")).findFirst();
        System.out.println(fName);
        System.out.println("-----------------------------------------------");

        //------------------------Check if any number is divisible by 5 in a list.---------------------
        System.out.println("-------------------Check if any number is divisible by 5 in a list.------------");
        Boolean div5=numbers.stream().anyMatch(num -> num%5==0);
        System.out.println(div5);
        System.out.println("------------------------------------------------");

        //------------------------Collect elements into a Set instead of a List.---------------------
        System.out.println("------------------Collect elements into a Set instead of a List.------------------------");
        Set<Integer> set=numbers.stream().collect(Collectors.toSet());
        System.out.println(set);
        System.out.println("----------------------------------------------");

        //------------------------Skip the first 3 elements and return the rest.---------------------
        System.out.println("------------------------Skip the first 3 elements and return the rest.------------------");
        List<String> remove3Names=names.stream().skip(3).collect(Collectors.toList());
        System.out.println(remove3Names);
        System.out.println("----------------------------------------------");
        System.out.println("===============================================");

        //-------------------------------🔹 Numeric Streams & Reductions--------------------\

        //----------------------Calculate the sum of a list of integers using reduce.----------------
        System.out.println("--------------Calculate the sum of a list of integers using reduce.-------------");
        Integer result=numbers.stream().reduce(0,(sum,num)-> sum+num);
        System.out.println(result);
        System.out.println("---------------------------------------------");


        //----------------------Find the maximum and minimum value in a list.----------------
        System.out.println("--------------Find the maximum and minimum value in a list.-------------------");
        Integer maximum=numbers.stream().max(Integer::compareTo).get();
        System.out.println("maximum is "+maximum);
        Integer minimum=numbers.stream().min(Integer::compareTo).get();
        System.out.println("minimum is "+minimum);
        System.out.println("-------------------------------------");

        //----------------------Calculate the average of a list of doubles.----------------
        System.out.println("------------------Calculate the average of a list of doubles.---------------------");
        Double average= numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println(average);
        System.out.println("-------------------------------------------");

        //----------------------Multiply all integers in a list together using reduce.----------------
        System.out.println("-----------------Multiply all integers in a list together using reduce.------------------");
        Integer multiply=numbers.stream().reduce(1, (a,b)->a*b);
        System.out.println(multiply);
        System.out.println("------------------------------------------");



        //----------------------Count how many numbers are positive in a list.----------------
        System.out.println("-------------------Count how many numbers are positive in a list.-------------------");
        Long countPositive=numbers.stream().filter(num->num>0).count();
        System.out.println(countPositive);
        System.out.println("-----------------------------------");
        System.out.println("=========================================================");


        //---------------------🔹 Collectors & Grouping--------------------
        //------------------------Group a list of students by their department.---------------------
        System.out.println("-------------------------Group a list of students by their department-----------------------");
        Map<String,List<Student>> grouping=students.stream().collect(Collectors.groupingBy(Student::getDepartment));
        grouping.forEach((dept,list)->System.out.println(dept+" -> "+list));
        System.out.println("-------------------------------------");

        //----------------------Partition a list of numbers into even and odd using partitioningBy.----------------
        System.out.println("----------------------Partition a list of numbers into even and odd using partitioningBy.----------------");
        Map<Boolean,List<Integer>> partitionEvenOdd=numbers.stream().collect(Collectors.partitioningBy(num->num%2==0));
        System.out.println("even: "+partitionEvenOdd.get(true));
        System.out.println("odd: "+partitionEvenOdd.get(false));
        System.out.println("-------------------------------------");

        //----------------------Create a comma-separated string from a list of strings.----------------
        String namesString=names.stream().collect(Collectors.joining(","));
        System.out.println(namesString);
        System.out.println("-------------------------------------");

        //----------------------Group employees by age and count how many per age.----------------
        System.out.println("----------------Group employees by age and count how many per age.--------------");
        Map<Integer,List<Employee>> employeeGroup=employees.stream().collect(Collectors.groupingBy(Employee::getAge));
        employeeGroup.forEach((age,list)->System.out.println("age: "+age+" -> "+list+" count: "+list.size()));


        //---------------------Find the average salary per department in a list of employees.----------------
        System.out.println("----------------Find the average salary per department in a list of employees.--------------");
        Map<String,Double> avgSalaryDept=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(avgSalaryDept);
        System.out.println("------------------------------------");

        //----------------------🔹 Optional, Map, FlatMap----------------
        //-----------------------Flatten a list of lists into a single list.----------------//
        System.out.println("----------Flatten a list of lists into a single list.-----");
        List<String> flattenList = nestedWords.stream().flatMap(strings ->  strings.stream()).collect(Collectors.toList());
        System.out.println(nestedWords);
        System.out.println(flattenList);
        System.out.println("--------------------------------------");


        //-----------------------Extract all unique characters from a list of words.-------------//
        System.out.println("------------------Extract all unique characters from a list of words.-----------------------");
        List<Character> uniqueChar=names.stream().filter(n -> n!=null && !n.isEmpty()).map(String::toLowerCase).flatMapToInt(String::chars).distinct().mapToObj(c -> (char)c).collect(Collectors.toList());
        System.out.println(uniqueChar);
        System.out.println("-------------------------------------");

        //----------------------Filter a list of Optionals and collect non-empty values.-----------------//
        System.out.println("-----------Filter a list of Optionals and collect non-empty values.----------");
        List<Optional<String>> optionals=Arrays.asList(
                Optional.of("John"),
                Optional.empty(),
                Optional.of("Omar"),
                Optional.empty(),
                Optional.of("Ahmed")
        );
        List<String> nonEmpty=optionals.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toList());
        System.out.println(nonEmpty);
        System.out.println("-----------------------------------------------------");

        //----------------------Map a list of strings to their lengths.-----------------//
        System.out.println("-------------Map a list of strings to their lengths.-----------------");
        Map<String,Integer> nameLen=names.stream().filter(n -> n!=null && !n.isEmpty()).collect(Collectors.toMap(
                word -> word ,
                String::length
        ));
        System.out.println(nameLen);
        System.out.println("----------------------------------------");

        //----------------------Return a list of uppercased words that start with “A”.-----------------//
        System.out.println("---------------Return a list of uppercased words that start with “A”.----------------");
        List<String> upperCaseA=names.stream().filter(n -> n!=null && !n.isEmpty() && n.startsWith("A")).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseA);
        System.out.println("--------------------------------------");

        //--------------------🔹 Advanced Operations------------
        //---------------------Sort a list of employees by salary then by name.--------------
        System.out.println("-------------Sort a list of employees by salary then by name.---------------");
        List<Employee> employeesSorting=employees.stream().sorted(Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(employeesSorting);
        System.out.println("-----------------------------------");


        //----------------------Find the second highest number in a list.-----------------//
        System.out.println("-----------Find the second highest number in a list.-----------");
        List<Integer> secMax=numbers.stream().distinct().sorted().toList().reversed();
//        System.out.println(secMax);
        System.out.println(secMax.get(1));
        System.out.println("-------------------------------------");

        //----------------------Find duplicate elements in a list of integers.-----------------//
        System.out.println("--------------Find duplicate elements in a list of integers.----------------");
        Set<Integer> setDuplicates=new HashSet<Integer>();
        List<Integer> duplicates=numbers.stream().filter(n->!setDuplicates.add(n)).distinct().collect(Collectors.toList());
        System.out.println(duplicates);
        System.out.println("-------------------------------------");

        //----------------------Remove null or empty strings from a list using stream.-----------------//
        System.out.println("-----------------Remove null or empty strings from a list using stream.------------------");
        List<String> pureNames=names.stream().filter(n -> n!=null && !n.isEmpty()).collect(Collectors.toList());
        System.out.println(pureNames);
        System.out.println("-------------------------------------");

        //----------------------Partition students into pass/fail groups based on grade.-----------------//
        System.out.println("---------Partition students into pass/fail groups based on grade.----------------");

        Map<Boolean,List<Student>> grades=students.stream().collect(Collectors.partitioningBy(s->s.getGrade()>=60));
        System.out.println("Pass: "+grades.get(true));
        System.out.println("Fail: "+grades.get(false));
        System.out.println("------------------------------------");



    }
}