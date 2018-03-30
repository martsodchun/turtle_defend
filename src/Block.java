import java.awt.*;

import javax.swing.ImageIcon;

public class Block extends Rectangle {
	public boolean isBuildZone = false;
	public boolean isStreet = false;

	
	public static Image[] BStreet = new Image[100];
	public static Image[] BBuildZone = new Image[100];

	public Block(int x, int y, int width, int height) {
		setBounds(x, y, width, height);

		for(int i = 0;i < BStreet.length;i++) {
			BStreet[i] = new ImageIcon("data/block/hardened_clay.png").getImage();
		}

		for(int i = 0;i < BBuildZone.length;i++) {
			BBuildZone[i] = new ImageIcon("data/block/stonebrick.png").getImage();
		}
	}

	public void draw(Graphics g) {
		/* g.drawRect(x, y, width, height); */
		
		if (isBuildZone) {
			g.drawImage(BBuildZone[0], x, y, width, height, null);
		}
		
		if (isStreet) {
			g.drawImage(BStreet[0], x, y, width, height, null);
		}
	}
}
