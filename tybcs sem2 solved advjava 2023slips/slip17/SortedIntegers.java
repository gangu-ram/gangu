import java.util.*;

public class SortedIntegers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int n = input.nextInt();

        Set<Integer> set = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter integer #" + i + ": ");
            int num = input.nextInt();
            set.add(num);
        }

        System.out.println("Sorted integers:");
        for (int num : set) {
            System.out.println(num);
        }
    }
}
