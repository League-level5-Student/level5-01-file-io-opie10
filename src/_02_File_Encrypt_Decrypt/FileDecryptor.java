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
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/Encrypted.txt"));
			
			 line = br.readLine();
			
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		int key = Integer.parseInt(JOptionPane.showInputDialog("Input key"));
		int keyTurn = 0;
		String decoded = "";
		String encoded =line;
		for (int i = 0; i < line.length(); i++) {
			for (int j = 0; j < alphabet.length()-1; j++) {
				if (encoded.charAt(i)==alphabet.charAt(j)) {
					if (j-key>0) {
						decoded=decoded+alphabet.charAt(j-key);
					}
					else {
						
						keyTurn = Math.abs(j-key);
						decoded = decoded+alphabet.charAt((alphabet.length()-1) -keyTurn);
					} 
				}
				
			}
		}
		JOptionPane.showMessageDialog(null, "Decoded message. \nKey: "+key+"\nMessage: "+decoded);
		
		
	}
}
 //Copyright © 2024 Augie Keatinge