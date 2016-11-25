package gui;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
public class javafxWindow extends Application {
	 private Stage primaryStage;
	    private BorderPane rootLayout;

	    @Override
	    public void start(Stage primaryStage) {
	        this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("冠龙小学生计算器");
	        this.primaryStage.setResizable(false);
	      //  this.primaryStage.getIcons().add(new Image("file:///" +"C:\\Users\\lenovo\\workspace\\Calculator-master\\src\\gui\\icon.png".replace("\\", "/")));
	        this.primaryStage.getIcons().add(new Image("/gui/icon.png"));
	        initRootLayout();


	    }

	    /**
	     * Initializes the root layout.
	     */
	    public void initRootLayout() {
	        try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(javafxWindow.class.getResource("overView.fxml"));
	            rootLayout = (BorderPane) loader.load();

	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout,Color.TRANSPARENT);
	            File f = new File("skin.css");
	            scene.getStylesheets().clear();
	            scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
	            primaryStage.setScene(scene);
	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    public Stage getPrimaryStage() {
	        return primaryStage;
	    }
	public static void main(String[] args) {
		launch(args);
	}
}
