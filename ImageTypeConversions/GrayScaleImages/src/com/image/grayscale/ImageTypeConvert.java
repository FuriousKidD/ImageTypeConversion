/**
 * 
 */
package com.image.grayscale;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 */
public class ImageTypeConvert {
	
	private static BufferedImage img;
	private static BufferedImage grayImg;
	/**
	 * Constructors takes in a image file
	 * @param img
	 */
	public ImageTypeConvert() {
		img = null;
	}
	
	private static BufferedImage getGrayImg() {
		setGrayImg();
		return grayImg;
	}
	
	/*
	 * Utility function to create and set up the gray scale image
	 */
	private static void setGrayImg() {
		
		//creates a blank, empty grayscale image with the same dimensions as the original one
		grayImg = new BufferedImage(img.getWidth(),
					img.getHeight(),
					BufferedImage.TYPE_INT_ARGB);
		
		//Looping through every pixel of the image row-by-row, col-by-col
		for(int y = 0; y < img.getHeight(); y++) {
			for(int x = 0; x < img.getWidth(); x++) {
				
				//for every pixel, extract the RGB color representation
				Color color = new Color(img.getRGB(x, y));
				
				//From the pixel, extract each individual rgb component
				
				int red = color.getRed();//red component
				int green = color.getGreen();//green component
				int blue = color.getBlue();//blue component
				
				/*
				 * Applying a luminosity formula, which will be used to 
				 * combine the three color channels r g b, into one single
				 * intensity value.
				 * Each channel is weighed based on how the human eye perceives brightness
				 */
				
				int grayPixel = (int)( (0.299 * red) +
												(0.587 * green) +
												(0.114 * blue) );
				
				//creates the new grayScale color representation of the rgb
				Color grayColor = new Color(grayPixel, grayPixel, grayPixel);//r = g = b
				
				//setting the grayScale image into the output image
				grayImg.setRGB(x, y, grayColor.getRGB());
			}//end inner loop
		}//end outter loop
		
	}
	
	/**
	 * Converts a colored image to a grayscale image and saves it to a different folder
	 * Insert the colored image to be converted into a grayScale
	 * @param originalFileDir
	 * @param grayFileDir
	 * @throws IOException 
	 */
	public static void convertToGrayScale(File originalFileDir, File grayFileDir )
														throws IOException {
		img = ImageIO.read(originalFileDir);//load the image to be converted
		
		//Create and save the grayscale image to specified directory
		ImageIO.write(getGrayImg(), "jpg", grayFileDir);
	}
}
