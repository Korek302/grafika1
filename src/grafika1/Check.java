package grafika1;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class Check
{
	public static void main(String[] args)
	{
		System.out.println("Check pattern synthesis");
		
		BufferedImage image;
		
		int x_res;
		int y_res;
		
		int colorBack;
		int colorCheck;
		
		int checkWidth;
		
		int i;
		int j;
		
		checkWidth = 30;
		
		x_res = 400;
		y_res = 400;
		
		image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		
		colorBack = int2RGB(0, 0, 0);
		colorCheck = int2RGB(255, 255, 255);

		int temp = 10 - (checkWidth / 10);
		
		for(i = 0; i < y_res; i++)
			for(j = 0; j < x_res; j++)
			{
				
				if((i/5) % 10 < temp && (j/5) % 10 < temp)
					image.setRGB(j, i, colorCheck);
				else
					image.setRGB(j, i, colorBack);
				
				
			}
		try
		{
			ImageIO.write(image, "bmp", new File("check.bmp"));
			System.out.println("Check image created successfully");
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
