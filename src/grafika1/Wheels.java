package grafika1;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Wheels
{
	public static void main(String[] args)
	{
		System.out.println("Wheels pattern synthesis");
		
		BufferedImage image;
		
		int x_res;
		int y_res;
		
		int x_squares;
		int y_squares;
		
		int x_c;
		int y_c;
		
		int black;
		int gray;
		
		int i;
		int j;
		
		final int squareW = 80;
		
		final double w = 2.5;
		
		x_res = 400;
		y_res = 400;
		
		x_squares = x_res/squareW;
		y_squares = y_res/squareW;
		
		image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		
		black = int2RGB(0, 0, 0);
		gray = int2RGB(180, 180, 180);
		
		for(int m = 0; m < y_squares; m++)
			for(int n = 0; n < x_squares; n++)
				for(i = 0; i < squareW; i++)
					for(j = 0; j < squareW; j++)
					{
						double d;
						
						x_c = n*squareW + squareW/2;
						y_c = m*squareW + squareW/2;
						
						d = Math.sqrt(((squareW*m + i)-y_c)*((squareW*m + i)-y_c) 
								+ ((squareW*n + j)-x_c)*((squareW*n + j)-x_c));
						
						if(d < squareW/w)
							image.setRGB(squareW*n + j, squareW*m + i, black);
						else
							image.setRGB(squareW*n + j, squareW*m + i, gray);
					}
		try
		{
			ImageIO.write(image, "bmp", new File("wheels.bmp"));
			System.out.println("Wheels image created successfully");
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
