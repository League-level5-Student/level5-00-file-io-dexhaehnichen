package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/* 
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		ArrayList<File> subDirectories = new ArrayList<File>();
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			getSubDirectories(jfc.getSelectedFile());
//			File directory = jfc.getSelectedFile();
//			File[] files = directory.listFiles();
//			if(files != null) {
//				for(File f : files) {
//				  System.out.println(f.getAbsolutePath());
//				}
//			}
		}
		
		
		
		/*
		 * Your task is to write a program that iterates through the src folder of this current Java Project. 
		 * For every .java file it finds, the program will add a (non-legally binding) copyright statement at the bottom.
		 * Be aware of possible directories inside of directories.
		 * (e.g //Copyright © 2019 FirstName LastName)
		 */
	}
	
	public static void getSubDirectories(File path) {
		File[] files = path.listFiles();
		if(files != null) {
			for(File f : files) {
			  getSubDirectories(f.getAbsoluteFile());
			}
		}else {
			try {
				FileWriter fw = new FileWriter(path.getAbsolutePath(), true);
				fw.write("\n\n\n//Copyright © 2019 FirstName LastName");					
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}



//Copyright © 2019 FirstName LastName