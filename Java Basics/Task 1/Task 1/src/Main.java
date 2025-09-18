import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        //-----------------------------------------------A----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        String name=scanner.nextLine();
//        System.out.println("Hello, "+name);


        //-----------------------------------------------B----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        int num1=scanner.nextInt();;
//        long num2=scanner.nextLong();
//        char ch=scanner.next().charAt(0);
//        float num3 = scanner.nextFloat();
//        double num4= scanner.nextDouble();
//        System.out.println(num1);
//        System.out.println(num2);
//        System.out.println(ch);
//        System.out.println(num3);
//        System.out.println(num4);


        //-----------------------------------------------C----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        float num1=scanner.nextFloat();
//        float num2=scanner.nextFloat();
//        System.out.println(num1+" + "+num2+" = "+ (num1+num2) );
//        System.out.println(num1+" * "+num2+" = "+ (num1*num2) );
//        System.out.println(num1+" - "+num2+" = "+ (num1-num2) );

        //-----------------------------------------------D----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        float num1=scanner.nextFloat();
//        float num2=scanner.nextFloat();
//        float num3=scanner.nextFloat();
//        float num4=scanner.nextFloat();
//        System.out.println("Difference = "+((num1*num2)-(num3*num4)));


        //-----------------------------------------------E----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        double radius=scanner.nextDouble();
//        double p1=3.141592653;
//        double area;
//        area=p1*(radius*radius);
//        System.out.println(area);

        //-----------------------------------------------F----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        long num1=scanner.nextLong();
//        long num2=scanner.nextLong();
//        int last1= (int)(num1%10);
//        int last2= (int)(num2%10);
//        System.out.println(last1+last2);

        //-----------------------------------------------G----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        long num =scanner.nextLong();
//        long result=0;
//        for(int i = 1; i<= num; i++){
//            result+=i;
//        };
//        System.out.println(result);

        //-----------------------------------------------H----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        double A=scanner.nextDouble();
//        double B=scanner.nextDouble();
//        double result=A/B;
//        int floor=(int)Math.floor(result);
//        int ceil=(int)Math.ceil(result);
//        int round=(int)Math.round(result);
//        System.out.println("Floor "+A+"/"+B+" = "+floor);
//        System.out.println("ceil "+A+"/"+B+" = "+ceil);
//        System.out.println("round "+A+"/"+B+" = "+round);



        //-----------------------------------------------I----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        int A=scanner.nextInt();
//        int B=scanner.nextInt();
//        if(A>=B){
//            System.out.println("Yes");
//        }
//        else{
//            System.out.println("No");
//        }


        //-----------------------------------------------J----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        int A=scanner.nextInt();
//        int B=scanner.nextInt();
//        if(A%B==0 || B%A==0){
//            System.out.println("Multiplies");
//        }
//
//        else{
//            System.out.println("No Multiplies");
//        }

        //-----------------------------------------------K----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        int A=scanner.nextInt();
//        int B=scanner.nextInt();
//        int C=scanner.nextInt();
//        int min = 0,max=0;
//
//        if(A<B && A<C){
//            min=A;
//            if(B>C){
//                max=B;
//            }
//            else if(C>B) {
//                max=C;
//            }
//        }
//        else if(B<A && B<C){
//            min=B;
//            if(A>C){
//                max=A;
//            }
//            else if(C>A) {
//                max=C;
//            }
//        }
//
//        else if(C<A && C<B){
//            min=C;
//            if(A>B){
//                max=A;
//            }
//            else if (B>A)  {
//                max=B;
//            }
//        }
//        System.out.println(min+" "+max);


        //-----------------------------------------------L----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        String firstName1=scanner.next();
//        String lastName1=scanner.next();
//        String firstName2=scanner.next();
//        String lastName2=scanner.next();
//        if(lastName1.equals(lastName2)){
//            System.out.println("ARE BROTHERS");
//        }
//        else {
//            System.out.println("NOT");
//        }


    //-----------------------------------------------M----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        char c=scanner.next().charAt(0);
//        int character=c;
//        if(character>=48 && character<=57){
//            System.out.println("Is Digit");
//        } else if (character<=90 && character>=65) {
//            System.out.println("ALPHA");
//            System.out.println("IS CAPITAL");
//
//        }else if (character<=97 && character>=48) {
//            System.out.println("ALPHA");
//            System.out.println("IS SMALL");
//        }else {
//            System.out.println("INVALID INPUT");
//        }


        //-----------------------------------------------N----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        char c=scanner.next().charAt(0);
