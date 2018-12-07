package org.kmsi.controller;

import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.*;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import org.kmsi.dao.AkunDao;
import org.kmsi.dao.impl.AkunDaoImpl;
import org.kmsi.model.Akun;

public class LoginController implements Initializable {

    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private Label labelAkunInvalid;
    private AkunDao aDao;

    public TextField getUsernameTF() {
        return usernameTF;
    }

    public LoginController() {
        aDao = new AkunDaoImpl();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public String getUser(){
        String username = usernameTF.getText();
        return username;
    }
    @FXML
    private void login(ActionEvent event) throws IOException {
        String username = usernameTF.getText();
        String pass = passwordTF.getText();
        String role = aDao.login(username, pass);
        aDao.updateAkun(username, role);
        if (role.equalsIgnoreCase("admin")) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/HomeAdmin.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parentDari);
            stage.setScene(scene);
            stage.show();
        } else if (role.equalsIgnoreCase("mahasiswa")) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/Home.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parentDari);
            stage.setScene(scene);
            stage.show();
        } else if (role.equalsIgnoreCase("dosen")) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/Home.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parentDari);
            stage.setScene(scene);
            stage.show();
        } else if (role.equalsIgnoreCase("gagal")) {
            labelAkunInvalid.setVisible(true);
        }

    }
}
