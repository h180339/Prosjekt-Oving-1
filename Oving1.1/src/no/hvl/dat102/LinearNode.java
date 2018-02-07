package no.hvl.dat102;

public class LinearNode <T> {
	
	private LinearNode<T> neste;
	private T element;

	public LinearNode() {
		this.neste = null;
		this.element = null;
		
	}
	
	public LinearNode(T elem) {
		
		this.neste = null;
		this.element = elem;
		
	}
	
	public LinearNode<T> getNeste() {
		return this.neste;
	}
	public void setNeste(LinearNode<T> node) {
		this.neste = node;
	}
	public T getElement() {
		return this.element;
	}
	public void setElement(T elem) {
		this.element = elem;
	}
	
	@Override
	public String toString() {
		return this.element.toString();
	}
}
