public class ThreadInfo 
{
    public static void main(String[] args) 
{

        Thread thread = Thread.currentThread();
        System.out.println("Name: " + thread.getName());
        System.out.println("Priority: " + thread.getPriority());
    }
}
