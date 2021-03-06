package grafika1;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Chessboard1
{
	public static void main(String[] args)
	{
		System.out.println("Chessboard pattern synthesis");
		
		BufferedImage image;
		
		int x_res;
		int y_res;
		
		int black;
		int white;
		
		int i;
		int j;
		
		int w = 50;
		
		x_res = 400;
		y_res = 400;
		
		image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		
		black = int2RGB(0, 0, 0);
		white = int2RGB(255, 255, 255);
		
		for(i = 0; i < y_res; i++)
			for(j = 0; j < x_res; j++)
			{
				if((i/(w/5)) % 10 < 5)
				{
					if((j/(w/5)) % 10 < 5)
						image.setRGB(j, i, black);
					else
						image.setRGB(j, i, white);
				}
				else
				{
					if((j/(w/5)) % 10 > 4)
						image.setRGB(j, i, black);
					else
						image.setRGB(j, i, white);
				}
			}
		try
		{
			ImageIO.write(image, "bmp", new File("chessboard1.bmp"));
			System.out.println("Chessboard image created successfully");
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
