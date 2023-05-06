import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NumberDisplay implements Runnable, ActionListener {

    private JTextField textField;
    private JButton button;
    private boolean running;

    public NumberDisplay(JTextField textField, JButton button) {
        this.textField = textField;
        this.button = button;
        this.running = false;
    }

    public void run() {
        running = true;
        for (int i = 1; i <= 100 && running; i++) {
            final String text = Integer.toString(i);
            textField.setText(text);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        running = false;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            if (running) {
                running = false;
            } else {
                Thread thread = new Thread(this);
                thread.start();
            }
        }
    }

    public static void main(String[] args) {
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Start/Stop");

        NumberDisplay numberDisplay = new NumberDisplay(textField, button);

        button.addActionListener(numberDisplay);

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(button);

        JFrame frame = new JFrame("Number Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}
