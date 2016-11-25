package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import parser.Calculator;
import parser.Token;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Stack;

import javafx.event.*;

public class javafxController {

	private Stack<Integer> calcuStack = new Stack<Integer>();
	private int lbrFlag = 0;
    @FXML
    private BorderPane groundPane;
	 private BorderPane rootLayout;
    @FXML
    private Label outputLabel;

    @FXML
    private Label inputLabel;

    @FXML
    private BorderPane mainPane;

    @FXML
    void PUT_SIN(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "SIN(");
    	calcuStack.push(14);
    	lbrFlag++;
    }

    @FXML
    void PUT_COS(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "COS(");
    	calcuStack.push(14);
    	lbrFlag++;
    }

    @FXML
    void PUT_TAN(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "TAN(");
    	calcuStack.push(14);
    	lbrFlag++;
    }

    @FXML
    void PUT_YROOT(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "YROOT(");
    	calcuStack.push(16);
    	lbrFlag++;
    }

    @FXML
    void PUT_SQRT(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "SQRT(");
    	calcuStack.push(15);
    	lbrFlag++;
    }

    @FXML
    void PUT_CUBEROOT(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "CUBEROOT(");
    	calcuStack.push(19);
    	lbrFlag++;
    }

    @FXML
    void PUT_ARCSIN(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "ARCSIN(");
    	calcuStack.push(17);
    	lbrFlag++;
    }

    @FXML
    void PUT_ARCCOS(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "ARCCOS(");
    	calcuStack.push(17);
    	lbrFlag++;
    }

    @FXML
    void PUT_ARCTAN(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "ARCTAN(");
    	calcuStack.push(17);
    	lbrFlag++;
    }

    @FXML
    void PUT_POW(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "^");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_FACT(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "FACT(");
    	calcuStack.push(15);
    	lbrFlag++;
    }

    @FXML
    void PUT_SINH(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "SINH(");
    	calcuStack.push(15);
    	lbrFlag++;
    }

    @FXML
    void PUT_LOG(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "LOG(");
    	calcuStack.push(14);
    	lbrFlag++;
    }

    @FXML
    void PUT_LN(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "LN(");
    	calcuStack.push(13);
    	lbrFlag++;
    }

    @FXML
    void PUT_LOG10(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "LOG10(");
    	calcuStack.push(16);
    	lbrFlag++;
    }

    @FXML
    void PUT_LBM(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "[");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_RBM(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "]");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_COSH(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "COSH(");
    	calcuStack.push(15);
    	lbrFlag++;
    }

    @FXML
    void PUT_MOD(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "MOD(");
    	calcuStack.push(14);
    	lbrFlag++;
    }

    @FXML
    void PUT_AVERAGE(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "AVG([");
    	calcuStack.push(16);
    	lbrFlag++;
    }

    @FXML
    void PUT_SUM(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "SUM([");
    	calcuStack.push(15);
    	lbrFlag++;
    }

    @FXML
    void PUT_LBRACKET(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "(");
    	calcuStack.push(11);
    	lbrFlag++;
    }

    @FXML
    void PUT_RBRACKET(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + ")");
    	calcuStack.push(21);
    	lbrFlag--;
    }

    @FXML
    void PUT_TANH(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "TANH(");
    	calcuStack.push(15);
    	lbrFlag++;
    }

    @FXML
    void PUT_EXP(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "EXP(");
    	calcuStack.push(14);
    	lbrFlag++;
    }

    @FXML
    void PUT_MULTIPLY(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "*");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_SEVEN(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "7");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_EIGHT(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "8");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_NINE(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "9");
    	calcuStack.push(1);
    }

    @FXML
    void CLEAR(ActionEvent event) {
    	inputLabel.setText(" ");
    	outputLabel.setText("0 ");
    	lbrFlag =0;
    }

    @FXML
    void PUT_DIVIDE(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "/");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_FOUR(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "4");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_FIVE(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "5");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_SIX(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "6");
    	calcuStack.push(1);
    }

    @FXML
    void GET_EQAUL(ActionEvent event) {
        try {
        	int mid = lbrFlag;
        	for(int i = 0; i < lbrFlag; i++){
        		inputLabel.setText(inputLabel.getText() + ")");
        		calcuStack.push(21);
        		mid --;
        	}
        	lbrFlag = mid;
            Calculator calculator = new Calculator();
            BigDecimal bigResult = calculator.calculate(inputLabel.getText().trim());
            //bigResult.setScale(100 ,BigDecimal.ROUND_DOWN); 
            DecimalFormat df = new DecimalFormat("#.000000000000000");
            System.out.println(df.format(bigResult));
            outputLabel.setText("" + df.format(bigResult));
          } catch (Exception ex) {
            outputLabel.setText(ex.getMessage());
            lbrFlag =0;
          }
    }

    @FXML
    void PUT_VAR(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "VAR([");
    	calcuStack.push(15);
    	lbrFlag++;
    }

    @FXML
    void PUT_PLUS(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "+");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_ONE(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "1");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_TWO(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "2");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_THREE(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "3");
    	calcuStack.push(1);
    }

    @FXML
    void STEP_BACK(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText().substring(0, inputLabel.getText().length() - calcuStack.peek()%10));
    	int carry = calcuStack.pop()/10;
    	if(carry == 1){
    		lbrFlag--;
    	}
    	else if(carry == 2){
    		lbrFlag++;
    	}
    }

    @FXML
    void PUT_STDEVP(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "STDVEP([");
    	calcuStack.push(18);
    	lbrFlag++;
    }

    @FXML
    void PUT_MINUS(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "-");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_ZERO(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "0");
    	calcuStack.push(1);
    }

    @FXML
    void PUT_DOT(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + ".");
    	calcuStack.push(1);
    }


    @FXML
    void PUT_DOUBLEZERO(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + "00");
    	calcuStack.push(1);
    	calcuStack.push(1);
    }
    
    @FXML
    void PUT_DOU(ActionEvent event) {
    	inputLabel.setText(inputLabel.getText() + ",");
    	calcuStack.push(1);
    }
    @FXML
    void POP_MODE(ActionEvent event) {
   	 Stage stage = new Stage();
   	 stage.setTitle("手动输入模式");
   	 
	     stage.setResizable(false);
	        try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(javafxWindow.class.getResource("modeView.fxml"));
	            rootLayout = (BorderPane) loader.load();

	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout,Color.TRANSPARENT);
	            File f = new File("skin.css");
	            scene.getStylesheets().clear();
	            scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
	            stage.setScene(scene);
	            stage.show();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    }

    @FXML
    void POP_INSTRUCTION(ActionEvent event) {
        Stage stage = new Stage();
        Label l = new Label("SIN,COS,TAN:三角函数\n"
        		+ "ARCS,ARCC,ARCT:反三角函数\n"
        		+ "^:乘方\n"
        		+ "!:阶乘\n"
        		+ "MOD:取模\n"
        		+ "AVER:取平均\n"
        		+ "SUM:求和\n"
        		+ "SINH,COSH,TANH:双曲函数\n"
        		+ "e^x:e为底的幂函数\n"
        		+ "具备基础()的补全功能，对于有集合运算需要手动补全]");
        //l.textAlignmentProperty();
        Scene s = new Scene(l,300,200);
        stage.setScene(s);
        stage.show();
    }

    @FXML
    void POP_CODER(ActionEvent event) {
        Stage stage = new Stage();
        Label l = new Label("吴冠龙制作");
        //l.textAlignmentProperty();
        Scene s = new Scene(l,100,50);
        stage.setScene(s);
        stage.show();
    }
}
