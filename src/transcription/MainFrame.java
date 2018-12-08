package transcription;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class MainFrame extends JFrame{
	MainFrame(){
		int whereStart = 0, whereEnd = 0;
		String token[];
		setTitle("My Own Transcription Helper Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		setSize(800,600);
		setLayout(null);
		
		JLabel fivePrimeLabel = new JLabel("전사 mRNA : 5' - ");
		fivePrimeLabel.setBounds(20,40,100,40);
		JTextField tokenTField = new JTextField();
		tokenTField.setBounds(120,40,600,40);
		JLabel threePrimeLabel = new JLabel(" - 3' ");
		threePrimeLabel.setBounds(730,40,100,40);
		
		container.add(fivePrimeLabel);
		container.add(tokenTField);
		container.add(threePrimeLabel);
		
		FindStartCodon(this, "AUG");
		
		
		setFocusable(true);
		requestFocus();
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainFrame();
	}

}
