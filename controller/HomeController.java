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
import java.util.ArrayList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.kmsi.dao.AkunDao;
import org.kmsi.dao.DosenDao;
import org.kmsi.dao.MahasiswaDao;
import org.kmsi.dao.PengumumanDao;
import org.kmsi.dao.RosterDao;
import org.kmsi.dao.impl.AkunDaoImpl;
import org.kmsi.dao.impl.DosenDaoImpl;
import org.kmsi.dao.impl.MahasiswaDaoImpl;
import org.kmsi.dao.impl.PengumumanDaoImpl;
import org.kmsi.dao.impl.PesanDaoImpl;
import org.kmsi.dao.impl.RosterDaoImpl;
import org.kmsi.model.Dosen;
import org.kmsi.model.Mahasiswa;
import org.kmsi.model.Pengumuman;
import org.kmsi.model.Pesan;
import org.kmsi.model.Roster;

/**
 * FXML Controller class
 *
 * @author FRANS SITUMEANG
 */
public class HomeController implements Initializable {

    @FXML
    private ImageView imageViewLogo;
    @FXML
    private Label labelMingguKe;
    @FXML
    private ComboBox cboxHari;
    @FXML
    private TableView<Roster> TBRoster;
    @FXML
    private TableColumn<Roster, String> mataKuliah;
    @FXML
    private TableColumn<Roster, String> pukul;
    @FXML
    private TableColumn<Roster, String> tempat;
    @FXML
    private TableColumn<Roster, String> dosen;
    @FXML
    private Label labelSelamatUlangTahun;
    @FXML
    private Label labelUserHBD1;
    @FXML
    private Label labelUserHBD5;
    @FXML
    private Label labelUserHBD3;
    @FXML
    private Label labelUserHBD2;
    @FXML
    private Label labelUserHBD4;
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
    private Button btnAddPengumuman;
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
    private Hyperlink linkUser;
    @FXML
    private Button btnChangePassword;
    @FXML
    private Button btnLogOut;

    private AkunDao aDao;
    private PengumumanDao pDao;
    ObservableList<Roster> dataRoster;
    boolean animasiButtonBool;
    private RosterDao rDao;
    private MahasiswaDao mDao;
    private DosenDao dosenDao;

    public HomeController() {
        aDao = new AkunDaoImpl();
        pDao = new PengumumanDaoImpl();
        TBRoster = new TableView<>();
        rDao = new RosterDaoImpl();
        mDao = new MahasiswaDaoImpl();
        dosenDao = new DosenDaoImpl();
    }

    public void loadTabelRoster() {
        String username = linkUser.getText();
        String hari = (String) cboxHari.getValue();
        List<Roster> rosters = rDao.getRoster(username, hari);
        dataRoster = FXCollections.observableArrayList(rosters);
        mataKuliah.setCellValueFactory(new PropertyValueFactory<Roster, String>("mataKuliah"));
        pukul.setCellValueFactory(new PropertyValueFactory<Roster, String>("pukul"));
        tempat.setCellValueFactory(new PropertyValueFactory<Roster, String>("tempat"));
        dosen.setCellValueFactory(new PropertyValueFactory<Roster, String>("dosen"));
        TBRoster.setItems(dataRoster);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> hari = FXCollections.observableArrayList("Senin", "Selasa", "Rabu", "Kamis", "Jumat");
        cboxHari.setItems(hari);
        imageViewLogo.setImage(new Image("LOGO.png"));
        linkUser.setText(aDao.getUser());
        loadTabelRoster();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("M/d/YYYY");
        String tanggal = dateFormat.format(date);
        DateFormat dateFormat1 = new SimpleDateFormat("MM/dd");
        String tanggalUltah = dateFormat1.format(date);
        System.out.println(tanggalUltah);
        labelMingguKe.setText("Jadwal Kuliah Minggu ke - " + rDao.getWeek(tanggal));
        loadPengumunan();
        List<String> userHBD = new ArrayList<>();
        for (Mahasiswa mahasiswa : mDao.getAllMahasiswa()) {
            if ((mahasiswa.getTanggalLahir().substring(0, 5)).equalsIgnoreCase(tanggalUltah)) {
                userHBD.add(mahasiswa.getNama());
            }
        }
        for (Dosen dosen : dosenDao.getAllDosen()) {
            if ((dosen.getTanggalLahir().substring(0, 5)).equalsIgnoreCase(tanggalUltah)) {
                userHBD.add(dosen.getNama());
            }
        }
        if (userHBD.size() > 0) {
            labelSelamatUlangTahun.setVisible(true);
            if (userHBD.size() == 1) {
                labelUserHBD1.setVisible(true);
                labelUserHBD1.setText(userHBD.get(0));
            } else if (userHBD.size() == 2) {
                labelUserHBD1.setVisible(true);
                labelUserHBD1.setText(userHBD.get(0));
                labelUserHBD2.setVisible(true);
                labelUserHBD2.setText(userHBD.get(1));
            } else if (userHBD.size() == 3) {
                labelUserHBD1.setVisible(true);
                labelUserHBD1.setText(userHBD.get(0));
                labelUserHBD2.setVisible(true);
                labelUserHBD2.setText(userHBD.get(1));
                labelUserHBD3.setVisible(true);
                labelUserHBD3.setText(userHBD.get(2));
            } else if (userHBD.size() == 4) {
                labelUserHBD1.setVisible(true);
                labelUserHBD1.setText(userHBD.get(0));
                labelUserHBD2.setVisible(true);
                labelUserHBD2.setText(userHBD.get(1));
                labelUserHBD3.setVisible(true);
                labelUserHBD3.setText(userHBD.get(2));
                labelUserHBD4.setVisible(true);
                labelUserHBD4.setText(userHBD.get(3));
            }else if (userHBD.size() == 5) {
                labelUserHBD1.setVisible(true);
                labelUserHBD1.setText(userHBD.get(0));
                labelUserHBD2.setVisible(true);
                labelUserHBD2.setText(userHBD.get(1));
                labelUserHBD3.setVisible(true);
                labelUserHBD3.setText(userHBD.get(2));
                labelUserHBD4.setVisible(true);
                labelUserHBD4.setText(userHBD.get(3));
                labelUserHBD5.setVisible(true);
                labelUserHBD5.setText(userHBD.get(4));
            }
        }
        String role = aDao.getRole();
        if(role.equalsIgnoreCase("dosen")){
            labelMingguKe.setVisible(false);
            cboxHari.setVisible(false);
            TBRoster.setVisible(false);
        }
        else if(role.equalsIgnoreCase("mahasiswa")){
            topikPengumumanTF.setVisible(false);
            isiPengumumanTA.setVisible(false);
            btnAddPengumuman.setVisible(false);
            labelMingguKe.setVisible(true);
            cboxHari.setVisible(true);
            TBRoster.setVisible(true);
        } 

    }

    public void loadPengumunan() {
        List<Pengumuman> pengumuman = pDao.getAllPengumuman();
        int i = 1;
        for (int j = 0; j < pengumuman.size(); j++) {
            setLabelLinkPengumuman(i, pengumuman);
            i++;
        }
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
    private void tentangSi(ActionEvent event) throws IOException {
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
        DateFormat dateFormat = new SimpleDateFormat("M/d/YYYY");
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

    @FXML
    private void getRoster(ActionEvent event) {
        loadTabelRoster();
    }

}
