import java.awt.*;

import javax.swing.*;

public class Map {
	public int RoomWidth = 12;
	public int RoomHeight = 8;
	public int blockSize = 52;
	public int[][] map;

	public Block[][] block;

	public Map() {
		define();
	}

	public void define() {
		block = new Block[RoomHeight][RoomWidth];
		map = new int[][]{
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
				{0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1},
				{1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1},
				{1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1},
				{1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1},
				{1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1},
				{1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
		};
		for (int row = 0; row < block.length; row++) {
			for (int col = 0; col < block[0].length; col++) {
				block[row][col] = new Block((Screen.scrnWidth/2) - (RoomWidth*blockSize/2) + (col*blockSize), row * blockSize,
						blockSize, blockSize);
				
				if(map[row][col] == 1) block[row][col].isBuildZone = true;
				else if(map[row][col] == 0) block[row][col].isStreet = true;
			}
		}
	}

	public void draw(Graphics g) {
		for (int row = 0; row < block.length; row++) {
			for (int col = 0; col < block[0].length; col++) {
				block[row][col].draw(g);
			}
		}
	}

	public void physics() {

	}

}
