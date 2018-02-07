package no.hvl.dat102;
import no.hvl.dat102.adt.CDArkivADT;

public class CDarkiv2 implements CDArkivADT {

	private Liste<CD> liste;

	public CDarkiv2() {
		this.liste = new Liste<CD>();

	}

	@Override
	public CD[] henteCdTabell() {
		int i = 0;
		int ant = liste.getAntall();
		LinearNode<CD> denne = liste.getStart();
		CD[] tabell = new CD[ant];

		while (i < ant) {
			tabell[i] = denne.getElement();
			denne = denne.getNeste();
			i++;
		}

		return tabell;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		liste.push(nyCd);

	}

	@Override
	public boolean slettCd(int cdNr) {
		CD[] tab = henteCdTabell();
		for (int i = 0; i < tab.length; i++) {
			if (tab[i].getcdNr() == cdNr) {
				liste.slett(tab[i]);
				return true;
			}
		}
		return false;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		int i = 0;
		int ant = liste.getAntall();
		int antallFunnet = 0;
		CD[] tab = new CD[ant];
		LinearNode<CD> denne = liste.getStart();
		while (i < ant) {
			if (denne.getElement().getTittel().toUpperCase().contains(delstreng.toUpperCase())) {
				tab[i] = denne.getElement();
				antallFunnet++;
				i++;
				denne = denne.getNeste();
			} else {
				i++;
				denne = denne.getNeste();
			}
		}
		CD[] retur = new CD[antallFunnet];
		for (int j = 0; j < antallFunnet; j++) {
			retur[j] = tab[j];
		}
		return retur;
	}

	@Override
	public CD[] sokArtist(String delstreng) { // søker og henter artister med en gitt delstreng
		CD[] tab = henteCdTabell();
		CD[] hjelpeTab = new CD[liste.getAntall()];

		try {
			int tomme = hjelpeTab.length;
			for (int i = 0; i < tab.length; i++) {
				if (tab[i].getArtist().toUpperCase().contains(delstreng.toUpperCase())) {
					hjelpeTab[hjelpeTab.length - tomme] = tab[i];
					tomme--;
				}
			}

		} catch (NullPointerException e) {
		}
		return hjelpeTab;
	}

	@Override
	public int hentAntall() {
		return liste.getAntall();

	}

	@Override
	public int hentAntall(Sjanger sjanger) {
		int i = 0;
		int teller = 0;
		int ant = liste.getAntall();
		LinearNode<CD> denne = liste.getStart();

		while (i < ant) {
			if (denne.getElement().getSjanger() == sjanger) {
				teller++;
			}
			denne = denne.getNeste();
			i++;
		}

		return teller;

	}

}