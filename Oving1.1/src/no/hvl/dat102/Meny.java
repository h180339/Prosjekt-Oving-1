package no.hvl.dat102;

import no.hvl.dat102.adt.CDArkivADT;

import java.util.Scanner;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private CDArkivADT cda;

	public Meny(CDArkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public void start() {

		Scanner scan = new Scanner(System.in);
		boolean avslutt = false;
		while (!avslutt) {

			try {
			System.out.println("MENY: ");
			System.out.println("1 - Legg til cd i arkiv");
			System.out.println("2 - Slett cd fra arkiv ved cdNr");
			System.out.println("3 - Søk etter cd i arkiv etter tittel");
			System.out.println("4 - Søk etter cd i arkiv etter artist");
			System.out.println("5 - Skriv ut statistikk om arkiv");
			System.out.println("6 - Les fra fil");
			System.out.println("7 - Skriv ut til fil");
			System.out.println("8 - Skriv ut tabell til konsoll");
			
			System.out.println("0 - Avslutt program");

			int svar = Integer.parseInt(scan.nextLine());
			// cda = new CDarkiv(100);
			String delstreng;

			switch (svar) {
			case 1:
				
				cda.leggTilCd(tekstgr.lesCD());
				break;
			case 2:
				System.out.println("gi cd nr");
				int cdNr = Integer.parseInt(scan.nextLine());
				cda.slettCd(cdNr);
				break;
			case 3:
				System.out.println("gi tittel: ");
				delstreng = scan.nextLine();
				tekstgr.skrivUtCdDelstrengITittel(cda, delstreng);
				break;
			case 4:
				System.out.println("gi artist: ");
				delstreng = scan.nextLine();
//				System.out.println(cda.getClass().getSimpleName());
				tekstgr.skrivUtCdArtist(cda, delstreng);
				break;
			case 5:
				tekstgr.skrivUtStatistikk(cda);
				break;
			case 6:
				System.out.print("gi filnavn til fil: ");
				String filnavn = scan.nextLine();
				cda = Fil.lesFraFil(filnavn);
				break;
			case 7:
				Fil.skrivTilFil(cda, "cdFil.txt");
				break;
			case 8:
				CD[] cdAr = cda.henteCdTabell();
				for (int i = 0; i < cdAr.length; i++) {
					if (cdAr[i] != null) {
						System.out.println(cdAr[i].toString());
					}
				}
				break;
			case 0:
				Fil.skrivTilFil(cda, "cdFil.txt");
				avslutt = true;

			}
			
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		scan.close();
	}

}
