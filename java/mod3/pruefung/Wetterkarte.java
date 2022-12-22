package mod3.pruefung;

import java.net.URL;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

/**
 * Wetterkarte lädt ein Bild aus dem Internet und speichert es lokal auf dem Rechner in dem ordner 'dateien' im Projektverzeichnis.
 *
 * @author T. Haberland
 * @version 1.1
 */
public class Wetterkarte {

    /**
     * Ausführung über die Main!
     *
     * @param args werden nicht übergeben!
     * @throws IOException für ImageIO.write(ImageIO.read(new URL)
     */
    public static void main(String[] args) throws IOException {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                ImageIO.write(ImageIO.read(new URL(
                                "https://www.dwd.de/DWD/wetter/aktuell/deutschland/bilder/wx_brd_akt.jpg")),
                        "jpg", new File("src/main/java/mod3/pruefung/dateien/downloadedPicture.jpg"));
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}