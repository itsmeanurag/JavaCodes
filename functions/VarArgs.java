package functions;

import java.util.Arrays;

public class VarArgs {
    public static void main(String[] args) {
        fun(3,4,5,6,7,87,25,93,76);
    }

    static void multiple(int a,int b,String...v){

    }

    static void fun(int...v){
        System.out.println(Arrays.toString(v));
    }
}
