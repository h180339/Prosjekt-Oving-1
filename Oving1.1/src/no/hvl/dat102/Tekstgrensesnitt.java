package no.hvl.dat102;

import no.hvl.dat102.adt.CDArkivADT;

import java.util.Scanner;

public class Tekstgrensesnitt {

	public Tekstgrensesnitt() {

	}

	public CD lesCD() { // lese opplysningene om en CD fra tastatur
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Gi cd nr: ");
		int cdNr = Integer.parseInt(scan.nextLine());
		System.out.print("Gi artist navn: ");
		String artist = scan.nextLine();
		System.out.print("Gi tittel: ");
		String tittel = scan.nextLine();
		System.out.print("Gi lanserings �r: ");
		int lanseringAr = Integer.parseInt(scan.nextLine());
		System.out.print("Gi sjanger: ");
		Sjanger sjanger = Sjanger.valueOf(scan.nextLine().toUpperCase());

		System.out.print("Gi plateselskap: ");
		String plateselskap = scan.nextLine();
		System.out.println();

		CD cd = new CD(cdNr, artist, tittel, lanseringAr, sjanger, plateselskap);
		return cd;
	}

	public void visCD(CD cd) { // vise en CD med alle opplysninger p� skjerm (husk tekst for sjanger)
		System.out.println("cd nr: " + cd.getcdNr() + " |artist: " + cd.getArtist() + " |tittel: " + cd.getTittel()
				+ " |lanserings �r: " + cd.getLanseringAr() + " |sjanger: " + cd.getSjanger() + " |plateselskap: "
				+ cd.getPlateselskap());
		System.out.println();
	}

	public void skrivUtCdDelstrengITittel(CDArkivADT cda, String delstreng) { // skrive ut alle CD-er med en spesiell
																				// deslstreng i tittelen
		try {
			CD [] tab = cda.sokTittel(delstreng);
			for (int i = 0; i < tab.length;i++) {
				System.out.println(tab[i].toString());
			}
		} catch (NullPointerException e) {

		}
	}

	public void skrivUtCdArtist(CDArkivADT cda, String delstreng) { // Skriver ut alle CD-er av en artist / en gruppe
		try {
			CD [] tab = cda.sokArtist(delstreng);
			for (int i = 0; i < tab.length;i++) {
				System.out.println(tab[i].toString());
			}
			
		} catch (NullPointerException e) {
			System.out.println("wrong");

		}
	}

	public void skrivUtStatistikk(CDArkivADT cda) { // Skrive ut en enkel statistikk som inneholder antall CD-er totalt
													// og hvor mange det er i hver sjanger
		
		System.out.println("antall cder: " + cda.hentAntall());
		System.out.println("antall pop cd'er: " + cda.hentAntall(Sjanger.POP));
		System.out.println("antall rock cd'er: " + cda.hentAntall(Sjanger.ROCK));
		System.out.println("antall opera cd'er: " + cda.hentAntall(Sjanger.OPERA));
		System.out.println("antall klassisk cd'er: " + cda.hentAntall(Sjanger.KLASSISK));
		
	}
}
