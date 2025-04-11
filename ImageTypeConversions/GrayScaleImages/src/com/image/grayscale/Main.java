package com.image.grayscale;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author TW MANHEMA
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String userInput = "";
		
		System.out.println("Input the name of the image file(include extension): ");
		userInput = input.nextLine();
		input.close();
		
		//loading the image and specifying the directory for grayscale image
		File originalImage = new File("Original_Colored_Images/" + userInput);
		File grayScaleDir = new File("Gray_Scale_Images/gray" + userInput);
		try {
			ImageTypeConvert.convertToGrayScale(originalImage, grayScaleDir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
