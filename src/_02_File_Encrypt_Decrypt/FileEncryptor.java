package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

public class FileEncryptor {
	public static void main(String[] args) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String encode = JOptionPane.showInputDialog("Input Message");
		int key = Integer.parseInt(JOptionPane.showInputDialog("Input key"));
		int keyTurn = 0;
		String encoded = "";
		for (int i = 0; i < encode.length(); i++) {
			for (int j = 0; j < alphabet.length()-1; j++) {
				
				if (encode.charAt(i)==alphabet.charAt(j)) {
					if (j+key>alphabet.length()-1) {
						keyTurn =key-( alphabet.length()-j);
						encoded =encoded+ alphabet.charAt(keyTurn);
					}
					else {
					encoded = encoded +alphabet.charAt(j+key);
				}
				}
			}
		}
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/Encrypted.txt");
			fw.write(encoded);
			fw.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
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
	
	
}
 //Copyright © 2024 Augie Keatinge