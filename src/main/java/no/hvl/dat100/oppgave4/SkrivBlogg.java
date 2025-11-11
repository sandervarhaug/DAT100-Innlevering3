package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        try {
            String filsti = mappe + "/" + filnavn;


            FileWriter fileWriter = new FileWriter(filsti);
            PrintWriter printWriter = new PrintWriter(fileWriter);


            String innhold = samling.toString();


            printWriter.print(innhold);


            printWriter.close();
            fileWriter.close();


            return true;

        } catch (IOException e) {

            System.out.println("Feil ved skriving til fil: " + e.getMessage());
            return false;
        }
	}
}
