package no.hib.dat102;

import static org.junit.Assert.*;
import org.junit.*;

import no.hvl.dat102.SirkulærKø;
import no.hvl.dat102.TomKøException;
import no.hvl.dat102.adt.SirkulærKøADT;

public class SirkulærKøMedUnntakTest {

	private final int SIZE = 10;
	private SirkulærKøADT<Integer> kø;
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;

	@Before
	public final void setup() {
		kø = new SirkulærKø<Integer>(SIZE);
	}

	/**
	 * Test that a new kø is empty.
	 */
	@Test
	public final void newStackIsEmpty() {
		assertTrue(kø.isEmpty());
	}

	/**
	 * Test on enqueue and dequeue.
	 */
	@Test
	public final void enqueueAnddequeue() {

		kø.enqueue(e0);
		kø.enqueue(e1);
		kø.enqueue(e2);
		kø.enqueue(e3);

		try {
			assertEquals(e0, kø.dequeue());
			assertEquals(e1, kø.dequeue());
			assertEquals(e2, kø.dequeue());
			assertEquals(e3, kø.dequeue());
		} catch (TomKøException e) {
			fail("dequeue failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Test on enqueue and dequeue with duplicated values.
	 */
	@Test
	public final void enqueueAnddequeueWithDuplicates() {

		kø.enqueue(e0);
		kø.enqueue(e1);
		kø.enqueue(e1);
		kø.enqueue(e2);

		try {
			assertEquals(e0, kø.dequeue());
			assertEquals(e1, kø.dequeue());
			assertEquals(e1, kø.dequeue());
			assertEquals(e2, kø.dequeue());
		} catch (TomKøException e) {
			fail("dequeue failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Testing peek after multiple enqueue and dequeue´s.
	 */
	@Test
	public final void enqueuedequeueenqueueenqueuedequeuePeek() {
		try {
			kø.enqueue(e2);
			kø.dequeue();
			kø.enqueue(e3);
			kø.enqueue(e4);
			kø.dequeue();
			assertEquals(e4, kø.peek());

		} catch (TomKøException e) {
			fail("dequeue or top failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Test that a kø with element(s) is not empty.
	 */
	@Test
	public final void isNotEmpty() {
		kø.enqueue(e0);
		assertFalse(kø.isEmpty());
	}

	/**
	 * Test that a enqueue - dequeue operation on an empty kø gives an empty kø.
	 */
	@Test
	public final void enqueuedequeueIsEmpty() {
		try {
			kø.enqueue(e0);
			kø.dequeue();
			assertTrue(kø.isEmpty());
		} catch (TomKøException e) {
			fail("dequeue failed unexpectedly " + e.getMessage());
		}
	}

	/**
	 * Trying to dequeue an element from an empty kø, should give an underflow
	 * exception.
	 * 
	 * @throws TomKøException
	 *             expected exception
	 */
	@Test(expected = TomKøException.class)
	public final void dequeueFromEmptyIsUnderflowed() throws TomKøException {
		kø.dequeue();
	}

	/**
	 * Test if the kø is expanding properly, first place 1 element, then SIZE elements are put in.
	 * Further enqueue another element, and check that the kø size is correct, and check that the right
	 * element is dequeued. Further it dequeues all elements and asserts that the kø is empty. 
	 */

	@Test
	public final void utviderKoeSeg() {
		kø.enqueue(e1);
		for (int i = 0; i < SIZE; i++) {
			kø.enqueue(e0);
		}

		kø.enqueue(e2);
		assertEquals(SIZE + 2, kø.size());
		assertEquals(e1, kø.dequeue());
		for (int i = 0; i < SIZE; i++) {
			kø.dequeue();
		}

		assertEquals(e2, kø.dequeue());
		assertTrue(kø.isEmpty());
	}

}
