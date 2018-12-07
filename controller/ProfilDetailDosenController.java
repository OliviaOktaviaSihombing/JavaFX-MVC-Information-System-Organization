/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kmsi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.kmsi.dao.AkunDao;
import org.kmsi.dao.DosenDao;
import org.kmsi.dao.impl.AkunDaoImpl;
import org.kmsi.dao.impl.DosenDaoImpl;
import org.kmsi.model.Dosen;


public class ProfilDetailDosenController implements Initializable {

    @FXML
    private ImageView imageViewLogo;
    @FXML
    private Label nama;
    @FXML
    private Label nid;
    @FXML
    private Label jenisKelamin;
    @FXML
    private Label tempatTanggalLahir;
    @FXML
    private Label alamat;
    @FXML
    private Label agama;
    @FXML
    private ImageView foto;
    @FXML
    private Hyperlink linkUser;
    @FXML
    private Button btnChangePassword;
    @FXML
    private Button btnLogOut;
    @FXML
    private Label emailAkademik;
    
    private AkunDao aDao;
    private DosenDao dDao;
    private boolean animasiButtonBool;

    public ProfilDetailDosenController() {
        aDao = new AkunDaoImpl();
        dDao = new DosenDaoImpl();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageViewLogo.setImage(new Image("LOGO.png"));
        linkUser.setText(aDao.getUser());
        
        Dosen dosen = dDao.getDetailDosen();
        nama.setText(dosen.getNama());
        nid.setText(dosen.getNid());
        jenisKelamin.setText(dosen.getJenisKelamin());
        tempatTanggalLahir.setText(dosen.getTanggalLahir());
        alamat.setText(dosen.getAlamat());
        agama.setText(dosen.getAgama());
        emailAkademik.setText(dosen.getEmailAkademik());
        foto.setImage(new Image("file:foto.jpg"));
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
