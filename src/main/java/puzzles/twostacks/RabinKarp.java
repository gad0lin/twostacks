package puzzles.twostacks;

public class RabinKarp implements StringMatcher {
	private final int modulo = 13;
	private final int MUL = 10;

	private char[] txt;
	private char[] searchStr;

	public RabinKarp(String text, String pattern) {
		txt = text.toCharArray();
		searchStr = pattern.toCharArray();
	}

	public int getPatternIndex() {
		if (txt.length < searchStr.length)
			return NOT_FOUND;

		StringHash patternHash = new StringHash(searchStr, searchStr.length);
		StringHash txtHash = new StringHash(txt, searchStr.length);
		int lastIndex = txt.length - searchStr.length;
		for (int s = 0; s <= lastIndex; s++) {
			if (txtHash.matches(patternHash)) {
				return s;
			}
			if (s != lastIndex) {
				txtHash.shift();
			}
		}
		return NOT_FOUND;

	}

	class StringHash {
		private int hashLenght;
		private char[] string;
		private int hash;
		private int position;
		private int shiftFactor;

		StringHash(char[] string, int hashLenght) {
			this.string = string;
			this.hashLenght = hashLenght;
			hash = calculateHash();

			shiftFactor = (int) ((Math.pow(10, hashLenght - 1)) % modulo);

		}

		public boolean matches(StringHash patternHash) {
			if (hash != patternHash.hash)
				return false;

			for (int i = 0; i < searchStr.length; i++) {
				if (string[position + i] != patternHash.string[i
						+ patternHash.position]) {
					return false;
				}
			}
			return true;
		}

		private int calculateHash() {
			int val = 0;
			for (int i = 0; i < hashLenght; i++) {
				val = MUL * val + string[i];
				val %= modulo;
			}
			return val;
		}

		void shift() {
			hash = 10 * (hash - shiftFactor * string[position])
					+ string[position + hashLenght];
			hash %= modulo;
			if (hash < 0) {
				hash += modulo;
			}
			position++;
		}

		public int getPosition() {
			return position;
		}

		public int getHash() {
			return hash;
		}
	}

}
