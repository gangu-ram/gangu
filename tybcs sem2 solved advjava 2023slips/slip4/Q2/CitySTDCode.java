import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CitySTDCode {
    public static void main(String[] args) {
        Map<String, Integer> cityMap = new HashMap<>(); // HashMap to store city names and STD codes
        Scanner input = new Scanner(System.in);
        int option;

        do {
            
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a city and its code");
            System.out.println("2. Remove a city");
            System.out.println("3. Search for a city and display its code");
            System.out.println("4. Exit");
            System.out.print("Option: ");
            option = input.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter city name: ");
                    String cityName = input.next();
                    if (cityMap.containsKey(cityName)) {
                        System.out.println(cityName + " already exists in the collection.");
                    } else {
                        System.out.print("Enter STD code: ");
                        int stdCode = input.nextInt();
                        cityMap.put(cityName, stdCode);
                        System.out.println(cityName + " and its code " + stdCode + " have been added to the collection.");
                    }
                    break;
                case 2:
                    
                    System.out.print("Enter city name to remove: ");
                    cityName = input.next();
                    if (cityMap.containsKey(cityName)) {
                        int stdCode = cityMap.remove(cityName);
                        System.out.println(cityName + " and its code " + stdCode + " have been removed from the collection.");
                    } else {
                        System.out.println(cityName + " does not exist in the collection.");
                    }
                    break;
                case 3:
                    
                    System.out.print("Enter city name to search: ");
                    cityName = input.next();
                    if (cityMap.containsKey(cityName)) {
                        int stdCode = cityMap.get(cityName);
                        System.out.println(cityName + " has the STD code " + stdCode + ".");
                    } else {
                        System.out.println(cityName + " does not exist in the collection.");
                    }
                    break;
                case 4:
                    
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        } while (option != 4);

        input.close();
    }
}
