package grafika1;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class FadedCircle
{
	public static void main(String[] args)
	{
		System.out.println("Ring pattern synthesis");
		
		BufferedImage image;
		
		int x_res;
		int y_res;
		
		int x_c;
		int y_c;
		
		int black;
		int white;
		
		int i;
		int j;
		
		final int w = 20;
		
		x_res = 400;
		y_res = 400;
		
		image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		
		black = int2RGB(0, 0, 0);
		white = int2RGB(255, 255, 255);
		
		x_c = x_res/2;
		y_c = y_res/2;
		
		for(i = 0; i < y_res; i++)
			for(j = 0; j < x_res; j++)
			{
				double d;
				int r;
				double temp;
				
				d = Math.sqrt((i-y_c)*(i-y_c) + (j-x_c)*(j-x_c));
				
				r = (int) d / w;
				
				temp = (127*(Math.sin((Math.PI * d)/w) + 1));
				
				image.setRGB(j, i, int2RGB((int)temp, (int)temp, (int)temp));
			}
		try
		{
			ImageIO.write(image, "bmp", new File("fadeC.bmp"));
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
