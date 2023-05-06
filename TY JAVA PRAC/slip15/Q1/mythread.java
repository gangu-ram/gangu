class mythread
{
public static void main(String args[])
  {
  Thread t=new Thread();
System.out.println("current thread  is"+t.currentThread());
    t.setName("abc");
    t.setPriority(7);
    System.out.println("new name & Priority of thread" +t);
   for(int i=1;i<=5;i++)
   {
      try
          {  
   System.out.println("i="+i);
    Thread.sleep(1000);
  }catch(InterruptedException e)
   {

  }
}
System.out.print("exiting from thread");
        
     }
}
