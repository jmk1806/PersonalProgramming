package transcription;

public class FindStartCodon {
	FindStartCodon(String [] token){
		for(int i = 0; i < token.length; i++) {
			if(token.equals("AUG")) whereStart = i; // 개시코돈 : AUG 찾기
			else whereStart = -1;
		}
	}
}
