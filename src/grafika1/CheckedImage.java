package grafika1;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class CheckedImage
{
	public static void main(String[] args)
	{
		System.out.println("Check pattern synthesis");
		
		BufferedImage importedImage;
		
		int x_res;
		int y_res;
		
		int colorBack;
		int colorCheck;
		
		int checkWidth = 30;
		
		int whiteWidthX = 50;
		int whiteWidthY = 50;
		
		int i;
		int j;
		
		x_res = 400;
		y_res = 400;
		
		importedImage = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		try
		{
			importedImage = ImageIO.read(new File("cat1.bmp"));
		}
		catch (IOException e)
		{
			System.out.println("The image cannot be loaded");
		}
		
		colorBack = int2RGB(255, 255, 255);
		colorCheck = int2RGB(0, 0, 0);
		
		for(i = 0; i < y_res; i++)
			for(j = 0; j < x_res; j++)
			{
				colorBack = importedImage.getRGB(j, i);
				
				
				if((i/5) % 10 < 8 && (j/5) % 10 < 8)
					importedImage.setRGB(j, i, colorBack);
				else
					importedImage.setRGB(j, i, colorCheck);
				
				
			}
		try
		{
			ImageIO.write(importedImage, "bmp", new File("checkedImage.bmp"));
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
