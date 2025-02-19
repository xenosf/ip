package dude;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//@@author xenosf-reused
// Reused from https://se-education.org/guides/tutorials/javaFxPart4.html
// With minor alterations

/**
 * A GUI for Dude using FXML.
 */
public class Main extends Application {
    private final String filePath = "." + File.separator + "data" + File.separator + "dude.txt";
    private final Dude dude = new Dude(filePath);

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDude(dude);
            stage.setTitle("Dude");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//@@author
