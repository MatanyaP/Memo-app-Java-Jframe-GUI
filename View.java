package Q2;

import java.awt.*;

import java.awt.event.*;
import java.io.*;


import javax.swing.*;



public class View extends JPanel{
	private JComboBox<Integer > day;
	private JComboBox<Integer > month;
	private JComboBox<Integer > year;
	private  JTextArea text;
	private DatesMap dates; 
	private JButton save; 
	private JButton show; 
	private JButton loadAllReminders ;
	private JButton saveAllReminders ; 
	
	
	
	private File f; 
	private JButton clearText;
	
	// the program for the grapics
	
	public View() throws IOException {
		Integer [] dayOptions = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		Integer [] monthOptions = {1,2,3,4,5,6,7,8,9,10,11,12};
		Integer [] yearOptions = {2018,2019,2020,2021,2022,2023,2024,2025,2026,2027,2028,2029,2030,
				2031,2032,2033,2034,2035,2036,2037};
		dates = new DatesMap();
		day = new JComboBox<Integer>(dayOptions);
		month = new JComboBox<Integer>(monthOptions);
		year = new JComboBox<Integer>(yearOptions);
		
		saveAllReminders	 = new JButton("save all");
		loadAllReminders = new JButton("load all");
		
		save = new JButton("save");
		show = new JButton("show");
		
		JButton openForFile = new JButton();
		JFileChooser	pickFile = new JFileChooser();
		pickFile.setCurrentDirectory(null);
		pickFile.setDialogTitle("pick file");
		pickFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(pickFile.showOpenDialog(openForFile) == JFileChooser.APPROVE_OPTION) {
			f = pickFile.getSelectedFile();
		}
	
		clearText = new JButton("clear");
		
		listener lis = new listener();
		
		clearText.addActionListener(lis);
		save.addActionListener(lis);
		show.addActionListener(lis);
		saveAllReminders.addActionListener(lis);
		loadAllReminders.addActionListener(lis);
		
		JPanel textBott = new JPanel();
		JPanel dateBot = new JPanel();
		JPanel saveAndLoad = new JPanel();
		JPanel textZone = new JPanel();
		
		
		text = new JTextArea();
		
		
		dateBot.add(day);
		dateBot.add(month);
		dateBot.add(year);
		
	
		saveAndLoad.add(saveAllReminders);
		saveAndLoad.add(loadAllReminders);
	
		textBott.add(save);
		textBott.add(show);
		textBott.add(clearText);
		
	
		
		textZone.setLayout(new BorderLayout());
		textZone.add(text,BorderLayout.CENTER);
		textZone.add(textBott,BorderLayout.SOUTH);
		
		
		
		this.setLayout(new BorderLayout());
		this.add(dateBot,BorderLayout.SOUTH);
		this.add(saveAndLoad, BorderLayout.NORTH);
		this.add(textZone,BorderLayout.CENTER);
		
		
	
		
		
		
		
	}
	private class listener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int d = (int) day.getSelectedItem();
			int m =  (int) month.getSelectedItem();
			int y =  (int) year.getSelectedItem();
			
			// TODO Auto-generated method stub
			if(e.getSource() == clearText) {
				text.setText("");
			}
			if(e.getSource() == save ) {
				Memo temp;
				try {
					temp = new Memo(d,m,y,text.getText());
					dates.add(temp);
				} catch (NoDateException e1) {
					 JOptionPane.showMessageDialog(null, "Invalid date");
					
				}
				
				
			}
			if(e.getSource() == show) {
				Memo temp;
				try {
					temp = new Memo(d,m,y);
					Memo ori = dates.find(temp.hashCode());
					if(ori == null ) {
						text.setText("");
					}
					else {
						text.setText(ori.getTxt());
						
					}
				} catch (NoDateException e1) {
					// TODO Auto-generated catch block
					 JOptionPane.showMessageDialog(null, "Invalid date");
				}
				
				
			}
			if(e.getSource() == saveAllReminders) {
				try {
					writeObject(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			if(e.getSource() == loadAllReminders) {
				try {
					readObject(f);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
			
			
			
		}
		
	}
	
	private void readObject(File f) throws IOException{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(f));
		Memo m ;
	
		try {
			while(true) {
				m = (Memo)in.readObject();
				dates.add(m);
			}
		}catch(EOFException e){
			in.close();
			return; 
		}
		catch(ClassNotFoundException e){
			in.close();
			return;
		}
		
		
	}
	
	private void writeObject(File f) throws  IOException {
	
		dates.saveAll(f);
		
	
		
	}
}