//        int character=c;
//        if(character<=90 && character>=65){
//            int lowerCase=character+32;
//            char lowCase=(char) lowerCase;
//            System.out.print(lowCase);
//        } else if (character>=97&&character<=122) {
//            int upperCase=character+32;
//            char upCase=(char) upperCase;
//            System.out.print(upCase);
//        }else {
//            System.out.println("Invalid input");
//        }


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


        //-----------------------------------------------Q----------------------------------------//

//        Scanner scanner = new Scanner(System.in);
//        double p1 = scanner.nextDouble();
//        double p2 = scanner.nextDouble();
//        if(p1>0 && p2>0){
//            System.out.println("Q1");
//        }
//        else if(p1<0 && p2>0){
//            System.out.println("Q2");
//        }
//        else if(p1<0 && p2<0){
//            System.out.println("Q3");
//        }
//        else if(p1>0 && p2<0){
//            System.out.println("Q4");
//        }
//        else if(p1==0 && p2!=0){
//            System.out.println("Y-AXIS");
//        }
//        else if(p1!=0 && p2==0){
//            System.out.println("X-AXIS");
//        }
//        else if(p1==0 && p2==0){
//            System.out.println("ORIGIN");
//        }


        //-----------------------------------------------R----------------------------------------//

//        Scanner scanner=new Scanner(System.in);

//        int days=scanner.nextInt();
//        int year=days/365;
//        int remain=days%365;
//        int month=remain/30;
//        remain=remain%30;
//        System.out.println(year+ " Years");
//        System.out.println(month+ " Months");
//        System.out.println(remain+" Days");


        //-----------------------------------------------S------[m4 mfhom 5als]----------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        int number=scanner.nextInt();
//        if(number>=0 && number<=25){
//            if(number==0){
//                System.out.println("Interval (0,25]");
//            }
//
//        }


        //-----------------------------------------------T----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        int A=scanner.nextInt();
//        int B=scanner.nextInt();
//        int C=scanner.nextInt();
//        int min = 0,max=0,mid=0;
//
//        if(A<B && A<C){
//            min=A;
//            if(B>C){
//                max=B;
//                mid=C;
//            }
//            else if(C>B) {
//                max=C;
//                mid=B;
//            }
//        }
//        else if(B<A && B<C){
//            min=B;
//            if(A>C){
//                max=A;
//                mid=C;
//            }
//            else if(C>A) {
//                max=C;
//                mid=A;
//            }
//        }
//
//        else if(C<A && C<B){
//            min=C;
//            if(A>B){
//                max=A;
//                mid=B;
//            }
//            else if (B>A)  {
//                max=B;
//                mid=A;
//            }
//        }
//        System.out.println(min);
//        System.out.println(mid);
//        System.out.println(max);
//        System.out.println(" ");
//        System.out.println(A);
//        System.out.println(B);
//        System.out.println(C);



        //-----------------------------------------------U----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        float num=scanner.nextFloat();
//        if(num%1==0){
//            int numInt=(int) num;
//            System.out.println("Int "+numInt);
//        }
//        else{
//            System.out.println("Float "+num);
//        }


        //-----------------------------------------------V----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        int num1=scanner.nextInt();
//        char op=scanner.next().charAt(0);
//        int num2=scanner.nextInt();
//        switch (op) {
//            case '<':{
//                if(num1<num2){
//                    System.out.println("Right");
//                }
//                else {
//                    System.out.println("Wrong");
//                }
//                break;
//            }
//            case '>':{
//                if(num1>num2){
//                    System.out.println("Right");
//                }
//                else {
//                    System.out.println("Wrong");
//                }
//                break;
//            }
//            case '=':{
//                if(num1==num2){
//                    System.out.println("Right");
//                }
//                else {
//                    System.out.println("Wrong");
//                }
//                break;
//            }
//        }


        //-----------------------------------------------W----------------------------------------//

//        Scanner scanner=new Scanner(System.in);
//        int num1=scanner.nextInt();
//        char op=scanner.next().charAt(0);
//        int num2=scanner.nextInt();
//        char op2=scanner.next().charAt(0);
//        int num3=scanner.nextInt();
//        switch (op) {
//            case '+':{
//                if(op2!='='){
//                    System.out.println("invalid operation");
//                    break;
//                }
//                if(num1+num2==num3){
//                    System.out.println("YES");
//                }
//                else{
//                    System.out.println(num1+num2);
//                }
//                break;
//            }
//            case '-':{
//                if(op2!='='){
//                    System.out.println("invalid operation");
//                    break;
//                }
//                 if(num1-num2==num3){
//                     System.out.println("YES");
//                 }
//                 else{
//                     System.out.println(num1-num2);
//                 }
//                break;
//            }
//            case '*':{
//                if(op2!='='){
//                    System.out.println("invalid operation");
//                    break;
//                }
//                if(num1*num2==num3){
//                    System.out.println("YES");
//                }
//                else{
//                    System.out.println(num1*num2);
//                }
//                break;
//            }
//        }


        //-----------------------------------------------X----------------------------------------//

