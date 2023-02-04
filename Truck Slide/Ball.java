import javax.swing.*;
import java.awt.*;

public class Ball extends JFrame {
  public Ball() {
    this.setVisible(true);
    this.setSize(400, 400);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel p1 = new GP();
    this.add(p1);
  }

  public static void main(String args[]) {
    new Ball();
  }
}

class GP extends JPanel implements Runnable {
  int x = 10, y = 80;
  Thread t;
  boolean chk = false;

  public GP() {
    setBackground(Color.pink);
    setForeground(Color.blue);

    t = new Thread(this);
    t.start();
  }

  public void run() {
    while (true) {
      try {
        x = x + 10;
        if (x > 980) {
          x = 10;
          y = 50;
        }
        repaint();
        if (x > 250 && x < 319) {
          Thread.sleep(350);
        } else if (x == 320) {
          Thread.sleep(1000);
        } else {
          Thread.sleep(100);
        }
      }

      catch (Exception ex) {
      }
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.blue);
    g.fillRect(0, 110, 1000, 25);
    g.setColor(Color.red);
    g.fillRect(x, y, 100, 50);

    g.setColor(Color.yellow);
    g.fillRect(x + 100, y + 25, 25, 25);
    g.setColor(Color.black);
    g.fillOval(x + 15, y + 35, 25, 25);
    g.fillOval(x + 45, y + 35, 25, 25);
    g.fillOval(x + 95, y + 35, 25, 25);
    
    g.setColor(Color.black);
    g.fillRect(450, 50, 10, 55);
    if (x > 250 && x < 319) {
      g.setColor(Color.yellow);

    }

    else if (x == 320) {
      g.setColor(Color.red);

    } else {
      g.setColor(Color.green);

    }
    g.fillOval(450, 55, 12, 12);
  }

}