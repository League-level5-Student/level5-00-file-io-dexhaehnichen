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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
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

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton view = new JButton("View Tasks");
	JButton add = new JButton("Add Task");
	JButton remove = new JButton("Remove Task");
	JButton save = new JButton("Save Tasks");
	JButton load = new JButton("Load Tasks");
	ArrayList<String> taskList = new ArrayList<String>();
	String saveLocation = "src\\_03_To_Do_List\\save.txt";
	
	public static void main(String[] args) {
		ToDoList tdl = new ToDoList();
		tdl.run();
	}
	
	
	void run() {
		initializeUI();
		try {
			BufferedReader br = new BufferedReader(new FileReader("src\\_03_To_Do_List\\location.txt"));
			String line = br.readLine();
			if (line != null) {
				saveLocation = line;
			}
			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		load(saveLocation);
	}

	void initializeUI() {
		frame.add(panel);
		panel.add(view);
		panel.add(add);
		panel.add(remove);
		panel.add(save);
		panel.add(load);

		view.addActionListener(this);
		add.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);

		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == view) {
			JOptionPane.showMessageDialog(null, "Your Tasks Are: " + taskList.toString());
		} else if (e.getSource() == add) {
			taskList.add(JOptionPane.showInputDialog("Add Task:"));
		} else if (e.getSource() == remove) {
			taskList.remove(
					Integer.parseInt(JOptionPane.showInputDialog("Which number task would you like to remove?")));
		} else if (e.getSource() == save) {
			save(JOptionPane.showInputDialog("Where would you like to save the task list?"));
		} else if (e.getSource() == load) {
			load(JOptionPane.showInputDialog("Where would you like to load the task list from?"));
		}
	}

	void save(String location) {
		try {
			FileWriter fw = new FileWriter(location);
			
			FileWriter locW = new FileWriter("src\\_03_To_Do_List\\location.txt");
			locW.write(location);
			
			for (int i = 0; i < taskList.size(); i++) {
				fw.write(taskList.get(i) + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void load(String location) {
		taskList.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(location));

			String line = br.readLine();
			while (line != null) {
				taskList.add(line);
				line = br.readLine();
			}

			br.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



//Copyright © 2019 FirstName LastName