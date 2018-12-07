/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kmsi.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.kmsi.dao.AkunDao;
import org.kmsi.dao.ForumDao;
import org.kmsi.dao.impl.AkunDaoImpl;
import org.kmsi.dao.impl.ForumDaoImpl;
import org.kmsi.model.Forum;
import org.kmsi.model.Pengumuman;

/**
 * FXML Controller class
 *
 * @author FRANS SITUMEANG
 */
public class ForumController implements Initializable {

    @FXML
    private ImageView imageViewLogo;
    @FXML
    private TableView<Forum> TBForum;
    @FXML
    private TableColumn<Forum, Integer> nomor;
    @FXML
    private TableColumn<Forum, String> pengirim;
    @FXML
    private TableColumn<Forum, String> topik;
    @FXML
    private TableColumn<Forum, String> tanggal;
    @FXML
    private TableColumn<Forum, Integer> komentar;
    @FXML
    private TextField topikForumTF;
    @FXML
    private Hyperlink linkUser;
    @FXML
    private Button btnChangePassword;
    @FXML
    private Button btnLogOut;

    private AkunDao aDao;
    private ForumDao fDao;
    ObservableList<Forum> dataForum;
    private boolean animasiButtonBool;

    public ForumController() {
        aDao = new AkunDaoImpl();
        fDao = new ForumDaoImpl();
        TBForum = new TableView<>();
    }

    public void loadTabelForum() {
        List<Forum> forum = fDao.getAllForum();
        dataForum = FXCollections.observableArrayList(forum);
        nomor.setCellValueFactory(new PropertyValueFactory<Forum, Integer>("id"));
        pengirim.setCellValueFactory(new PropertyValueFactory<Forum, String>("dari"));
        topik.setCellValueFactory(new PropertyValueFactory<Forum, String>("topik"));
        tanggal.setCellValueFactory(new PropertyValueFactory<Forum, String>("tanggal"));
        komentar.setCellValueFactory(new PropertyValueFactory<Forum, Integer>("banyakKomentar"));
        TBForum.setItems(dataForum);
        TBForum.setOnMouseClicked((MouseEvent me)
                -> {
            if (me.getClickCount() >= 1) {
                Integer id = Integer.valueOf(TBForum.getItems().get(TBForum.getSelectionModel().getSelectedIndex()).getId());
                fDao.defaultDibaca();
                fDao.setDibaca(id);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageViewLogo.setImage(new Image("LOGO.png"));
        linkUser.setText(aDao.getUser());
        loadTabelForum();
    }

    @FXML
    private void bukaForum(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/ForumKomentar.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void home(ActionEvent event) throws IOException {
        if (!aDao.getRole().equalsIgnoreCase("admin")) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/Home.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parentDari);
            stage.setScene(scene);
            stage.show();
        } else {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/HomeAdmin.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parentDari);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void pengumuman(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/Pengumuman.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void profil(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/Profil.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void galery(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/Galery.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void tentangSI(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/TentangSI.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void contactAdmin(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/ContactAdmin.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addForum(ActionEvent event) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        String tanggal = dateFormat.format(date);
        String topik = topikForumTF.getText();
        String dari = linkUser.getText();
        Forum forum = new Forum(tanggal, topik, dari);
        if (!topikForumTF.getText().equalsIgnoreCase("")) {
            fDao.saveForum(forum);
        }
        loadTabelForum();
        topikForumTF.setText("");
    }

    @FXML
    private void animasiButton(ActionEvent event) {
        if (!animasiButtonBool) {
            linkUser.setLayoutX(550);
            btnLogOut.setVisible(true);
            btnChangePassword.setVisible(true);
            animasiButtonBool = !animasiButtonBool;
        } else {
            linkUser.setLayoutX(700);
            btnLogOut.setVisible(false);
            btnChangePassword.setVisible(false);
            animasiButtonBool = !animasiButtonBool;
        }
    }

    @FXML
    private void changePassword(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/ChangePassword.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void logOut(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/Login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

}
