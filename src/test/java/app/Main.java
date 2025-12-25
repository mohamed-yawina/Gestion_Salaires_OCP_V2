package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.HibernateUtil;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        
        HibernateUtil.getSessionFactory();

       
        Parent root = FXMLLoader.load(
                getClass().getResource("/interface.fxml")
        );

        Scene scene = new Scene(root);

        primaryStage.setTitle("Gestion des Salaires - OCP");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        
        HibernateUtil.getSessionFactory().close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
