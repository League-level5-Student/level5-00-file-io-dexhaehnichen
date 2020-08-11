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
		
		//System.out.println(sb.length());
		for (int i = 0; i < sb.length(); i++) {	
		//	System.out.println(i);
			sb.replace(i, i+1, shift(sb.charAt(i), key));
			System.out.println(sb.charAt(i));
		}
		
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/file.txt");
			fw.write(sb.toString());
			fw.write("\n"+Integer.toString(key));
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String shift(char c, int key) {
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
						   'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
						   'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'k', 'L', 'M',
						   'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		for (int i = 0; i < alphabet.length; i++) {
			if(!Character.isAlphabetic(c)) {
				return Character.toString(c);
			}else if(c == alphabet[i]) {
				if(i + key >= 26) {
					return Character.toString(alphabet[i+key-26]);
				}else {
					return Character.toString(alphabet[i+key]);
				}
			}
		}
		return "&";
	}
}
