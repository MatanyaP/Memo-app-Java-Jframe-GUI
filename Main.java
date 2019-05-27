package Q2;

import java.io.IOException;

import javax.swing.*;



public class Main {

	public static void main(String [] args) throws IOException {
		JFrame frame = new JFrame("q2"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		View panel = new View();
		frame.add(panel);
		
		frame.setSize(400,400);
		frame.setVisible(true);
	}
}
