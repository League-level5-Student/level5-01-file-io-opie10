package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	JFrame jf;
	JPanel jp;
	JButton addButton;
	JButton viewButton;
	JButton removeButton;
	JButton saveButton;
	JButton loadButton;
	ArrayList<String> list = new ArrayList<String>();
	String fileName = "defaultList";
	String openFile = "";

	public static void main(String[] args) {
		new ToDoList().setup();
		// all the jbutton setup

		// stuff for each

	}

	public void setup() {
		jf = new JFrame();
		jp = new JPanel();
		addButton = new JButton();
		viewButton = new JButton();
		removeButton = new JButton();
		saveButton = new JButton();
		loadButton = new JButton();
		loadButton.setText("Load List");
		addButton.setText("Add Task");
		removeButton.setText("Remove Task");
		saveButton.setText("Save List");
		viewButton.setText("View Current List");

		jp.add(loadButton);
		jp.add(saveButton);
		jp.add(addButton);
		jp.add(removeButton);
		jp.add(viewButton);
		jf.setTitle("To Do List");
		jf.add(jp);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300, 300);
		addButton.addActionListener(this);
		viewButton.addActionListener(this);
		saveButton.addActionListener(this);
		loadButton.addActionListener(this);
		removeButton.addActionListener(this);
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/config.txt"));

			openFile = br.readLine();
			br.close();
			BufferedReader bz = new BufferedReader(new FileReader(openFile));
			String line = "";
			while (line != null) {
				line = bz.readLine();
				if (line != null) {

					list.add(line);
				}
			}
			bz.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save
	 * list, and load list.
	 *
	 * When add task is clicked: Create a JOptionPane to ask the user for a task and
	 * add it to an ArrayList
	 * 
	 * When the view tasks button is clicked: show all the tasks in the list
	 * 
	 * When the remove task button is clicked: Create a JOptionPane to prompt the
	 * user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked: Save the list to a file
	 * 
	 * When the load list button is clicked: Create a JOptionPane to Prompt the user
	 * for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file
	 * into the list.
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == loadButton) {
			list.clear();
			JOptionPane.showMessageDialog(null, "Please input file location");
			JFileChooser jfc = new JFileChooser();
			int returnVal = jfc.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				fileName = jfc.getSelectedFile().getAbsolutePath();

			}
			try {
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				String line = "";
				while (line != null) {
					line = br.readLine();
					if (line != null) {

						list.add(line);
					}
				}
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		} else if (e.getSource() == addButton) {
			String inputAdd = JOptionPane.showInputDialog("Input task to add to list");
			list.add(inputAdd);
		} else if (e.getSource() == removeButton) {
			String inputRemove = JOptionPane.showInputDialog("Input task to remove from the list");
			list.remove(inputRemove);
		} else if (e.getSource() == saveButton) {

			fileName = JOptionPane.showInputDialog("Name your file");
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/config.txt");

				fw.write("src/_03_To_Do_List/" + fileName + ".txt");

				fw.close();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/" + fileName + ".txt", true);
				for (int i = 0; i < list.size(); i++) {
					fw.write(list.get(i) + "\n");
				}
				fw.close();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Saved!");
		} else if (e.getSource() == viewButton) {
			String viewList = "";
			for (int i = 0; i < list.size(); i++) {
				viewList += "\n" + (i + 1) + ": " + list.get(i);
			}
			JOptionPane.showMessageDialog(null, "Current To Do List:" + viewList);
		}
	}
}
 //Copyright © 2024 Augie Keatinge