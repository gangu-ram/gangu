import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Student {
    public static void main(String[] args) {
        ArrayList<String> studentNames = new ArrayList<String>();

        // Add student names from command line arguments to the ArrayList
        for (String arg : args) {
            studentNames.add(arg);
        }

        // Display student names using Iterator
        System.out.println("Student Names using Iterator:");
        Iterator<String> iterator = studentNames.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Display student names using ListIterator
        System.out.println("Student Names using ListIterator:");
        ListIterator<String> listIterator = studentNames.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
