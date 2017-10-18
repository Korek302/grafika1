package grafika1;

import java.io.*;
import java.awt.image.*;
import javax.imageio.*;

public class ImagePizzaMerge
{
	public static void main(String[] args)
	{
System.out.println("Pizza pattern synthesis");
		
		BufferedImage importedImage1;
		BufferedImage importedImage2;
		
		int x_res;
		int y_res;
		
		int x_c;
		int y_c;
		
		int color1;
		int color2;
		
		int i;
		int j;
		
		final double w = Math.PI/8;
		
		x_res = 400;
		y_res = 400;
		
		importedImage1 = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		importedImage2 = new BufferedImage(x_res, y_res, BufferedImage.TYPE_INT_RGB);
		try
		{
			importedImage1 = ImageIO.read(new File("cat2.bmp"));
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
				int r;
				double alpha;
				
				color1 = importedImage1.getRGB(j, i);
				color2 = importedImage2.getRGB(j, i);
				
				d = Math.sqrt((i-y_c)*(i-y_c) + (j-x_c)*(j-x_c));
				
				alpha = Math.asin(Math.abs(x_c - j)/d);
				
				r = (int) (alpha / w);
				
				if(r % 2 == 0)
					if((j > x_c && i > y_c) || (j < x_c && i < y_c))
						;
					else
						importedImage1.setRGB(j, i, color2);
				else
					if((j > x_c && i > y_c) || (j < x_c && i < y_c))
						importedImage1.setRGB(j, i, color2);
			}
		try
		{
			ImageIO.write(importedImage1, "bmp", new File("imagePizzaMerge.bmp"));
			System.out.println("Pizza image created successfully");
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
