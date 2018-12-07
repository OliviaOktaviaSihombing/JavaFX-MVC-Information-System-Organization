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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.kmsi.dao.AkunDao;
import org.kmsi.dao.GaleryDao;
import org.kmsi.dao.impl.AkunDaoImpl;
import org.kmsi.dao.impl.GaleryDaoImpl;
import org.kmsi.model.Forum;
import org.kmsi.model.Galery;

public class GaleryController implements Initializable {

    @FXML
    private ImageView imageViewLogo;
    @FXML
    private Hyperlink linkUser;
    @FXML
    private TableView<Galery> TBGalery;
    @FXML
    private TableColumn<Galery, Integer> no;
    @FXML
    private TableColumn<Galery, String> deskripsi;
    @FXML
    private ImageView foto1;
    @FXML
    private TextArea deskripsiTA;
    @FXML
    private ImageView foto2;
    @FXML
    private ImageView foto3;
    @FXML
    private Button btnBrowse1;
    @FXML
    private Button btnBrowse2;
    @FXML
    private Button btnBrowse3;
    @FXML
    private Label labelPath1;
    @FXML
    private Label labelPath2;
    @FXML
    private Label labelPath3;
    @FXML
    private Button btnAddFoto;
    @FXML
    private Button btnChangePassword;
    @FXML
    private Button btnLogOut;

    private GaleryDao gDao;
    ObservableList<Galery> dataGalery;
    private boolean animasiButtonBool;
    private AkunDao aDao;

    public GaleryController() {
        gDao = new GaleryDaoImpl();
        aDao = new AkunDaoImpl();
    }

    public void loadTabelGalery() {
        List<Galery> galery = gDao.getAllGalery();
        dataGalery = FXCollections.observableArrayList(galery);
        no.setCellValueFactory(new PropertyValueFactory<Galery, Integer>("id"));
        deskripsi.setCellValueFactory(new PropertyValueFactory<Galery, String>("deskripsi"));
        TBGalery.setItems(dataGalery);
        TBGalery.setOnMouseClicked((MouseEvent me)
                -> {
            if (me.getClickCount() >= 1) {
                Integer id = Integer.valueOf(TBGalery.getItems().get(TBGalery.getSelectionModel().getSelectedIndex()).getId());
                gDao.getFoto(id);
                loadFoto();
            }
        });
    }

    public void loadFoto() {
        foto1.setImage(new Image("file:foto1.jpg"));
        foto2.setImage(new Image("file:foto2.jpg"));
        foto3.setImage(new Image("file:foto3.jpg"));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadTabelGalery();
        if (!aDao.getRole().equalsIgnoreCase("admin")) {
            deskripsiTA.setVisible(false);
            labelPath1.setVisible(false);
            labelPath2.setVisible(false);
            labelPath3.setVisible(false);
            btnBrowse1.setVisible(false);
            btnBrowse2.setVisible(false);
            btnBrowse3.setVisible(false);
            btnAddFoto.setVisible(false);
        }
        imageViewLogo.setImage(new Image("LOGO.png"));
        linkUser.setText(aDao.getUser());

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
    private void browse1(ActionEvent event) {
        labelPath1.setText(gDao.getPath());
    }

    @FXML
    private void browse2(ActionEvent event) {
        labelPath2.setText(gDao.getPath());
    }

    @FXML
    private void browse3(ActionEvent event) {
        labelPath3.setText(gDao.getPath());
    }

    @FXML
    private void addFoto(ActionEvent event) {
        String deskripsi = deskripsiTA.getText();
        String path1 = labelPath1.getText();
        String path2 = labelPath2.getText();
        String path3 = labelPath3.getText();
        Galery galery = new Galery(deskripsi);
        gDao.saveGalery(galery, path1, path2, path3);
        loadTabelGalery();
        deskripsiTA.setText("");
        labelPath1.setText("...");
        labelPath2.setText("...");
        labelPath3.setText("...");
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
