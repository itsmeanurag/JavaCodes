package sem3_codes;

import java.util.Scanner;

class operations{
    static void sum(float a,float b){
        System.out.println("your sum is "+(a+b));
    }static void sum2(float a,float b,float c){
        System.out.println("your sum is "+(a+b+c));
    }
    static void sub(float a,float b){
        System.out.println("your sub is "+(a-b));
    }
    static void mul(float a,float b){
        System.out.println("your mul is "+(a*b));
    }
    static void mul2(float a,float b,float c){
        System.out.println("your sum is "+(a*b*c));
    }
    static void dev(float a,float b){
        if(b!=0){
            System.out.println("your dev is "+(a/b));
        }else{
            System.out.println("cannot divide by zero");
        }

    }
    static void avg(float a,float b,float c){
        System.out.println("avg is \n"+((a+b+c)/3));
    }
    static void largest(float a,float b){
        float max = a;
        if (b>max){
            max = b;
        }if(a==b){
            System.out.println("are equal");
        }
        System.out.println(max+" is the largest");
    }
    static void largest(float a,float b,float c) {
        float max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (a == b & b == c) {
            System.out.println("are equal");
        }
        System.out.println(max + " is the largest");
    }static void smallest(float a,float b,float c) {
        float min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        if (a == b & b == c) {
            System.out.println("are equal");
        }
        System.out.println(min + " is the smallest");
    }


}

public class First_Assingment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // question 1//
//        System.out.println("enter the first number:");
//        float a = input.nextFloat();
//        System.out.println("enter the second number:");
//        float b = input.nextFloat();
//
//        operations.sum(a,b);
//        operations.sub(a,b);
//        operations.mul(a,b);
//        operations.dev(a,b);


        // question 2//
//        System.out.println("input the first number:");
//        int a = input.nextInt();
//        System.out.println("input the second number:");
//        int b = input.nextInt();
//
//        operations.largest(a,b);

        //question 3//
        System.out.println("input the first number:");
        int a = input.nextInt();
        System.out.println("input the second number:");
        int b = input.nextInt();
        System.out.println("input the third number:");
        int c = input.nextInt();

        operations.sum2(a,b,c);
        operations.mul2(a,b,c);
        operations.largest(a,b,c);
        operations.smallest(a,b,c);

    }


}
