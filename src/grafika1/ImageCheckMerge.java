package grafika1;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class ImageCheckMerge
{
	public static void main(String[] args)
	{
		System.out.println("Check pattern synthesis");
		
		BufferedImage image;
		BufferedImage importedImage1;
		BufferedImage importedImage2;
		
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
		
		colorBack = int2RGB(255, 255, 255);
		colorCheck = int2RGB(0, 0, 0);
		
		for(i = 0; i < y_res; i++)
			for(j = 0; j < x_res; j++)
			{
				colorBack = importedImage1.getRGB(j, i);
				colorCheck = importedImage2.getRGB(j, i);
				
				if((i/5) % 10 < 7 && (j/5) % 10 < 7)
					image.setRGB(j, i, colorBack);
				else
					image.setRGB(j, i, colorCheck);
				
				
			}
		try
		{
			ImageIO.write(image, "bmp", new File("imageCheckMerge.bmp"));
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
