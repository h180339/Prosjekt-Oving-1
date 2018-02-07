package no.hvl.dat102;

public class Liste <T> {
	
	private LinearNode<T> start;
	private int antall;

	public Liste() {
		this.start = null;
		this.antall = 0;
	}

	public void push(T element) {

		LinearNode<T> nyStart = new LinearNode<T>(element);

		nyStart.setNeste(start);
		this.start = nyStart;

		antall++;

	}

	public LinearNode<T> pop() {

		LinearNode<T> gStart = this.start;

		this.start = gStart.getNeste();
		antall--;
		return gStart;
	}

	public LinearNode<T> peak() {
		return this.start;
	}

	public int getAntall() {
		return this.antall;
	}

	public boolean slett(T element) {

		LinearNode<T> forrige = this.start;
		LinearNode<T> denne = forrige.getNeste();
		

		
		if (element.equals(forrige.getElement())) {
			pop();
		}
		for (int i = 0; i < antall - 1; i++) {

			if (element.equals(denne.getElement())){
				forrige.setNeste(denne.getNeste());
				antall--;
				return true;
			}

			forrige = denne;
			denne = denne.getNeste();
		}
		return false;

	}

	@Override
	public String toString() {
		String s = "";
		if (antall == 0) {
			return null;
		}

		LinearNode<T> denne = start;
		s += denne.toString() + "\n";

		for (int i = 0; i < antall - 1; i++) {
			denne = denne.getNeste();
			s += denne.toString() + "\n";
		}
		return s;
	}
	
	public LinearNode <T> getStart() {
		return this.start;
	}
	




}
