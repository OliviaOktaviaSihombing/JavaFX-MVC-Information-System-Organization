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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.kmsi.dao.AkunDao;
import org.kmsi.dao.DosenDao;
import org.kmsi.dao.MahasiswaDao;
import org.kmsi.dao.impl.AkunDaoImpl;
import org.kmsi.dao.impl.DosenDaoImpl;
import org.kmsi.dao.impl.MahasiswaDaoImpl;
import org.kmsi.model.Dosen;
import org.kmsi.model.Forum;
import org.kmsi.model.Mahasiswa;

public class ProfilController implements Initializable {
    @FXML
    private ImageView imageViewLogo;
    @FXML
    private ComboBox cboxCariAngkatan;
    @FXML
    private ComboBox cboxCariKelas;
    @FXML
    private TextField nimTF;
    @FXML
    private TextField nidTF;
    @FXML
    private TableView<Mahasiswa> TBMahasiswa;
    @FXML
    private TableColumn<Mahasiswa, String> nim;
    @FXML
    private TableColumn<Mahasiswa, String> namaMhs;
    @FXML
    private TableView<Dosen> TBDosen;
    @FXML
    private TableColumn<Dosen, String> nid;
    @FXML
    private TableColumn<Dosen, String> namaDosen;
    @FXML
    private Hyperlink linkUser;
    @FXML
    private Button btnChangePassword;
    @FXML
    private Button btnLogOut;

    private MahasiswaDao mDao;
    private DosenDao dosenDao;
    ObservableList<Mahasiswa> dataMahasiswa;
    ObservableList<Dosen> dataDosen;
    private AkunDao aDao;
    private boolean animasiButtonBool;;

    public ProfilController() {
        TBDosen = new TableView<>();
        TBMahasiswa = new TableView<>();
        mDao = new MahasiswaDaoImpl();
        dosenDao = new DosenDaoImpl();
        aDao = new AkunDaoImpl();
    }

    public void loadDataSemuaTabel() {
        List<Mahasiswa> mahasiswa = mDao.getAllMahasiswa();
        dataMahasiswa = FXCollections.observableArrayList(mahasiswa);
        nim.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nim"));
        namaMhs.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nama"));
        TBMahasiswa.setItems(dataMahasiswa);
        TBMahasiswa.setOnMouseClicked((MouseEvent me)
                -> {
            if (me.getClickCount() >= 1) {
                Integer id = Integer.valueOf(TBMahasiswa.getItems().get(TBMahasiswa.getSelectionModel().getSelectedIndex()).getId());
                mDao.defaultLihat();
                mDao.setLihat(id);
            }
        });

        List<Dosen> dosen = dosenDao.getAllDosen();
        dataDosen = FXCollections.observableArrayList(dosen);
        nid.setCellValueFactory(new PropertyValueFactory<Dosen, String>("nid"));
        namaDosen.setCellValueFactory(new PropertyValueFactory<Dosen, String>("nama"));
        TBDosen.setItems(dataDosen);
        TBDosen.setOnMouseClicked((MouseEvent me)
                -> {
            if (me.getClickCount() >= 1) {
                Integer id = Integer.valueOf(TBDosen.getItems().get(TBDosen.getSelectionModel().getSelectedIndex()).getId());
                dosenDao.defaultLihat();
                dosenDao.setLihat(id);
            }
        });

    }

