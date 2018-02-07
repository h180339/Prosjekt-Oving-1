package no.hvl.dat102.adt;

import no.hvl.dat102.CD;
import no.hvl.dat102.Sjanger;

public interface CDArkivADT {
	
	CD[] henteCdTabell(); // returnerer en tabell av cder
	
	void leggTilCd(CD nyCd);//legger til en ny cd
	
	boolean slettCd(int cdNr);//sletter cd hvis den finns
	
	CD[] sokTittel(String delstreng); //s�ker og henter CD-er med en gitt delstreng
	
	CD[] sokArtist(String delstreng);//s�ker og henter artister med en gitt delstreng
	
	int hentAntall();//henter antall CDer
	
	int hentAntall(Sjanger sjanger);//henter antall sjangre
}
