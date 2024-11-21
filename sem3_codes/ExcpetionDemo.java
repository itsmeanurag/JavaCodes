package sem3_codes;

import java.util.Scanner;

public class ExcpetionDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        try {
////            String arr[] = new String[7];
//            String s = args[0];
//            int i = Integer.parseInt(s);
//            int j = i/(i-9);
//            System.out.println("value of j"+j);
//        }catch (ArrayIndexOutOfBoundsException ex){
//            System.out.println("command line arguments is not passed");
//        }catch (NumberFormatException ex){
//            System.out.println("string to int conversion");
//        }catch (ArithmeticException ex){
//            System.out.println("divided by zero");
//        }finally {
//            System.out.println("gsv rocks");
//        }
//        System.out.println("main end");

        // program for exception handelling//

        int j = test(9);
        System.out.println("value of j "+j);
    }

    public static int test(int i){
        int j = 0;
        try{
            j = i/(i-9);
            return j;
        }catch (ArithmeticException ex){
            System.out.println("divided by zero");
            return 0;
        }
    }

}
