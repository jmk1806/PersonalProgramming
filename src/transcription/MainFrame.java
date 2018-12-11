package transcription;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainFrame extends JFrame{
	MainFrame(){
		setTitle("My Own Transcription Helper Program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		setSize(900,700);
		setLayout(null);
		
		ImageIcon backgroundImg = new ImageIcon("images/DNA.jpg");
				
		Font titleFont = new Font("D2Coding", Font.BOLD, 20);
		Font basicFont = new Font("D2Coding", Font.PLAIN, 14);
		
		JLabel EnterLabel = new JLabel("DNA 혹은 mRNA 입력 후 <Enter> 키를 입력하세요");
		EnterLabel.setFont(titleFont);
		EnterLabel.setBounds(200,20,500,40);
		
		JLabel tripletFirstPrimeLabel = new JLabel("DNA 트리플렛 코드 : 3' - ");
		tripletFirstPrimeLabel.setBounds(20,80,200,40);
		tripletFirstPrimeLabel.setFont(basicFont);
		
		JTextField tripletTokenTField = new JTextField();
		tripletTokenTField.setBounds(200,80,590,40);
		
		JLabel tripletLastPrimeLabel = new JLabel(" - 5' ");
		tripletLastPrimeLabel.setBounds(800,80,100,40);
		tripletLastPrimeLabel.setFont(basicFont);
		
		JLabel codonFirstPrimeLabel = new JLabel("전사 mRNA : 5' - ");
		codonFirstPrimeLabel.setBounds(76,160,200,40);
		codonFirstPrimeLabel.setFont(basicFont);
		
		JTextField codonTokenTField = new JTextField();
		codonTokenTField.setBounds(200,160,590,40);
		
		JLabel codonLastPrimeLabel = new JLabel(" - 3' ");
		codonLastPrimeLabel.setBounds(800,160,100,40);
		codonLastPrimeLabel.setFont(basicFont);
		
		JLabel finalLabel = new JLabel("합성된 단백질 : ");
		finalLabel.setBounds(76,250,200,40);
		finalLabel.setFont(basicFont);
		
		JTextArea finalProtein = new JTextArea();
		finalProtein.setBounds(200,250,260,360);
		
		JLabel imageLabel = new JLabel(backgroundImg);
		imageLabel.setBounds(500,230,270,400);
		
		container.add(EnterLabel);
		container.add(tripletFirstPrimeLabel);
		container.add(tripletTokenTField);
		container.add(tripletLastPrimeLabel);
		container.add(codonFirstPrimeLabel);
		container.add(codonTokenTField);
		container.add(codonLastPrimeLabel);
		container.add(finalLabel);
		container.add(finalProtein);
		container.add(imageLabel);
		
		GeneticDecoder geneticDecoder = new GeneticDecoder();
		
	tripletTokenTField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { // Enter 누르면 Action 이벤트 발생
				JTextField text = (JTextField)e.getSource();
				geneticDecoder.setInputValue(text.getText()); // Input 값 넣어줌
				codonTokenTField.setText(geneticDecoder.transcript());
			}
			
		});
	
	codonTokenTField.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) { // Enter 누르면 Action 이벤트 발생
			JTextField text = (JTextField)e.getSource();
			geneticDecoder.setInputValue(text.getText()); // Input 값 넣어줌
			System.out.print(geneticDecoder.decode());
		}
		
	});
		
		setFocusable(true);
		requestFocus();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainFrame();
	}

}
