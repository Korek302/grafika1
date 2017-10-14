package grafika1;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class FadedPicuresCircle
{
	public static void main(String[] args)
	{
		System.out.println("Ring pattern synthesis");
		
		BufferedImage image;
		BufferedImage importedImage1;
		BufferedImage importedImage2;
		
		int x_res;
		int y_res;
		
		int x_c;
		int y_c;
		
		int colorBack;
		int colorFront;
		
		int i;
		int j;
		
		final int w = 50;
		
		x_res = 400;
		y_res = 400;
		
		image = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		importedImage1 = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		importedImage2 = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		
		try
		{
			importedImage1 = ImageIO.read(new File("cat1.bmp"));
			importedImage2 = ImageIO.read(new File("dog1.bmp"));
		}
		catch (IOException e)
		{
			System.out.println("The image cannot be loaded");
		}
		
		x_c = x_res/2;
		y_c = y_res/2;
		
		for(i = 0; i < y_res; i++)
			for(j = 0; j < x_res; j++)
			{
				double d;
				double temp;
				colorBack = importedImage1.getRGB(j, i);
				colorFront = importedImage2.getRGB(j, i);
				
				d = Math.sqrt((i-y_c)*(i-y_c) + (j-x_c)*(j-x_c));
				
				temp = (int)(127*(Math.sin((Math.PI * d)/w) + 1));
				
				image.setRGB(j, i, int2RGB(
						(int)((temp/255) * (getRed(colorBack)) + ((1 - temp/255) * getRed(colorFront))), 
						(int)((temp/255) * (getGreen(colorBack)) + ((1 - temp/255) * getGreen(colorFront))), 
						(int)((temp/255) * (getBlue(colorBack)) + ((1 - temp/255) * getBlue(colorFront)))));
			}
		try
		{
			ImageIO.write(image, "bmp", new File("fadedPicuresCircle.bmp"));
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
	
	static int getRed(int rgb)
	{
		return (rgb >> 16) & 0xFF;
	}
	
	static int getGreen(int rgb)
	{
		return (rgb >> 8) & 0xFF;
	}
	
	static int getBlue(int rgb)
	{
		return rgb & 0xFF;
	}
}
