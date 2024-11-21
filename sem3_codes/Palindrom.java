package sem3_codes;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the string");
        String s = input.next();
        if(palindrom(s)){
            System.out.println("palindrome");
        }else{
            System.out.println("not a palindrome");
        }

    }
    public static boolean palindrom(String s){
        int low = 0;
        int high = s.length()-1;
        while(low<high){

            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }return true;
    }
}