//                Scanner scanner=new Scanner(System.in);
//                int l1=scanner.nextInt();
//                int r1=scanner.nextInt();
//                int l2=scanner.nextInt();
//                int r2=scanner.nextInt();
//                if(r1<l2 || r2<l1){
//                    System.out.println("-1");
//                } else if (r1>=l2 && l1<l2) {
//                    System.out.println(l2+" "+r1);
//                } else if (l1>=l2 && r1<=r2) {
//                    System.out.println(l1+" "+r1);
//                } else if (l1>=l2 && r1>r2) {
//                    System.out.println(l1+" "+r2);
//
//                }




        //-----------------------------------------------Y----------------------------------------//

//            Scanner scanner = new Scanner(System.in);
//            long a = scanner.nextLong();
//            long b = scanner.nextLong();
//            long c = scanner.nextLong();
//            long d = scanner.nextLong();
//            long result = a*b*c*d;
//            String sResult = Long.toString(result);
//            System.out.println(sResult.charAt(sResult.length()-2)+""+sResult.charAt(sResult.length()-1));


        //-----------------------------------------------Z----------------------------------------//
//            Scanner scanner = new Scanner(System.in);
//            int num1=scanner.nextInt();
//            int num2=scanner.nextInt();
//            int num3=scanner.nextInt();
//            int num4=scanner.nextInt();
//            int lResult=1,rResult=1;
//            for(int i=1;i<=num2;i++){
//                lResult=lResult*num1;
//            }
//            for(int i=1;i<=num4;i++){
//                rResult=rResult*num3;
//            }
//            if(lResult>rResult){
//                System.out.println("YES");
//            }
//            else{
//                System.out.println("NO");
//            }

        //-----------------------------------------------Contest A----------------------------------------//


//        Scanner scanner = new Scanner(System.in);
//        float dis=scanner.nextFloat();
//        float price=scanner.nextFloat();
//        float result=price/(1-(dis/100));
//        System.out.println(result);

        //-----------------------------------------------Contest B----------------------------------------//

//            Scanner scanner = new Scanner(System.in);
//            int memo=scanner.nextInt(),momo=scanner.nextInt(),div=scanner.nextInt();
//            if(memo%div==0 && momo%div==0){
//                System.out.println("Both");
//            }else if(memo%div==0){
//                System.out.println("Memo");
//            }else if(momo%div==0){
//                System.out.println("Momo");
//            }else{
//                System.out.println("No One");
//            }



        //------------------------------------------Contest C------------------------------------//

//        Scanner input = new Scanner(System.in);
//        Character character=input.next().charAt(0);
//        if (character>=97 && character<122){
//            char ch= (char) (character+1);
//            System.out.println(ch);
//        } else if (character==122) {
//            char ch= (char) (97);
//            System.out.println(ch);
//        }

        //------------------------------------------Contest D------------------------------------//
//        Scanner scanner = new Scanner(System.in);
//        int a=scanner.nextInt();
//        int b=scanner.nextInt();
//        int c=scanner.nextInt();
//        int d=scanner.nextInt();
//        if(a+b+c==d || a+b-c==d || a-b+c==d || a-b-c==d ||a*b*c==d || a*b+c==d
//                || a*b-c==d || a+b*c==d || a-b*c==d ){
//            System.out.println("YES");
//
//        }
//        else {
//            System.out.println("NO");
//        }


        //------------------------------------------Contest E------------------------------------//
//        Scanner scanner = new Scanner(System.in);
//        int odd = scanner.nextInt();
//        int even = scanner.nextInt();
//        if (odd == 0 && even == 0) {
//            System.out.println("NO");
//            return;
//        }
//        int total = odd + even;
//        if (total % 2 == 0) {
//            if (even==odd){
//                System.out.println("YES");
//            }else {
//                System.out.println("NO");
//            }
//
//        }else {
//            if(Math.abs(even-odd)==1){
//                System.out.println("YES");
//            }else  {
//                System.out.println("NO");
//            }
//        }





    }
}