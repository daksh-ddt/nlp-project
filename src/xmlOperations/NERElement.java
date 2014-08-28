package xmlOperations;

public class NERElement {
	String word;
	String ner;
	
	public NERElement(String word, String ner) {
		super();
		this.word = word;
		this.ner = ner;
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public String getNer() {
		return ner;
	}
	
	public void setNer(String ner) {
		this.ner = ner;
	}
}
