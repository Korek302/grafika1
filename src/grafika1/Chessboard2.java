package grafika1;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Chessboard2
{
	public static void main(String[] args)
	{
		System.out.println("Chessboard pattern synthesis");
		
		BufferedImage image;
		
		int x_res;
		int y_res;
		
		int color1;
		int color2;
		
		int i;
		int j;
		
		x_res = 500;
		y_res = 500;
		
		image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		
		color1 = int2RGB(0, 0, 0);
		color2 = int2RGB(255, 255, 255);
		
		for(i = 0; i < y_res; i++)
			for(j = 0; j < x_res; j++)
			{
				if((i/10) % 10 < 5)
				{
					if((j/10) % 10 < 5)
						image.setRGB(j, i, color1);
					else
						image.setRGB(j, i, color2);
				}
				else
				{
					if((j/10) % 10 > 4)
						image.setRGB(j, i, color1);
					else
						image.setRGB(j, i, color2);
				}
			}
		try
		{
			ImageIO.write(image, "bmp", new File("chessboard2.bmp"));
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
