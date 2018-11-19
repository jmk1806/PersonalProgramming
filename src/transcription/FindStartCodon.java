package transcription;

public class FindStartCodon {
	FindStartCodon(String [] token){
		for(int i = 0; i < token.length; i++) {
			if(token.equals("AUG")) whereStart = i;
			else whereStart = -1;
		}
	}
}
