package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    private Controller myController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        myController = loader.getController();
        myController.primaryStage = primaryStage;        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1020, 903));
        primaryStage.show();
    }
    public void stop() {
        // When the Application stops, save all the text seen in GUI View
        myController.save();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
