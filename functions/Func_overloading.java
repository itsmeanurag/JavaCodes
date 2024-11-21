package functions;

import java.util.Arrays;

public class Func_overloading {
    public static void main(String[] args) {
//        fun(23);
//        fun("anurag");
//        float ans;
//        ans = sum(2,3);
//        System.out.println(ans);
//        ans = sum(2,3,4);
//        System.out.println(ans);
        demo(2,3,4);
        demo("anurag","kabeer") ;

    }
    //function with VarArg://
    static void demo(int...v){
        System.out.println(Arrays.toString(v));
    }
    static void demo(String...v){
        System.out.println(Arrays.toString(v));
    }

    // functions with same name but different data type//
    static void fun(int a){
        System.out.println("first one");
        System.out.println(a);
    }
    static void fun(String name){
        System.out.println("second one");
        System.out.println(name);
    }//
    static float sum(int a,int b){
        return a+b;

    }static float sum(int a,int b,int c){
        return a+b+c;

    }
}

