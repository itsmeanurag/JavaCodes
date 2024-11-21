package Thread;/*CORRECTED CODE

import java.awt.print.Book;

class Thread.Booking extends Thread{
    Object train = null;
    Object comp = null;

    public Thread.Booking(Object train, Object comp){
        super();
        this.train = train;
        this.comp = comp;
    }
    public void run(){
        System.out.println(getName()+"Thread.Booking Start");
        synchronized (train)
        {
            System.out.println(getName()+"Book train");
            try{
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (comp){
                System.out.println(getName()+"Book comp");
            }
        }
        System.out.println(getName()+"Thread.Booking end");
    }
}

class cancel extends Thread{
    Object train = null;
    Object comp = null;

    public cancel(Object train, Object comp){
        super();
        this.train = train;
        this.comp = comp;
    }
    public void run(){
        System.out.println(getName()+"cancel Start");
        synchronized (train)
        {
            System.out.println(getName()+"cancel comp");
            try{
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (comp){
                System.out.println(getName()+ "cancel train");
            }
        }
        System.out.println(getName()+"cancellation end");
    }

}
public class DeadLock {
    public static void main(String[] args) {
        Object train = new Object();
        Object comp = new Object();
        Thread.Booking bk = new Thread.Booking(train,comp);
        bk.setName("Rishav");
        cancel cc = new cancel(train, comp);
        cc.setName("Rithivuik");
        bk.start();
        cc.start();
    }
}
*/


class Booking extends Thread
{
  Object train=null;
  Object comp  =null;
    
  public Booking(Object train, Object comp) 
  {
	super();
	this.train = train;
	this.comp = comp;
 }

public void run() 
  {
	System.out.println(getName()+"Thread.Booking start");
	synchronized (train)
	{
		System.out.println(getName()+"Book train");
		try
		{
			sleep(100);
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		synchronized (comp)
		{
			System.out.println(getName()+"Book comp");
		}
		
	}
	System.out.println(getName()+"Thread.Booking end");
  }	
}
class Cancel extends Thread
{
	Object train=null;
	Object comp  =null;
	 
	public Cancel(Object train, Object comp)
	{
		super();
		this.train = train;
		this.comp = comp;
	}

	public void run() 
	   {
		
		System.out.println(getName()+"Thread.Cancel start");
		synchronized (comp)
		{
			System.out.println(getName()+"Cacnel comp");
			try
			{
				sleep(100);
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
			synchronized (train)
			{
				System.out.println(getName()+"Thread.Cancel train");
			}
			
		}
		System.out.println(getName()+"Thread.Cancel end");
	   }
}
public class DeadLockDemo 
{
 public static void main(String[] args) 
 {
		
   Object train  =new Object();
   Object comp  =new Object();
   Booking bk  =new Booking(train, comp);
   bk.setName("Ankit");
   Cancel cc =new Cancel(train, comp);
   cc.setName("Ankita");
   bk.start();
   cc.start();
 }
   
   
}