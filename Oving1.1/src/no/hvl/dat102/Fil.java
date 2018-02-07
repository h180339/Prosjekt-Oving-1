package no.hvl.dat102;

import no.hvl.dat102.adt.CDArkivADT;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fil {

	public static CDArkivADT lesFraFil(String filnavn) {
		CDarkiv2 cdTab = new CDarkiv2();
		try {

			Scanner scan = new Scanner(new File(filnavn));
			int antall = Integer.parseInt(scan.nextLine());
			cdTab = new CDarkiv2();

			for (int i = 0; i < antall; i++) {
				String s = scan.nextLine();
				String[] tab = s.split("#");
				CD cd = new CD();

				for (int x = 0; x < tab.length; x++) {
					
					int cdNr = Integer.parseInt(tab[0]);
					String artist = tab[1];
					String tittel = tab[2];
					int lanseringsAr = Integer.parseInt(tab[3]);
					Sjanger sjanger = Sjanger.valueOf(tab[4].toUpperCase());
					String plateselskap = tab[5];
					
					cd = new CD(cdNr, artist, tittel, lanseringsAr, sjanger, plateselskap);
					
				}
				cdTab.leggTilCd(cd);

			}

			scan.close();
			return cdTab;
		} catch (IOException e) {
			System.out.println(e);
			return cdTab;
		}

	}

	public static void skrivTilFil(CDArkivADT cdArkiv, String filnavn) {
		CD[] tab = cdArkiv.henteCdTabell();
		int antall = cdArkiv.hentAntall();
		
		try {
			PrintWriter utfil = new PrintWriter(new FileWriter(filnavn));

			utfil.println(antall);
			for (int i = 0; i < antall; i++) {
				utfil.println(tab[i].skrivFil());
			}
			utfil.close();

		} catch (IOException e) {

		}
	}
}
