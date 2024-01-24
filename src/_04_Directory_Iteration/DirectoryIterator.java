package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		
		
		File directory = new File("/Users/augiekeatinge/Desktop/Coding/level5-01-file-io-opie10/src");
		iterateFiles(directory);
		
		}
		
		
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
	
	public static void iterateFiles(File directory) {
		
		File[] files = directory.listFiles();
		if(files != null) {
			for(File f : files) {
				if (f.isDirectory()) {
					iterateFiles(f.getAbsoluteFile());
				}
				else if(f.getName().contains(".java")){
				try {
					FileWriter fw = new FileWriter(f.getAbsoluteFile(),true);
					fw.write("//Copyright © 2024 Augie Keatinge");
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				}
			
			}}
	}
}
 //Copyright © 2024 Augie Keatinge