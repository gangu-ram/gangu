import java.util.Scanner;

class VowelPrinter implements Runnable {
    private String inputString;

    VowelPrinter(String inputString) {
        this.inputString = inputString;
    }

    public void run() {
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (isVowel(c)) {
                System.out.println(c);
                try {
                    Thread.sleep(3000); // wait for 3 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        Thread vowelPrinterThread = new Thread(new VowelPrinter(inputString));
        vowelPrinterThread.start();
    }
}
