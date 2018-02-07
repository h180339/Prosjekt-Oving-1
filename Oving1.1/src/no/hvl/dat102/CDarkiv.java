package no.hvl.dat102;

import no.hvl.dat102.adt.CDArkivADT;

public class CDarkiv implements CDArkivADT {

	private CD[] cdTab;
	private int antall;
	private int aLedig;

	public CDarkiv() {

	}

	public CDarkiv(int antall) {
		this.cdTab = new CD[antall];
		this.aLedig = antall;
		this.antall = antall;
	}
	@Override
	public CD[] henteCdTabell() {// returnerer en tabell av cder
		return this.cdTab;
	}
	@Override
	public void leggTilCd(CD nyCd) {// legger til en ny cd
		if (aLedig <= 0) {
			utvidKapasitet();
		}
		this.cdTab[this.antall - this.aLedig] = nyCd;
		this.aLedig--;
		
		
	}
	@Override
	public boolean slettCd(int cdNr) {// sletter cd hvis den finns
		try {
			for (int i = 0; i < cdTab.length; i++) {
				if (cdTab[i].getcdNr() == cdNr) {
					if (i == this.antall - this.aLedig - 1) {
						cdTab[i] = null;
					} else {
						cdTab[i] = cdTab[this.antall - this.aLedig - 1];
						cdTab[this.antall - this.aLedig - 1] = null;
					}

					this.aLedig++;
					return true;

				}
			}
			return false;
		} catch (NullPointerException e) {
			System.out.println("fant null");
		}
		return false;
	}
	@Override
	public CD[] sokTittel(String delstreng) {// s�ker og henter CD-er med en gitt delstreng
		CD[] helpeTab = new CD[this.antall];
		try {

			int tomme = this.antall;
			for (int i = 0; i < cdTab.length; i++) {
				if (cdTab[i].getTittel().contains(delstreng)) {
					helpeTab[this.antall - tomme] = cdTab[i];
					tomme--;
				}
			}

		} catch (NullPointerException e) {
			System.out.println("fant null");
		}
		return helpeTab;

	}
	@Override
	public CD[] sokArtist(String delstreng) {// s�ker og henter artister med en gitt delstreng
		CD[] helpeTab = new CD[this.antall];
		try {

			int tomme = this.antall;
			for (int i = 0; i < cdTab.length; i++) {
				if (cdTab[i].getArtist().contains(delstreng)) {
					helpeTab[this.antall - tomme] = cdTab[i];
					tomme--;
				}
			}

		} catch (NullPointerException e) {
			System.out.println("fant null1");
		}
		return helpeTab;
	}
	@Override
	public int hentAntall() {// henter antall CDer
		int teller = 0;
		try {
			for (int i = 0; i < cdTab.length; i++) {
				if (cdTab[i] != null) {
					teller++;
				}
			}
		} catch (NullPointerException e) {

		}
		return teller;

	}	
	@Override
	public int hentAntall(Sjanger sjanger) {// henter antall sjangre
		int teller = 0;

		try {
			for (int i = 0; i < cdTab.length; i++) {
				if (cdTab[i].getSjanger() == sjanger) {
					teller++;
				}

			}

		} catch (NullPointerException e) {

		}
		return teller;

	}
	
	private void utvidKapasitet() {
		int nyAntall = (int) Math.ceil(1.1 * antall);
		CD[] hjelpeTabell = new CD[nyAntall];
		for (int i = 0; i < cdTab.length; i++) {
			hjelpeTabell[i] = cdTab[i];
		}
		this.aLedig = nyAntall - antall - 1;
		this.cdTab = hjelpeTabell;
	}


}
