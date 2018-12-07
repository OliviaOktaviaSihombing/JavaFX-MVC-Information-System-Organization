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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.kmsi.dao.AkunDao;
import org.kmsi.dao.PengumumanDao;
import org.kmsi.dao.PesanDao;
import org.kmsi.dao.impl.AkunDaoImpl;
import org.kmsi.dao.impl.PengumumanDaoImpl;
import org.kmsi.dao.impl.PesanDaoImpl;
import org.kmsi.model.Pengumuman;
import org.kmsi.model.Pesan;

public class HomeAdminController implements Initializable 
{

    @FXML
    private ImageView imageViewLogo;
    @FXML
    private Hyperlink linkPengumuman1;
    @FXML
    private Hyperlink linkPengumuman2;
    @FXML
    private Hyperlink linkPengumuman3;
    @FXML
    private Hyperlink linkPengumuman5;
    @FXML
    private Hyperlink linkPengumuman7;
    @FXML
    private Hyperlink linkPengumuman8;
    @FXML
    private Hyperlink linkPengumuman9;
    @FXML
    private Hyperlink linkPengumuman10;
    @FXML
    private Hyperlink linkPengumuman6;
    @FXML
    private Hyperlink linkPengumuman4;
    @FXML
    private TextField topikPengumumanTF;
    @FXML
    private TextArea isiPengumumanTA;
    @FXML
    private Label labelPengirim1;
    @FXML
    private Label labelPengirim2;
    @FXML
    private Label labelPengirim3;
    @FXML
    private Label labelPengirim4;
    @FXML
    private Label labelPengirim6;
    @FXML
    private Label labelPengirim7;
    @FXML
    private Label labelPengirim5;
    @FXML
    private Label labelPengirim8;
    @FXML
    private Label labelPengirim10;
    @FXML
    private Label labelPengirim9;
    @FXML
    private Label labelPesanBaru;
    @FXML
    private TableView<Pesan> TBPengirimPesan;
    @FXML
    private TableColumn<Pesan, Integer> noID;
    @FXML
    private TableColumn<Pesan, String> pengirim;
    @FXML
    private TextArea textAreaIsiPesan;
    @FXML
    private Hyperlink linkUser;
    @FXML
    private Button btnLogout;
     @FXML
    private Button btnChangePassword;

    private AkunDao aDao;
    private PengumumanDao pDao;
    private PesanDao pesanDao;
    ObservableList<Pesan> dataPesan;
    boolean animasiButtonBool;

    public HomeAdminController() {
        aDao = new AkunDaoImpl();
        pDao = new PengumumanDaoImpl();
        pesanDao = new PesanDaoImpl();
        TBPengirimPesan = new TableView<>();
    }

    public void loadTabelPesan() {
        List<Pesan> pesan = pesanDao.getAllPesan();
        dataPesan = FXCollections.observableArrayList(pesan);
        noID.setCellValueFactory(new PropertyValueFactory<Pesan, Integer>("id"));
        pengirim.setCellValueFactory(new PropertyValueFactory<Pesan, String>("dari"));
        TBPengirimPesan.setItems(dataPesan);
        TBPengirimPesan.setOnMouseClicked((MouseEvent me)
                -> {
            if (me.getClickCount() >= 1) {
                String isi = TBPengirimPesan.getItems().get(TBPengirimPesan.getSelectionModel().getSelectedIndex()).getIsi();
                Integer id = Integer.valueOf(TBPengirimPesan.getItems().get(TBPengirimPesan.getSelectionModel().getSelectedIndex()).getId());
                textAreaIsiPesan.setText(isi);
                pesanDao.updatePesanDibaca(id);
                labelPesanBaru.setText("(" + pesanDao.getPesanBelumDibaca() + ") pesan baru");
            }
        });
    }

