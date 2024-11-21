package functions;

/*  function syntax :
            return_type name (arguments){
                // body
                return statement
 */

import java.util.Scanner;

public class Try_f_01 {
    public static void main(String[] args) {
//        sum();

//        float ans = sum_r();
//        System.out.println("the sum is :"+ans);

//        greeting();

//        String message = greeting1();
//        System.out.println(message);

//        float ans = sum_a(536.873F,872.785F);
//        System.out.println("the sum is : "+ans);
        Scanner input = new Scanner(System.in);
        System.out.println("enter your name : ");
        String naam = input.next();
        String ans = greeting_a(naam);
        System.out.println(ans);
    }
        // greeting function//
//    static void greeting (){
//        System.out.println("hello world");
//    }
        // return type string//
//    static String greeting1 (){
//        String greet = "hello world";
//        return greet;
//    }
    // sum //
//    static void sum() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("enter the 1st number:");
//        float num1 = input.nextFloat();
//        System.out.println("enter the 2st number:");
//        float num2 = input.nextFloat();
//        float sum = (num1 + num2);
//        System.out.println("the sum is: " + sum);
//    }
    // sum with return type//
//    static float sum_r() {
//        Scanner input = new Scanner(System.in);
//        System.out.println("enter the 1st number:");
//        float num1 = input.nextFloat();
//        System.out.println("enter the 2st number:");
//        float num2 = input.nextFloat();
//        float sum = (num1 + num2);
//        return sum;
//    }
    // sum function with arg//
//    static float sum_a(float a,float b){
//        float sum3 = a+b;
//        return sum3;
//    }
    // greeting function with arg://
    static String greeting_a(String name){
        String message = "hello everyone from "+name;
        return message;

    }

}
