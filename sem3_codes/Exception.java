package sem3_codes;

public class Exception {
    public static void main(String[] args) {
        System.out.println("main start");
        try {
            test(9);
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }
        System.out.println("main end");
    }
    public static void test(int i) throws ClassNotFoundException{
        System.out.println("test start");
        test1(9);
        System.out.println("test end");
    }
    public static void test1(int i) throws ClassNotFoundException{
        System.out.println("test1 start");
            test2(9);
        System.out.println("test1 end");
    }
    public static void test2(int i) throws ClassNotFoundException{
        System.out.println("test2 start");
        Class.forName(" ");
        System.out.println("test2 end");
    }
}
