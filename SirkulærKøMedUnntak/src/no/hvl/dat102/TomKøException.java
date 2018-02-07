package no.hvl.dat102;

public class TomKøException extends RuntimeException {
	   public TomKøException (String samling) {
		      super ("" + samling + " er tom.");
		   }
}
