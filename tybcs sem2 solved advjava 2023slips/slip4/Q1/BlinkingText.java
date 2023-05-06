import javax.swing.JFrame;
import javax.swing.JLabel;

public class BlinkingText implements Runnable {

    private JLabel label;

    public BlinkingText(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000); // Wait for 1 second
                label.setVisible(!label.isVisible()); // Toggle label visibility
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Blinking Text");

        // Create a JLabel
        JLabel label = new JLabel("Hello World!");

        // Add the JLabel to the JFrame
        frame.add(label);

        // Set the size and location of the JFrame
        frame.setSize(200, 100);
        frame.setLocationRelativeTo(null);

        // Set the JFrame to exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a new instance of BlinkingText and pass the JLabel to it
        BlinkingText blinkingText = new BlinkingText(label);

        // Create a new thread and pass the BlinkingText instance to it
        Thread thread = new Thread(blinkingText);

        // Start the thread
        thread.start();

        // Show the JFrame
        frame.setVisible(true);
    }
}
