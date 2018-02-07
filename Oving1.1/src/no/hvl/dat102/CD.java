package no.hvl.dat102;
import no.hvl.dat102.adt.CDArkivADT;

public class CD {

	private int cdNr;
	private String artist;
	private String tittel;
	private int lanseringAr;
	private Sjanger sjanger;
	private String plateselskap;

	public CD() {

	}

	public CD(int cdNr, String artist, String tittel, int lanseringAr, Sjanger sjanger, String plateselskap) {
		this.cdNr = cdNr;
		this.artist = artist;
		this.tittel = tittel;
		this.lanseringAr = lanseringAr;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}

	public int getcdNr() {
		return this.cdNr;
	}

	public String getTittel() {
		return this.tittel;
	}

	public String getArtist() {
		return this.artist;
	}

	public Sjanger getSjanger() {
		return this.sjanger;
	}

	public int getLanseringAr() {
		return this.lanseringAr;
	}

	public String getPlateselskap() {
		return this.plateselskap;
	}

	public String toString() {
		return "cd nr: " + this.cdNr + " |artist: " + this.artist + " |tittel: " + this.tittel + " |lanserings år: "
				+ lanseringAr + " |sjanger: " + this.sjanger + " |plateselskap: " + this.plateselskap;
	}

	public String skrivFil() {
		return this.cdNr + "#" + this.artist + "#" + this.tittel + "#" + this.lanseringAr + "#" + this.sjanger + "#"
				+ this.plateselskap;
	}
}
