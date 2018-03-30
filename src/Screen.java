import java.awt.*;
import java.awt.image.*;

import javax.swing.*;

public class Screen extends JPanel implements Runnable {
	public Thread thread = new Thread(this);

	public static int scrnWidth, scrnHeight;

	public static boolean FisrtTime = true;

	public static Map map1;

	public Screen() {
		thread.start();
	}

	public void paintComponent(Graphics g) {
		if (FisrtTime) {
			define();
			FisrtTime = false;
		}

		g.clearRect(0, 0, getWidth(), getHeight());
		map1.draw(g); // วาดด่าน
	}

	private void define() {
		scrnWidth = getWidth();
		scrnHeight = getHeight();
		map1 = new Map();
	}

	public static int FrameRate = 0, FrameSpeed = 1000000;

	@Override
	public void run() {
		while (true) {
			if (!FisrtTime) {
				map1.physics();
			}

			repaint();

			try {
				thread.sleep(1);
			} catch (Exception e) {

			}
		}
	}
}