    public void loadPengumunan() {
        List<Pengumuman> pengumuman = pDao.getAllPengumuman();
        int i = 1;
        for (int j = 0; j < pengumuman.size(); j++) {
            setLabelLinkPengumuman(i, pengumuman);
            i++;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageViewLogo.setImage(new Image("LOGO.png"));
        linkUser.setText(aDao.getUser());
        loadPengumunan();
        loadTabelPesan();
        labelPesanBaru.setText("(" + pesanDao.getPesanBelumDibaca() + ") pesan baru");
    }

    public void setLabelLinkPengumuman(int i, List<Pengumuman> pengumuman) {
        if (i == 1) {
            labelPengirim1.setText(pengumuman.get(pengumuman.size() - i).getDari());
            linkPengumuman1.setText(pengumuman.get(pengumuman.size() - i).getTopik());
            labelPengirim1.setVisible(true);
            linkPengumuman1.setVisible(true);
        } else if (i == 2) {
            labelPengirim2.setText(pengumuman.get(pengumuman.size() - i).getDari());
            linkPengumuman2.setText(pengumuman.get(pengumuman.size() - i).getTopik());
            labelPengirim2.setVisible(true);
            linkPengumuman2.setVisible(true);
        } else if (i == 3) {
            labelPengirim3.setText(pengumuman.get(pengumuman.size() - i).getDari());
            linkPengumuman3.setText(pengumuman.get(pengumuman.size() - i).getTopik());
            labelPengirim3.setVisible(true);
            linkPengumuman3.setVisible(true);
        } else if (i == 4) {
            labelPengirim4.setText(pengumuman.get(pengumuman.size() - i).getDari());
            linkPengumuman4.setText(pengumuman.get(pengumuman.size() - i).getTopik());
            labelPengirim4.setVisible(true);
            linkPengumuman4.setVisible(true);
        } else if (i == 5) {
            labelPengirim5.setText(pengumuman.get(pengumuman.size() - i).getDari());
            linkPengumuman5.setText(pengumuman.get(pengumuman.size() - i).getTopik());
            labelPengirim5.setVisible(true);
            linkPengumuman5.setVisible(true);
        } else if (i == 6) {
            labelPengirim6.setText(pengumuman.get(pengumuman.size() - i).getDari());
            linkPengumuman6.setText(pengumuman.get(pengumuman.size() - i).getTopik());
            labelPengirim6.setVisible(true);
            linkPengumuman6.setVisible(true);
        } else if (i == 7) {
            labelPengirim7.setText(pengumuman.get(pengumuman.size() - i).getDari());
            linkPengumuman7.setText(pengumuman.get(pengumuman.size() - i).getTopik());
            labelPengirim7.setVisible(true);
            linkPengumuman7.setVisible(true);
        } else if (i == 8) {
            labelPengirim8.setText(pengumuman.get(pengumuman.size() - i).getDari());
            linkPengumuman8.setText(pengumuman.get(pengumuman.size() - i).getTopik());
            labelPengirim8.setVisible(true);
            linkPengumuman8.setVisible(true);
        } else if (i == 9) {
            labelPengirim9.setText(pengumuman.get(pengumuman.size() - i).getDari());
            linkPengumuman9.setText(pengumuman.get(pengumuman.size() - i).getTopik());
            labelPengirim9.setVisible(true);
            linkPengumuman9.setVisible(true);
        } else if (i == 10) {
            labelPengirim10.setText(pengumuman.get(pengumuman.size() - i).getDari());
            linkPengumuman10.setText(pengumuman.get(pengumuman.size() - i).getTopik());
            labelPengirim10.setVisible(true);
            linkPengumuman10.setVisible(true);
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
    private void addPengumuman(ActionEvent event) {
        String topik = topikPengumumanTF.getText();
        String isi = isiPengumumanTA.getText();
        String dari = aDao.getUser();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/YYYY");
        String tanggal = dateFormat.format(date);
        Pengumuman pengumuman = new Pengumuman(topik, isi, dari, tanggal);
        pDao.savePengumuman(pengumuman);
        awal();
        loadPengumunan();
    }

    public void awal() {
        topikPengumumanTF.setText("");
        isiPengumumanTA.setText("");
    }

    @FXML
    private void entryData(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/EntryData.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void animasiButton(ActionEvent event) {
        if (!animasiButtonBool) {
            linkUser.setLayoutX(550);            
            btnLogout.setVisible(true);
            btnChangePassword.setVisible(true);
            animasiButtonBool = !animasiButtonBool;
        } else {
            linkUser.setLayoutX(700);            
            btnLogout.setVisible(false);
            btnChangePassword.setVisible(false);
            animasiButtonBool = !animasiButtonBool;
        }
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
    @FXML
    private void changePassword(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/ChangePassword.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

}
