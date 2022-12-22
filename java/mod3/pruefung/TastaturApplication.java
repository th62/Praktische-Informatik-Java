package mod3.pruefung;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class TastaturApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TastaturApplication.class.getResource("tastatur.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 310);
        stage.setTitle("Tastatur");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}