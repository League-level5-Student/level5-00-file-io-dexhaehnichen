package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	
	public static void main(String[] args) {
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/file.txt");
			
			fw.write(JOptionPane.showInputDialog("put text here"));
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
