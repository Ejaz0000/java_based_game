package main;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Nextlvl {

    public void changelvl(Text txt) throws IOException {
        Stage stage = (Stage) txt.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample02.fxml"));
        stage.setScene(new Scene(root));
        stage.getScene().getRoot().requestFocus();
    }

    public void resetlvl(Text txt) throws IOException {
        Stage stage = (Stage) txt.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stage.setScene(new Scene(root));
        stage.getScene().getRoot().requestFocus();
    }
}
