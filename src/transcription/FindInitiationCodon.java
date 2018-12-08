package transcription;

public class FindInitiationCodon {
	private MainFrame mainFrame;
	FindInitiationCodon(MainFrame mainFrame, String [] token){
		this.mainFrame = mainFrame;
		for(int i = 0; i < token.length; i++) {
			if(token.equals("AUG")) mainFrame.whereStart = i; // 개시코돈 : AUG 찾기
			else mainFrame.whereStart = -1;
		}
	}
}
