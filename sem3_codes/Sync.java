package sem3_codes;

class Shared {
    public void set(){
        for(int i = 0;i<500;i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }
}
class MyThread1 extends Thread{
    Shared s1 = null;
    public MyThread1(Shared s1){
        this.s1 = s1;
    }
    @Override
    public void run() {
        s1.set();
    }
}
class MyThread2 extends Thread{
    Shared s1 = null;
    public MyThread2(Shared s1){
        this.s1 = s1;
    }
    @Override
    public void run() {
        s1.set();
    }
}

public class Sync {
    public static void main(String[] args) {
        Shared s1 = new Shared();
//        Shared s2 = new Shared();
        MyThread1 T1 = new MyThread1(s1);
        MyThread2 T2 = new MyThread2(s1);
//        MyThread2 T2 = new MyThread2(s2);
        T1.start();
        T2.start();
    }
}
