package sem3_codes;

class One {
    public void set(int value){
        int i = value/0;
        System.out.println("Value of"+Thread.currentThread().getName()+":"+i);
    }
}
class Two{
    int i;
    Two(int i){
        this.i = i;
    }
    void callSet(){
        new One().set(i);
    }
}
class OneTwo extends Thread{
    @Override
    public void run() {
        Two t = new Two(10);
        t.callSet();
    }
}
class First {
    public void set(int value){
        int i = value/10;
        System.out.println("Value of"+Thread.currentThread().getName()+":"+i);
    }
}
class Second {
    int i;
    Second(int i){
        this.i = i;
    }
    void callSet(){
//        new Second().set(i);
    }
}
class FirstSecond extends Thread{
    @Override
    public void run() {
        Second t = new Second(10);
        t.callSet();
    }
}
public class ExceptionWithThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        OneTwo ot = new OneTwo();
        ot.start();
        FirstSecond fs = new FirstSecond();
        fs.start();
    }
}
