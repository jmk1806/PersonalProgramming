package transcription;

public class GeneticDecoder {
	private static final String[] TerminationCodons = { "UAA", "UAG", "UGA" };
	private int startIndex, endIndex;
	private String input;

	public GeneticDecoder() {}

	public void setInputValue(String input) { this.input = input.toUpperCase(); }

	private Boolean isValid() {
		if (input == null) return false; //input���� �������� ���� �����̸� ��ȿ���� ����
		if (!onlyAGCT()) return false; //AGCT �̿��� ���� ������ �� ��ȿ���� ����
		if ((startIndex = findInitCodonIdx()) == -1) return false; //���� �ڵ� ���� �� ��ȿ���� ����
		if ((endIndex = findTermCodonIdx()) == -1) return false; //���� �ڵ� ���� �� ��ȿ���� ����
		
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
			case "AAG": return "���̽�";
			case "AAC": case "AAU": return "�ƽ��Ķ��";
			//AA*
			case "AGA": case "AGG": return "�Ƹ�����";
			case "AGC": case "AGU": return "����";
			//AG*
			case "ACA": case "ACG": case "ACC": case "ACU": return "Ʈ������";
			//AC*
			case "AUA": case "AUC": case "AUU": return "���̼ҷ���";
			case "AUG": return "�޽��̿���";
			//AU*
			//A**
			case "GAA": case "GAG": return "�۷�Ž��";
			case "GAC": case "GAU": return "�ƽ���Ʈ��";
			//GA*
			case "GGA": case "GGG": case "GGC": case "GGU": return "�۶��̽�";
			//GG*
			case "GCA": case "GCG": case "GCC": case "GCU": return "�˶��";
			//GC*
			case "GUA": case "GUG": case "GUC": case "GUU": return "�߸�";
			//GU*
			//G**
			case "CAA": case "CAG": return "�۷�Ÿ��";
			case "CAC": case "CAU": return "����Ƽ��";
			///CA*
			case "CGA": case "CGG": case "CGC": case "CGU": return "�Ƹ�����";
			//CG*
			case "CCA": case "CCG": case "CCC": case "CCU": return "���Ѹ�";
			//CC*
			case "CUA": case "CUG": case "CUC": case "CUU": return "����";
			//CU*
			//C**
			case "UAA": case "UAG": return "����";
			case "UAC": case "UAU": return "Ÿ�̷ν�";
			//UA*
			case "UGA": return "����";
			case "UGG": return "Ʈ������";
			case "UGC": case "UGU": return "�ý�����";
			//UG*
			case "UCA": case "UCG": case "UCC": case "UCU": return "����";
			//UC*
			case "UUA": case "UUG": return "����";
			case "UUC": case "UUU": return "��Ҿ˶��";
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
