package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class CardView extends VBox {

    @FXML
    private Label label;

    public CardView(int elem) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CardView.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        try {
            loader.load();
            label.setText(String.valueOf(elem));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
