import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        
        
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        System.out.println("LinkedList after adding elements at first position: " + list);

       
        list.removeLast();
        System.out.println("LinkedList after deleting last element: " + list);

        
        System.out.println("Size of LinkedList: " + list.size());
    }
}
