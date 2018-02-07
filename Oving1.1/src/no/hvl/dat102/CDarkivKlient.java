package no.hvl.dat102;

import no.hvl.dat102.adt.CDArkivADT;

public class CDarkivKlient {

	public static void main(String[] args) {
	
		CDArkivADT cdADT = new CDarkiv2();

		Meny m = new Meny(cdADT);
		m.start();
	}

}