import java.util.Random;

public class MultiThreadApp {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        SquareCalculator squareCalculator = new SquareCalculator(numberGenerator);
        CubeCalculator cubeCalculator = new CubeCalculator(numberGenerator);

        Thread t1 = new Thread(numberGenerator);
        Thread t2 = new Thread(squareCalculator);
        Thread t3 = new Thread(cubeCalculator);

        t1.start();
        t2.start();
        t3.start();
    }
}

class NumberGenerator implements Runnable {
    private Random random = new Random();
    private int number;

    public void run() {
        while (true) {
            number = random.nextInt(100);
            System.out.println("Generated number: " + number);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getNumber() {
        return number;
    }
}

class SquareCalculator implements Runnable {
    private NumberGenerator numberGenerator;

    public SquareCalculator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        while (true) {
            int number = numberGenerator.getNumber();
            if (number % 2 == 0) {
                int square = number * number;
                System.out.println("Square of " + number + ": " + square);
            }
        }
    }
}

class CubeCalculator implements Runnable {
    private NumberGenerator numberGenerator;

    public CubeCalculator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        while (true) {
            int number = numberGenerator.getNumber();
            if (number % 2 != 0) {
                int cube = number * number * number;
                System.out.println("Cube of " + number + ": " + cube);
            }
        }
    }
}
