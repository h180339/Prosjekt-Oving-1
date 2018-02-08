package no.hvl.dat102.adt;

import no.hvl.dat102.CD;
import no.hvl.dat102.Sjanger;

public interface CDArkivADT {
	
	/**
	 *returnerer en tabell av cder
	 */
	
	CD[] henteCdTabell(); 
	
	/**
	 * legger til en ny cd
	 */
	
	void leggTilCd(CD nyCd);
	/**
	 *sletter cd hvis den finns
	 */
	
	boolean slettCd(int cdNr);
	
	/**
	 * s�ker og henter CD-er med en gitt delstreng
	 */
	
	CD[] sokTittel(String delstreng);
	
	/**
	 * s�ker og henter artister med en gitt delstreng
	 */
	
	CD[] sokArtist(String delstreng);
	
	/**
	 * henter antall CDer
	 */
	
	int hentAntall();
	
	/**
	 * henter antall sjangre
	 */
	
	int hentAntall(Sjanger sjanger);
}
