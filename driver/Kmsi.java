package org.kmsi.driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Kmsi extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/kmsi/view/Login.fxml"));
        Scene scene = new Scene(parent, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
