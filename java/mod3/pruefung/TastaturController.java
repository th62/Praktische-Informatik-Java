package mod3.pruefung;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class TastaturController {
    @FXML
    public Label lbAnzeige;
    @FXML
    public Button btn0;
    @FXML
    public Button btn1;
    @FXML
    public Button btn2;
    @FXML
    public Button btn3;
    @FXML
    public Button btn4;
    @FXML
    public Button btn5;
    @FXML
    public Button btn6;
    @FXML
    public Button btn7;
    @FXML
    public Button btn8;
    @FXML
    public Button btn9;
    @FXML
    public Button btnClear;

    @FXML
    public void kalkuliere(ActionEvent event) {
        Button gedrueckterButton = (Button) event.getSource();
        // Werte holen
        String buttonWert = gedrueckterButton.getText();
        int eingegebeneZahl = 0;
        int angezeigteZahl = Integer.parseInt(lbAnzeige.getText());
        if (  !buttonWert.equals("C")) {
            eingegebeneZahl = Integer.parseInt(buttonWert);
        }
        if ( buttonWert.equals("C") || (buttonWert.equals("0") && angezeigteZahl == 0) ) {
            lbAnzeige.setText("0");
            return;
        }
        if ( angezeigteZahl == 0 ) {
            lbAnzeige.setText(buttonWert);
        } else {
            lbAnzeige.setText(String.valueOf(angezeigteZahl * 10 + eingegebeneZahl));
        }
    }
}