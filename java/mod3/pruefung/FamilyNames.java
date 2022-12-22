package mod3.pruefung;

import java.io.*;
import java.util.*;

/**
 * The type Family names.
 */
public class FamilyNames {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        List<String> wortListeArray = new ArrayList<>();
        List<String> passendeWorter = new ArrayList<>();
        String eingegebenesSuchmuster = null;
        int suchmusterLaenge = 0;
        String dateiPfad = "src/main/java/mod3/pruefung/dateien/family-names.txt";
        Scanner wortListeInput = null;
        Scanner konsoleInput = new Scanner(System.in);

        // Wortliste einlesen
        try {
            wortListeInput = new Scanner(new BufferedReader(new FileReader(dateiPfad)));
            wortListeInput.useDelimiter("\\r\\n|\\r|\\n");

            while (wortListeInput.hasNext()) {
                String wortZwischengespeichert = wortListeInput.next();
                if (wortZwischengespeichert.matches("^[a-zA-Z]*$")) { // Namen mit Leerzeichen oder Bindestrichen etc. aussortieren
                    wortListeArray.add(wortZwischengespeichert);
                }
            }
        } finally {
            if (wortListeInput != null) {
                wortListeInput.close();
            }
        }

        while (eingegebenesSuchmuster == null || !eingegebenesSuchmuster.toUpperCase().equals("XXX")) {
            System.out.println("\r\nBitte Suchmuster eingeben. Der Punkt wird als Wildcard gewertet.");
            System.out.println("Die Eingabe von 'xxx' beendet die Suche.");
            eingegebenesSuchmuster = konsoleInput.nextLine().toUpperCase();
            if (eingegebenesSuchmuster.matches("^[a-zA-Z.]*$")) {  // Nur Buchstaben und den Punkt akzeptieren
                suchmusterLaenge = eingegebenesSuchmuster.length();
            }
            for (String aktuellesWort : wortListeArray) {
                String temp = String.valueOf(aktuellesWort).toUpperCase();
                if (temp.length() == suchmusterLaenge) {
                    boolean treffer = true;
                    for (int i = 0; i < suchmusterLaenge; i++) {
                        if (!(temp.charAt(i) == eingegebenesSuchmuster.charAt(i) || eingegebenesSuchmuster.charAt(i) == '.')) {
                            treffer = false;
                            break;
                        }
                    }
                    if (treffer) {
                        passendeWorter.add(String.valueOf(aktuellesWort));
                    }
                }
            }
            if (!eingegebenesSuchmuster.equalsIgnoreCase("XXX")) {
                if (passendeWorter.isEmpty()) {
                    System.out.println("Es wurden leider keine passenden Wörter gefunden!\nVersuchen Sie bitte eine andere Kombination...");
                } else {
                    System.out.println("Treffer dem Suchmuster entsprechend:\n" + passendeWorter);
                    passendeWorter.clear();
                }
            } else {
                System.out.println("Vielen Dank für die Nutzung unseres Services!\nBis zum nächsten Mal!");
            }
        }
    }
}