package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	
	public static void main(String[] args) {
		int key = Integer.parseInt(JOptionPane.showInputDialog("put key here"));
		String text = JOptionPane.showInputDialog("put text here");
		StringBuilder sb = new StringBuilder(text);
		char temp;
		
		for (int i = 0; i < text.length(); i++) {	
			sb.replace(i, i+1, shift(sb.charAt(i), key));
		}
		
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/file.txt");
			fw.write(sb.toString());
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String shift(char c, int key) {
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
						   'n', 'o', 'p', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
						   'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c', 'd', 'e', 
						   'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'h', 'i',
						   'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
						   'w', 'x', 'y', 'z'};
		
		for (int i = 0; i < alphabet.length; i++) {
			if(c == ' ') {
				return " ";
			}else if(c == alphabet[i]) {
				return Character.toString(alphabet[i+key]);
			}
		}
		return null;
	}
}
