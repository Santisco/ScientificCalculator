package gui;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import parser.Calculator;

public class javafxModeController {

    @FXML
    private Label remindLabel1;

    @FXML
    private Label remindLabel;

    @FXML
    private TextField inputField;

    @FXML
    private BorderPane groundPane;

    @FXML
    private TextField outputField;

    @FXML
    void GET_RESULT(ActionEvent event) {
    	 try {
             Calculator calculator = new Calculator();
             BigDecimal bigResult = calculator.calculate(inputField.getText().trim());
             //bigResult.setScale(100 ,BigDecimal.ROUND_DOWN); 
             DecimalFormat df = new DecimalFormat("#.000000000000000");
             System.out.println(df.format(bigResult));
             outputField.setText("" + df.format(bigResult));
           } catch (Exception ex) {
             outputField.setText(ex.getMessage());
           }
    }

}
