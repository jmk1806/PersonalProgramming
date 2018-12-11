package transcription;

public class GeneticDecoder {
	private static final String[] TerminationCodons = { "UAA", "UAG", "UGA" };
	public enum InputType { DNA, mRNA }

	public static Boolean baseOnly(String input, InputType type) { // type 1 : 전사(transcript), type 2 : 번역(translate)
		if(type.equals(InputType.DNA)) {
			for (int i = 0; i < input.length(); i++)
				if (!(input.charAt(i) == 'A' || input.charAt(i) == 'G' || input.charAt(i) == 'C' || input.charAt(i) == 'T'))
					return false;
		}
		else {
			for (int i = 0; i < input.length(); i++)
				if (!(input.charAt(i) == 'A' || input.charAt(i) == 'G' || input.charAt(i) == 'C' || input.charAt(i) == 'U'))
					return false;
		}
		
		return true;
	}
	private static int findInitCodonIdx(String input) { return input.indexOf("AUG"); }
	private static int findTermCodonIdx(String input) {
		int idx = -1;

		for (String codon : TerminationCodons) {
			int temp = input.indexOf(codon);
			if(idx == -1) idx = temp;
			else if(temp != -1 && temp < idx) idx = temp;
		}
		return idx;
	}
	
	public static String convert(String input, InputType type) {
		if(!baseOnly(input, type)) return "Invalid Input";
		
		StringBuilder builder = new StringBuilder();
			for (int i = 0; i < input.length(); i++)
				switch (input.charAt(i)) {
					case 'A': builder.append('U'); break;
					case 'G': builder.append('C'); break;
					case 'C': builder.append('G'); break;
					case 'T': case 'U': builder.append('A'); break;
				}
		input = builder.toString();
		return input;
	}
	
	private static String codon(String code) {
		switch (code) {
			case "AAA": case "AAG": return "라이신";
			case "AAC": case "AAU": return "아스파라긴";
			//AA*
			case "AGA": case "AGG": return "아르지닌";
			case "AGC": case "AGU": return "세린";
			//AG*
			case "ACA": case "ACG": case "ACC": case "ACU": return "트레오닌";
			//AC*
			case "AUA": case "AUC": case "AUU": return "아이소류신";
			case "AUG": return "메싸이오닌(개시)";
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
			case "UAA": case "UAG": return "(종결)";
			case "UAC": case "UAU": return "타이로신";
			//UA*
			case "UGA": return "(종결)";
			case "UGG": return "트립토판";
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
	
	public static String decode(String input){
		input = convert(input, InputType.mRNA);
		
		int initCodonIdx = findInitCodonIdx(input);
		int termCodonIdx = findTermCodonIdx(input);
		
		if(initCodonIdx == -1 || termCodonIdx == -1) return "InValid Input\n";
		
		input = input.substring(initCodonIdx, termCodonIdx + 3);
		
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < input.length(); i += 3) {
			builder.append(codon(input.substring(i, i + 3)));
			if(i < input.length() - 3) builder.append('-'); 
		}
		return builder.toString();
	}
}
