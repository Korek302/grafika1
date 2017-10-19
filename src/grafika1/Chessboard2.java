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
		BufferedImage image2;
		
		int x_res;
		int y_res;
		
		int x_res1;
		int y_res1;
		
		int color1;
		int color2;
		
		int i;
		int j;
		
		int angle = 30;
		
		int w = 50;
		
		x_res = 400;
		y_res = 400;
		
		x_res1 = (int)  Math.sqrt(2*x_res*x_res) * 2;
		y_res1 = (int)  Math.sqrt(2*y_res*y_res) * 2;
		
		
		
		image = new BufferedImage(x_res1, y_res1, BufferedImage.TYPE_INT_RGB);
		image2 = new BufferedImage(x_res1, y_res1, BufferedImage.TYPE_INT_RGB);
		
		color1 = int2RGB(0, 0, 0);
		color2 = int2RGB(255, 255, 255);
		
		for(i = 0; i < y_res1; i++)
			for(j = 0; j < x_res1; j++)
			{
				if((i/(w/5)) % 10 < 5)
				{
					if((j/(w/5)) % 10 < 5)
						image.setRGB(j, i, color1);
					else
						image.setRGB(j, i, color2);
				}
				else
				{
					if((j/(w/5)) % 10 > 4)
						image.setRGB(j, i, color1);
					else
						image.setRGB(j, i, color2);
				}
			}
		
		for(i = 0; i < y_res1; i++)
			for(j = 0; j < x_res1; j++)
			{
				try
				{
					image2.setRGB(j, 
							i, 
							image.getRGB(rotate45x(j, i, x_res1/2, y_res1/2, angle), 
									rotate45y(j, i, x_res1/2, y_res1/2, angle)));
				}
				catch(ArrayIndexOutOfBoundsException e)
				{
					
				}
			}
		
		
		image2 = image2.getSubimage((x_res1-x_res)/2, (y_res1-y_res)/2, x_res, y_res);
		
		try
		{
			ImageIO.write(image2, "bmp", new File("chessboard2.bmp"));
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
	
	static int rotate45x(int x1, int y1, int x2, int y2, int angle)
	{
		double angleRad = Math.PI/180 * angle;
		
		return (int) Math.round(((x1 - x2)*Math.cos(angleRad) - (y1 - y2)*Math.sin(angleRad) + x2));
	}
	
	static int rotate45y(int x1, int y1, int x2, int y2, int angle)
	{
		double angleRad = Math.PI/180 * angle;
		
		return (int) Math.round(((x1 - x2)*Math.sin(angleRad) + (y1 - y2)*Math.cos(angleRad) + y2));
	}
}
