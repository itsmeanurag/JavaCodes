package functions;

import java.util.Scanner;

public class function_prog {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the number");
        int num = input.nextInt();
        armstrong(num);

    }
    static void prime(int n){
        int c =2;
        while(c<=n){
            if (n%c==0){
                System.out.println("not prime");
                break;

            } else{
                System.out.println("prime");
                break;
            }

        }
        c=c+1;
    }
    static void armstrong(int m){
        int temp = m;
        int sum = 0;
        while(m>0){
            int digit = m%10;
            sum = sum+(digit*digit*digit);
            m = m/10;
        }
        if(temp == sum){
            System.out.println("armstrong number");
        }else{
            System.out.println("not an armstrong number");
        }
    }
}