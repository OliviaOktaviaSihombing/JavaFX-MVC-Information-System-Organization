package org.kmsi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.kmsi.dao.AkunDao;
import org.kmsi.dao.PengumumanDao;
import org.kmsi.dao.impl.AkunDaoImpl;
import org.kmsi.dao.impl.PengumumanDaoImpl;
import org.kmsi.model.Pengumuman;
import org.kmsi.model.Pesan;

public class PengumumanController implements Initializable {

    @FXML
    private TableView<Pengumuman> TBPengumuman;
    @FXML
    private TableColumn<Pengumuman, Integer> nomor;
    @FXML
    private TableColumn<Pengumuman, String> pengirim;
    @FXML
    private TableColumn<Pengumuman, String> topik;
    @FXML
    private TableColumn<Pengumuman, String> tanggal;
    @FXML
    private TextArea isiPengumumanTA;
    @FXML
    private Hyperlink linkUser;
    @FXML
    private Button btnChangePassword;
    @FXML
    private Button btnLogOut;
    @FXML
    private ImageView imageViewLogo;

    private PengumumanDao pDao;
    ObservableList<Pengumuman> dataPengumuman;
    private AkunDao aDao;
    private boolean animasiButtonBool;

    public PengumumanController() {
        pDao = new PengumumanDaoImpl();
        TBPengumuman = new TableView<>();
        aDao = new AkunDaoImpl();
    }

    public void loadTablePengumuman() {
        List<Pengumuman> pengumuman = pDao.getAllPengumumanTerUpdate();
        dataPengumuman = FXCollections.observableArrayList(pengumuman);
        pengirim.setCellValueFactory(new PropertyValueFactory<Pengumuman, String>("dari"));
        topik.setCellValueFactory(new PropertyValueFactory<Pengumuman, String>("topik"));
        tanggal.setCellValueFactory(new PropertyValueFactory<Pengumuman, String>("tanggal"));
        TBPengumuman.setItems(dataPengumuman);
        TBPengumuman.setOnMouseClicked((MouseEvent me)
                -> {
            if (me.getClickCount() >= 1) {
                String isi = TBPengumuman.getItems().get(TBPengumuman.getSelectionModel().getSelectedIndex()).getIsi();
                isiPengumumanTA.setText(isi);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTablePengumuman();
        imageViewLogo.setImage(new Image("LOGO.png"));
        linkUser.setText(aDao.getUser());
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
    private void forum(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/Forum.fxml"));
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
    private void ChangePassword(ActionEvent event) throws IOException {
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
