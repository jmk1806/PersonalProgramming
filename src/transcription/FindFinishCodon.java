package transcription;

public class FindFinishCodon {
	FindFinishCodon(String [] token){
		for(int i = 0; i < token.length; i++) {
			if(token.equals("UAA")||token.equals("UAG")||token.equals("UGA")) whereEnd = i;
			else whereEnd = -1;
		}
	}
}