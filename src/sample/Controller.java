package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    @FXML
    private Label balanceField;

    @FXML
    private Label dayField;

    @FXML
    private Label workersfield;

    @FXML
    private Label workersLevel;

    @FXML
    public TextArea textArea = new TextArea();


    Card card = new Card();
    public void cards(){
        card.cards();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
