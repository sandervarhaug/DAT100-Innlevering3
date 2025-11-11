package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] inleggtabell;
    private int nesteledige;
    private int nesteledigeUtvidet;
    private Innlegg[] innleggtabellUtvidet;

	public Blogg() {
		this.inleggtabell = new Innlegg[20];
        nesteledige = 0;
	}

	public Blogg(int lengde) {
		this.inleggtabell = new Innlegg[lengde];
        nesteledige = 0;
	}

	public int getAntall() {
		return nesteledige;
	}
	
	public Innlegg[] getSamling() {
		return inleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
        int r = -1;
        for (int i = 0; i < this.nesteledige; i++) {
            if (this.inleggtabell[i].erLik(innlegg)) {
                r = i;
            }
        }
        return r;
	}

	public boolean finnes(Innlegg innlegg) {
        boolean finnes = false;
		for  (int i = 0; i < this.nesteledige; i++) {
            if (this.inleggtabell[i].erLik(innlegg)) {
                finnes = true;
            }
        }
        return finnes;
	}

	public boolean ledigPlass() {
		if (this.nesteledige < this.inleggtabell.length) return true;
        else return false;

	}
	
	public boolean leggTil(Innlegg innlegg) {
        boolean leggTil = true;
        for (int i = 0; i < this.nesteledige; i++) {
            if (this.inleggtabell[i].erLik(innlegg)) {
                leggTil = false;
            }
        }
        if (leggTil) {
            inleggtabell[nesteledige] = innlegg;
            nesteledige++;
            return true;
        }
        else {
            return false;
        }
	}
	
	public String toString() {
		String s = "";
        for (int i = 0; i < this.nesteledige; i++) {
            s += this.inleggtabell[i].toString();
            s += "\n";
        }
        return s;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
        nesteledigeUtvidet = nesteledige;
		innleggtabellUtvidet = new Innlegg[inleggtabell.length*2];
        System.arraycopy(inleggtabell, 0, innleggtabellUtvidet, 0, inleggtabell.length);

	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		boolean leggTilUtvid = true;
        for (int i = 0; i < this.nesteledigeUtvidet; i++) {
            if (this.inleggtabell[i].erLik(innlegg)) {
                leggTilUtvid = false;
            }
        }
        if (leggTilUtvid) {
            this.innleggtabellUtvidet[this.nesteledigeUtvidet] = innlegg;
            nesteledigeUtvidet++;
            return true;
        }
        else {
            return false;
        }

		
	}
	
	public boolean slett(Innlegg innlegg) {

            int posisjon = finnInnlegg(innlegg);


            if (posisjon < 0) {
                return false;
            }


            for (int i = posisjon; i < nesteledige - 1; i++) {
                inleggtabell[i] = inleggtabell[i + 1];
            }

            inleggtabell[nesteledige - 1] = null;
            nesteledige--;

            return true;
    }

	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}