    public void loadTabelMhsBerdasarkanAngkatan() {
        String angkatan = (String)cboxCariAngkatan.getValue();
        List<Mahasiswa> mahasiswa = mDao.getMahasiswaAngkatan(angkatan);
        dataMahasiswa = FXCollections.observableArrayList(mahasiswa);
        nim.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nim"));
        namaMhs.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nama"));
        TBMahasiswa.setItems(dataMahasiswa);
        TBMahasiswa.setOnMouseClicked((MouseEvent me)
                -> {
            if (me.getClickCount() >= 1) {
                Integer id = Integer.valueOf(TBMahasiswa.getItems().get(TBMahasiswa.getSelectionModel().getSelectedIndex()).getId());
                mDao.defaultLihat();
                mDao.setLihat(id);
            }
        });
    }
    public void loadTabelMhsBerdasarkanKelas() {
        String kelas = (String)cboxCariKelas.getValue();
        List<Mahasiswa> mahasiswa = mDao.getMahasiswaKelas(kelas);
        dataMahasiswa = FXCollections.observableArrayList(mahasiswa);
        nim.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nim"));
        namaMhs.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nama"));
        TBMahasiswa.setItems(dataMahasiswa);
        TBMahasiswa.setOnMouseClicked((MouseEvent me)
                -> {
            if (me.getClickCount() >= 1) {
                Integer id = Integer.valueOf(TBMahasiswa.getItems().get(TBMahasiswa.getSelectionModel().getSelectedIndex()).getId());
                mDao.defaultLihat();
                mDao.setLihat(id);
            }
        });
    }
    public void loadTabelMhsBerdasarkanNim() {
        String nimm = nimTF.getText();
        Mahasiswa mahasiswa = mDao.getMahasiswa(nimm);
        dataMahasiswa = FXCollections.observableArrayList(mahasiswa);
        nim.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nim"));
        namaMhs.setCellValueFactory(new PropertyValueFactory<Mahasiswa, String>("nama"));
        TBMahasiswa.setItems(dataMahasiswa);
        TBMahasiswa.setOnMouseClicked((MouseEvent me)
                -> {
            if (me.getClickCount() >= 1) {
                Integer id = Integer.valueOf(TBMahasiswa.getItems().get(TBMahasiswa.getSelectionModel().getSelectedIndex()).getId());
                mDao.defaultLihat();
                mDao.setLihat(id);
            }
        });
    }
    public void loadTabelDosenBerdasarkanNid(){
        String nidd = nidTF.getText();
        Dosen dosen = dosenDao.getDosen(nidd);
        dataDosen = FXCollections.observableArrayList(dosen);
        nid.setCellValueFactory(new PropertyValueFactory<Dosen, String>("nid"));
        namaDosen.setCellValueFactory(new PropertyValueFactory<Dosen, String>("nama"));
        TBDosen.setItems(dataDosen);
        TBDosen.setOnMouseClicked((MouseEvent me)
                -> {
            if (me.getClickCount() >= 1) {
                Integer id = Integer.valueOf(TBDosen.getItems().get(TBDosen.getSelectionModel().getSelectedIndex()).getId());
                dosenDao.defaultLihat();
                dosenDao.setLihat(id);
            }
        });
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> angkatan = FXCollections.observableArrayList("2014", "2015");
        cboxCariAngkatan.setItems(angkatan);
        ObservableList<String> kelas = FXCollections.observableArrayList("12SI1", "12SI2", "11SI1", "11SI2");
        cboxCariKelas.setItems(kelas);
        loadDataSemuaTabel();
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
    private void pengmuman(ActionEvent event) throws IOException {
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
    private void cariAngkatan(ActionEvent event) {
        loadTabelMhsBerdasarkanAngkatan();
    }

    @FXML
    private void cariKelas(ActionEvent event) {
        loadTabelMhsBerdasarkanKelas();
    }

    @FXML
    private void cariBerdasarkanNim(ActionEvent event) {
        loadTabelMhsBerdasarkanNim();
        nimTF.setText("");
    }

    @FXML
    private void semuaMahasiswa(ActionEvent event) {
        loadDataSemuaTabel();
    }

    @FXML
    private void lihatProfilMhs(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/ProfilDetailMhs.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cariBerdasarkanNid(ActionEvent event) {
        loadTabelDosenBerdasarkanNid();
        nidTF.setText("");
    }

    @FXML
    private void semuaDosen(ActionEvent event) {
        loadDataSemuaTabel();
    }

    @FXML
    private void lihatProfilDosen(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/ProfilDetailDosen.fxml"));
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
