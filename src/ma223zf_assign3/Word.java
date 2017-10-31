package ma223zf_assign3;

public class Word implements Comparable<Word> {

	private String word;

	public Word(String str) {

		word = str;
	}

	public String toString() {
		return word;
	}

	public String getWord() {
		return word;
	}

	/* Override Object methods */
	public int hashCode() { // compute a hash value for word//
		int hc = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			hc += Character.getNumericValue(c); // ASCII number
		}
		return hc;
	}

	public boolean equals(Object other) { // true if two words are equal//
		if (other instanceof Word) {
			Word w = (Word) other;
			if (this.compareTo((Word) w) == 0) {
				return true;
			}
		}
		return false;
	}

	/* Implement Comparable */
	public int compareTo(Word w) { // compares two words lexicographically//
		return this.getWord().compareToIgnoreCase(w.getWord());
	}

}
