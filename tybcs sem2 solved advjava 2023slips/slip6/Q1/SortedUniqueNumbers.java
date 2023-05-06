import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SortedUniqueNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<Integer> numbers = new HashSet<>(); 
        int n;

        System.out.print("Enter the number of integers to input: ");
        n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter an integer: ");
            int num = input.nextInt();
            numbers.add(num);
        }

       
        System.out.println("\nSorted unique numbers:");
        Set<Integer> sortedNumbers = new TreeSet<>(numbers); 
        for (int num : sortedNumbers) {
            System.out.print(num + " ");
        }

        
        System.out.print("\nEnter a number to search for: ");
        int searchNum = input.nextInt();
        if (numbers.contains(searchNum)) {
            System.out.println(searchNum + " is present in the collection.");
        } else {
            System.out.println(searchNum + " is not present in the collection.");
        }

        input.close();
    }
}
