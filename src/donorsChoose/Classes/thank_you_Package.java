package donorsChoose.Classes;

import java.io.Serializable;

public class thank_you_Package implements Serializable{
	String letters;
	
	public thank_you_Package(String letters) {
		this.letters=letters;
	}

	public String getLetters() {
		return letters;
	}

	public void setLetters(String letters) {
		this.letters = letters;
	}

	@Override
	public String toString() {
		return "thank_you_Package [letters=" + letters + "]\n";
	}
	
}
