package transcription;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame{
	MainFrame(){
		setTitle("My Own Transcription Helper Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,600);
		setFocusable(true);
		requestFocus();
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainFrame();
	}

}
