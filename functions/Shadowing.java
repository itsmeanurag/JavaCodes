package functions;

public class Shadowing {
    static int x = 90;// this will be shadowed at line 8
    public static void main(String[] args) {
        System.out.println(x); //90
        int x;
        x = 40; // this will be shadow the line 4 ;
        System.out.println(x); //40
        fun();
    }
    static void fun(){
        int x = 35;
        System.out.println(x);
    }
}
