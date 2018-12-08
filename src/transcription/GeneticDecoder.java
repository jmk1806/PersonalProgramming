package transcription;

public class GeneticDecoder {
	private static final String[] TerminationCodons = { "UAA", "UAG", "UGA" };
	private int startIndex, endIndex;
	private String input;

	public GeneticDecoder() {}

	public void setInputValue(String input) { this.input = input.toUpperCase(); }

	private Boolean isValid() {
		if (input == null) return false; //input값이 지정되지 않은 상태이면 유효하지 않음
		if (!onlyAGCT()) return false; //AGCT 이외의 문자 포함할 시 유효하지 않음
		if ((startIndex = findInitCodonIdx()) == -1) return false; //개시 코돈 없을 시 유효하지 않음
		if ((endIndex = findTermCodonIdx()) == -1) return false; //종결 코돈 없을 시 유효하지 않음
		
		return true;
	}
	private Boolean onlyAGCT() {
		for (int i = 0; i < input.length(); i++)
			if (!(input.charAt(i) == 'A' || input.charAt(i) == 'G' || input.charAt(i) == 'C' || input.charAt(i) == 'T'))
				return false;
		
		return true;
	}
	private int findInitCodonIdx() { return input.indexOf("AUG"); }
	private int findTermCodonIdx() {
		int idx = -1;

		for (String codon : TerminationCodons) {
			int temp = input.indexOf(codon);
			if (temp != -1 && temp < idx)
				idx = temp;
		}

		return idx;
	}
	
	private void transcript() {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < input.length(); i++)
			switch (input.charAt(i)) {
				case 'A': builder.append('U'); break;
				case 'G': builder.append('C'); break;
				case 'C': builder.append('G'); break;
				case 'T': builder.append('A'); break;
			}

		input = builder.toString();
	}
	
	private String codon(String code) {
		switch (code) {
			case "AAA": 
			case "AAG": return "라이신";
			case "AAC": case "AAU": return "아스파라긴";
			//AA*
			case "AGA": case "AGG": return "아르지닌";
			case "AGC": case "AGU": return "세린";
			//AG*
			case "ACA": case "ACG": case "ACC": case "ACU": return "트레오닌";
			//AC*
			case "AUA": case "AUC": case "AUU": return "아이소류신";
			case "AUG": return "메싸이오닌";
			//AU*
			//A**
			case "GAA": case "GAG": return "글루탐산";
			case "GAC": case "GAU": return "아스파트산";
			//GA*
			case "GGA": case "GGG": case "GGC": case "GGU": return "글라이신";
			//GG*
			case "GCA": case "GCG": case "GCC": case "GCU": return "알라닌";
			//GC*
			case "GUA": case "GUG": case "GUC": case "GUU": return "발린";
			//GU*
			//G**
			case "CAA": case "CAG": return "글루타민";
			case "CAC": case "CAU": return "히스티딘";
			///CA*
			case "CGA": case "CGG": case "CGC": case "CGU": return "아르지닌";
			//CG*
			case "CCA": case "CCG": case "CCC": case "CCU": return "프롤린";
			//CC*
			case "CUA": case "CUG": case "CUC": case "CUU": return "류신";
			//CU*
			//C**
			case "UAA": case "UAG": return "종결";
			case "UAC": case "UAU": return "타이로신";
			//UA*
			case "UGA": return "종결";
			case "UGG": return "트립토핀";
			case "UGC": case "UGU": return "시스테인";
			//UG*
			case "UCA": case "UCG": case "UCC": case "UCU": return "세린";
			//UC*
			case "UUA": case "UUG": return "류신";
			case "UUC": case "UUU": return "페닐알라닌";
			//UU*
			//U**
			default: return "";
		}
	}
	
	public String decode() throws Exception {
		if (!isValid())
			throw new Exception("Invalid input");

		input = input.substring(startIndex, endIndex + 2);
		transcript();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < input.length(); i += 3) {
			builder.append(codon(input.substring(i, i + 2)));
			if(i != input.length() - 1) builder.append('-'); 
		}
		return builder.toString();
	}
}
