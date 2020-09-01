package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	
	public static void main(String[] args) {
		String text = "";
		int key = 0;
		
			BufferedReader br;
			try {
				br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/file.txt"));
				text = br.readLine();
				key = Integer.parseInt(br.readLine());
			} 		
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		StringBuilder sb = new StringBuilder(text);
		
		//System.out.println(sb.length());
		for (int i = 0; i < sb.length(); i++) {	
		//	System.out.println(i);
			sb.replace(i, i+1, unShift(sb.charAt(i), key));
			System.out.print(sb.charAt(i));
		}
		
		JOptionPane.showMessageDialog(null, "Decrypted Message: " + sb.toString());
	}
	
	public static String unShift(char c, int key) {
		char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
						   'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
						   'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'k', 'L', 'M',
						   'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		for (int i = 0; i < alphabet.length; i++) {
			if(!Character.isAlphabetic(c)) {
				return Character.toString(c);
			}else if(c == alphabet[i]) {
				if(i - key < 0) {
					return Character.toString(alphabet[26-key]);
				}else {
					return Character.toString(alphabet[i-key]);
				}
			}
		}
		return "&";
	}
	
}



//Copyright © 2019 FirstName LastName