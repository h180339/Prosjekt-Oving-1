package no.hvl.dat102;

import no.hvl.dat102.adt.SirkulærKøADT;

public class SirkulærKø<T> implements SirkulærKøADT<T> {
	private final int STDK = 100;
	private T[] kø;
	private int front;
	private int back;
	private int size;

	public SirkulærKø() {
		kø = (T[]) new Object[STDK];
	}

	public SirkulærKø(int startKapasitet) {
		kø = (T[]) new Object[startKapasitet];
		front = back = 0;
		size = 0;
	}

	@Override
	public void enqueue(T element) {
		if (size() == kø.length) {
			utvid();
		}
		kø[back] = element;
		back = (back + 1) % kø.length;
		size++;
	}

	@Override
	public T dequeue() throws TomKøException {
		T resultat = null;
		if (!isEmpty()) {
			resultat = kø[front];
			kø[front] = null;
			front = (front + 1) % kø.length;
			size--;
		}
		return resultat;
	}

	@Override
	public T first() {
		return kø[front];
	}

	@Override
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	private void utvid() {
		T[] hjelpetabell = (T[]) new Object[kø.length * 2];
		for (int i = 0; i < size; i++) {
			hjelpetabell[i] = kø[front];
			front = (front + 1) % kø.length;
		}
		front = 0;
		back = size;
		kø = hjelpetabell;
	}
}
