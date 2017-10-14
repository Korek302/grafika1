package grafika1;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class ManyCircles
{
	public static void main(String[] args)
	{
		System.out.println("Ring pattern synthesis");
		
		BufferedImage image;
		
		int x_res;
		int y_res;
		
		int x_squares;
		int y_squares;
		
		int x_c;
		int y_c;
		
		int black;
		int white;
		
		int i;
		int j;
		
		final int squareW = 50;
		
		final int w = 5;
		
		x_res = 400;
		y_res = 400;
		
		x_squares = x_res/squareW;
		y_squares = y_res/squareW;
		
		image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		
		black = int2RGB(0, 0, 0);
		white = int2RGB(255, 255, 255);
		
		x_c = x_res/2;
		y_c = y_res/2;
		
		
		for(int m = 0; m < y_squares; m++)
			for(int n = 0; n < x_squares; n++)
				for(i = 0; i < squareW; i++)
					for(j = 0; j < squareW; j++)
					{
						double d;
						int r;
						
						x_c = n*squareW + squareW/2;
						y_c = m*squareW + squareW/2;
						
						d = Math.sqrt(((squareW*m + i)-y_c)*((squareW*m + i)-y_c) 
								+ ((squareW*n + j)-x_c)*((squareW*n + j)-x_c));
						
						r = (int) d / w;
						
						if(r % 2 == 0)
							image.setRGB(squareW*n + j, squareW*m + i, black);
						else
							image.setRGB(squareW*n + j, squareW*m + i, white);
					}
		try
		{
			ImageIO.write(image, "bmp", new File("manyCircles.bmp"));
			System.out.println("Ring image created successfully");
		}
		catch(IOException e)
		{
			System.out.println("The image cannot be stored");
		}
	}
	
	static int int2RGB( int red, int green, int blue)
	{
		red = red & 0x000000FF;
		green = green & 0x000000FF;
		blue = blue & 0x000000FF;
		return (red << 16) + (green << 8) + blue;
	}
}
