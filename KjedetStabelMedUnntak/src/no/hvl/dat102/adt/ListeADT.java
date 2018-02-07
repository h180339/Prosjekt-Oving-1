package no.hvl.dat102.adt;

import no.hvl.dat102.LinearNode;
import no.hvl.dat102.EmptyCollectionException;

public interface ListeADT<T> {
	
	
	void push(T element);

	T pop() throws EmptyCollectionException;

	T peek() throws EmptyCollectionException;

	boolean erTom();

	int antall();


}
