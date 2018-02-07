package no.hvl.dat102;

public class KlientKoe{
	public static void main(String[] args) {
		
		SirkulærKø<Character> tegnKoe = new SirkulærKø<Character>();

		String streng = " Denne koen er en FIFO datastruktur.";
		int lengde = streng.length();

		for (int i = 0; i < lengde; i++) {
			tegnKoe.enqueue(new Character(streng.charAt(i)));
		}
		while (!tegnKoe.isEmpty()) {
			Character tegn_obj = (Character) tegnKoe.dequeue();
			System.out.print(tegn_obj);
		}

	}

}
