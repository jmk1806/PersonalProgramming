package transcription;

public class FindTerminationCodon {
	private MainFrame mainFrame;
	FindTerminationCodon(MainFrame mainFrame, String [] token){
		this.mainFrame = mainFrame;
		for(int i = 0; i < token.length; i++) {
			if(token.equals("UAA")||token.equals("UAG")||token.equals("UGA")) mainFrame.whereEnd = i;
			else mainFrame.whereEnd = -1;
		}
	}
}
