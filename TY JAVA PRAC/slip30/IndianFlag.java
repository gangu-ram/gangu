import javax.swing.*;
import java.awt.*;

public class IndianFlag extends JFrame {
    public IndianFlag() {
        setTitle("Indian Flag");
        setSize(500, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
       
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 300);

        
        g.setColor(Color.GREEN);
        g.fillRect(100, 50, 300, 50);

       
        g.setColor(Color.WHITE);
        g.fillRect(100, 100, 300, 50);

        
        g.setColor(new Color(255, 128, 0));
        g.fillRect(100, 150, 300, 50);

        
        g.setColor(Color.BLUE);
        g.fillOval(200, 75, 100, 100);
    }

    public static void main(String[] args) {
        IndianFlag flag = new IndianFlag();
    }
}
