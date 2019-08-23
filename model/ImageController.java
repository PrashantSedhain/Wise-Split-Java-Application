package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ImageController {
	
	public ArrayList <String> images;
	public ArrayList <String> roommateNames;
	
	public ArrayList <String> addImages(String fileName)
	{
		images = new ArrayList<>();
		roommateNames = new ArrayList<>();
		File file = new File(fileName);
		
			try {
				Scanner input = new Scanner(file);
				String[] tokens = null;
				
				while(input.hasNextLine())
				{
					String line = input.nextLine();
					tokens = line.split(",");
					roommateNames.add(tokens[0]);
					images.add(tokens[1]);
						
				}
				
					input.close();
				}
			
				catch (FileNotFoundException e) {
				e.printStackTrace();
				}	
			
			return images;
			
			
	}

	

}
