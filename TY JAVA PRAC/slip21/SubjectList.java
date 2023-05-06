import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class SubjectList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> subjects = new LinkedList<String>();
        
        System.out.print("Enter the number of subjects: ");
        int n = scanner.nextInt();
        
        // Accepting subject names from the user and storing them in the LinkedList
        for (int i = 0; i < n; i++) {
            System.out.print("Enter subject " + (i + 1) + ": ");
            String subject = scanner.next();
            subjects.add(subject);
        }
        
        // Displaying the subject names using the Iterator interface
        Iterator<String> iterator = subjects.iterator();
        System.out.println("The list of subjects entered by the user:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        
        scanner.close();
    }

}
