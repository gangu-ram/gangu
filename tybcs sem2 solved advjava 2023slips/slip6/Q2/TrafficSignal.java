import javax.swing.*;
import java.awt.*;

public class TrafficSignal extends JFrame {
    private JPanel panel;

    private final Color RED = Color.RED;
    private final Color YELLOW = Color.YELLOW;
    private final Color GREEN = Color.GREEN;

    private boolean running;

    public TrafficSignal() {
        super("Traffic Signal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(200, 400));
        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void start() {
        running = true;

        Thread thread = new Thread(() -> {
            while (running) {
                setLights(RED, GREEN, false);
                sleep(5000);

                setLights(RED, YELLOW, false);
                sleep(2000);

                setLights(GREEN, RED, false);
                sleep(5000);

                setLights(YELLOW, RED, true);
                sleep(2000);
            }
        });

        thread.start();
    }

    public void stop() {
        running = false;
    }

    private void setLights(Color color1, Color color2, boolean bothOn) {
        SwingUtilities.invokeLater(() -> {
            panel.removeAll();

            JPanel light1 = new JPanel();
            light1.setBackground(color1);
            light1.setPreferredSize(new Dimension(150, 150));
            panel.add(light1);

            if (bothOn) {
                JPanel light2 = new JPanel();
                light2.setBackground(color2);
                light2.setPreferredSize(new Dimension(150, 150));
                panel.add(light2);
            } else {
                JPanel light2 = new JPanel();
                light2.setBackground(Color.BLACK);
                light2.setPreferredSize(new Dimension(150, 150));
                panel.add(light2);
            }

            panel.revalidate();
            panel.repaint();
        });
    }

    private void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TrafficSignal trafficSignal = new TrafficSignal();
        trafficSignal.start();
    }
}
