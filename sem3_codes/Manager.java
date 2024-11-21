package sem3_codes;

class Test extends Thread {
    public void run() {
        setName("okay sir");
        for(int i = 0;i<1000;i+=2){
            if(i==40){
                stop();
            }
            try{
                Thread.sleep(100);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(getName()+":"+i);
        }
    }
}

class Sample extends Thread{
    public void run() {
        setName("okay sir");
        for(int i = 1;i<1000;i+=2){
            try{
                Thread.sleep(100);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            System.out.println(getName()+":"+i);
        }
    }
}

public class Manager {
    public static void main(String[] args) { // main
        Test t1 = new Test();
        t1.start();
        Sample s1 = new Sample();
        s1.start();
    }
}
