import java.util.*;

public class TreeSetDemo {
    public static void main(String[] args) {
        // Create a TreeSet to hold colors
        Set<String> colors = new TreeSet<>();

        // Add some colors to the TreeSet
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("Purple");
        colors.add("Orange");

        // Print out the contents of the TreeSet in ascending order
        System.out.println("Colors in ascending order:");
        for (String color : colors) {
            System.out.println(color);
        }
    }
}
