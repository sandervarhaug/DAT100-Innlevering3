package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

public class LesBlogg {

    public static Blogg les(String mappe, String filnavn) {
        Blogg blogg = null;

        try {
            String filsti = mappe + "/" + filnavn;


            BufferedReader reader = new BufferedReader(new FileReader(filsti));


            String linje = reader.readLine();
            int antall = Integer.parseInt(linje);


            blogg = new Blogg(antall);


            for (int i = 0; i < antall; i++) {
                String type = reader.readLine();

                int id = Integer.parseInt(reader.readLine());
                String bruker = reader.readLine();
                String dato = reader.readLine();
                int likes = Integer.parseInt(reader.readLine());

                if (type.equals("TEKST")) {
                    String tekst = reader.readLine();
                    Tekst tekstInnlegg = new Tekst(id, bruker, dato, likes, tekst);
                    blogg.leggTil(tekstInnlegg);

                } else if (type.equals("BILDE")) {
                    String tekst = reader.readLine();
                    String url = reader.readLine();
                    Bilde bildeInnlegg = new Bilde(id, bruker, dato, likes, tekst, url);
                    blogg.leggTil(bildeInnlegg);
                }
            }


            reader.close();

        } catch (IOException e) {
            System.out.println("Feil ved lesing fra fil: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Feil ved parsing av tall: " + e.getMessage());
        }

        return blogg;
    }
}
