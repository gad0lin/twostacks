package puzzles.twostacks;

public class Generics {
	
	
		
	<T extends A & B> void p(T o) {
		Number n = 3;
		System.out.println();
	}

	interface A {
	}

	interface B {
	}

}
