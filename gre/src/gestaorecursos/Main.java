package gestaorecursos;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*** @author mgonc */

public class Main extends Application {
    
    
    @Override
    public void start(Stage stage) throws IOException{
        
        
        Parent root = FXMLLoader.load(getClass().getResource("views/Principal.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Sistema GRE");
        stage.setResizable(true);
        stage.setMaximized(true);
        stage.show();
        
    }
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
