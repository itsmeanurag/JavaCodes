package functions;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {

        int a = 23;
        int b = 84;
//        // swap method//
//        int temp = a;
//        a= b;
//        b = temp;
//        System.out.println(a+" "+b);

//        swap(a,b);
//        System.out.println(a+" "+b);

        // create an array//

        int[] arr = {1,2,3,4,5,6};
        change(arr);
        System.out.println(Arrays.toString(arr));


    }
    // function to change array//
    static void change(int[] nums){
        int temp = nums[0];//if you make a change to the object via this ref. variable
        nums[0] = nums[1];
        nums[1]= temp;
        //
    }
//    static void swap(int c, int d){
//        int temp = c;
//        c = d ;
//        temp = d;
//    }
}

