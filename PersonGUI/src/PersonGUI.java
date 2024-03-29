import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class PersonGUI extends Application{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PersonController personController = new PersonController();
        Parent root = FXMLLoader.load(getClass().getResource("Person.fxml"), personController.res);
        Scene scene = new Scene(root);
        primaryStage.setTitle("PersonGUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
