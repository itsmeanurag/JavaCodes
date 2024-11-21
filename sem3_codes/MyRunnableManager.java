package sem3_codes;

class MyRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0;i<100;i+=2){
            System.out.println(Thread.currentThread().getName()+" ; "+i);
        }
    }
}

public class MyRunnableManager {
    public static void main(String[] args) {
        MyRun My = new MyRun();
        Thread t1 = new Thread(My);
        t1.start();
        for (int i = 1;i<100;i+=2){
            System.out.println(Thread.currentThread().getName()+" ; "+i);
        }
    }
}
