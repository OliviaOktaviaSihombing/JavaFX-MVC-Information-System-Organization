package org.kmsi.controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.kmsi.dao.DosenDao;
import org.kmsi.dao.MahasiswaDao;
import org.kmsi.dao.RosterDao;
import org.kmsi.dao.impl.DosenDaoImpl;
import org.kmsi.dao.impl.MahasiswaDaoImpl;
import org.kmsi.dao.impl.RosterDaoImpl;
import org.kmsi.model.Dosen;
import org.kmsi.model.Mahasiswa;
import org.kmsi.model.Roster;

public class EntryDataController implements Initializable {

    @FXML
    private TextField namaMhsTF;
    @FXML
    private TextField nimTF;
    @FXML
    private ComboBox<String> cboxJKMhs;
    @FXML
    private TextArea alamatMhsTA;
    @FXML
    private ComboBox<String> cboxKelasMhs;
    @FXML
    private TextField dosenWaliTF;
    @FXML
    private TextField angkatanTF;
    @FXML
    private TextField usernameMhsTF;
    @FXML
    private TextField passwordMhsTF;
    @FXML
    private TextField emailAkademikMhsTF;
    @FXML
    private TextField tmpLahirMhsTF;
    @FXML
    private TextField agamaMhsTF;
    @FXML
    private ComboBox cboxTglLahir;
    @FXML
    private ComboBox cboxBulanLahir;
    @FXML
    private ComboBox cboxTahunLahir;
    @FXML
    private ComboBox cboxTglLahirDosen;
    @FXML
    private ComboBox cboxBulanLahirDosen;
    @FXML
    private ComboBox cboxTahunLahirDosen;
    @FXML
    private TextField asalSekolahTF;
    @FXML
    private Label labelPathMhs;
    @FXML
    private Label labelPathDosen;
    @FXML
    private TextField namaDosenTF;
    @FXML
    private TextField nidTF;
    @FXML
    private ComboBox<String> cboxJKDosen;
    @FXML
    private TextArea alamatDosenTA;
    @FXML
    private TextField agamaDosenTF;
    @FXML
    private TextField usernameDosenTF;
    @FXML
    private TextField emailAkademikDosenTF;
    @FXML
    private TextField passwordDosenTF;
    @FXML
    private ComboBox<String> cboxHari;
    @FXML
    private TextField mataKuliahTF;
    @FXML
    private TextField tempatTF;
    @FXML
    private TextField pukulTF;
    @FXML
    private TextField dosenPengajarTF;
    @FXML
    private ComboBox<Integer> cboxWeek;
    @FXML
    private ComboBox<String> cboxKelasRoster;
    @FXML
    private DatePicker datePick;

    private MahasiswaDao mDao;
    private DosenDao dDao;
    private RosterDao rDao;

    public EntryDataController() {
        mDao = new MahasiswaDaoImpl();
        dDao = new DosenDaoImpl();
        rDao = new RosterDaoImpl();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> jenisKelamin = FXCollections.observableArrayList("Pria", "Wanita");
        cboxJKMhs.setItems(jenisKelamin);
        cboxJKDosen.setItems(jenisKelamin);
        ObservableList<String> kelas = FXCollections.observableArrayList("12SI1", "12SI2", "11SI1", "11SI2");
        cboxKelasMhs.setItems(kelas);
        cboxKelasRoster.setItems(kelas);
        ObservableList<String> tanggal = FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        cboxTglLahir.setItems(tanggal);
        cboxTglLahirDosen.setItems(tanggal);
        ObservableList<String> bulan = FXCollections.observableArrayList("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
        cboxBulanLahir.setItems(bulan);
        cboxBulanLahirDosen.setItems(bulan);
        ObservableList<Integer> tahun = FXCollections.observableArrayList(1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998, 1999, 2000);
        ObservableList<Integer> tahunDosen = FXCollections.observableArrayList(1970, 1971, 1972, 1973, 1974, 1975, 1976, 1977, 1987, 1979, 1980, 1981, 1982);
        cboxTahunLahir.setItems(tahun);
        cboxTahunLahirDosen.setItems(tahunDosen);
        ObservableList<Integer> week = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        cboxWeek.setItems(week);
        ObservableList<String> hari = FXCollections.observableArrayList("Senin", "Selasa", "Rabu", "Kamis", "Jumat");
        cboxHari.setItems(hari);

    }

    public void awal() {
        namaMhsTF.setText("");
        nimTF.setText("");
        tempatTF.setText("");
        alamatMhsTA.setText("");
        asalSekolahTF.setText("");
        agamaMhsTF.setText("");
        angkatanTF.setText("");
        usernameMhsTF.setText("");
        passwordMhsTF.setText("");
        emailAkademikMhsTF.setText("");
        labelPathMhs.setText("...");
        labelPathDosen.setText("...");
        namaDosenTF.setText("");
        nidTF.setText("");
        agamaDosenTF.setText("");
        alamatDosenTA.setText("");
        emailAkademikDosenTF.setText("");
        usernameDosenTF.setText("");
        passwordDosenTF.setText("");
        mataKuliahTF.setText("");
        pukulTF.setText("");
        tempatTF.setText("");
        dosenPengajarTF.setText("");
        dosenWaliTF.setText("");
        tmpLahirMhsTF.setText("");
        datePick.getEditor().setText("");

    }

    @FXML
    private void addMahasiswa(ActionEvent event) {
        String nama = namaMhsTF.getText();
        String nim = nimTF.getText();
        String jenisKelamin = (String) cboxJKMhs.getValue();
        String alamat = alamatMhsTA.getText();
        String kelas = (String) cboxKelasMhs.getValue();
        String DosenWali = dosenWaliTF.getText();
        String angkatan = angkatanTF.getText();
        String username = usernameMhsTF.getText();
        String password = passwordMhsTF.getText();
        String emailAkademik = emailAkademikMhsTF.getText();
        String agama = agamaMhsTF.getText();
        String tempatLahir = tmpLahirMhsTF.getText();
        String tanggalLahir = (String) (cboxBulanLahir.getValue() + "/" + cboxTglLahir.getValue() + "/" + cboxTahunLahir.getValue());
        String asalSekolah = asalSekolahTF.getText();
        Mahasiswa mahasiswa = new Mahasiswa(nama, nim, jenisKelamin, alamat, kelas, DosenWali, angkatan, username, password, emailAkademik, agama, tempatLahir, tanggalLahir, asalSekolah);
        mDao.saveMahasiswa(mahasiswa, labelPathMhs.getText());
        awal();
    }

    @FXML
    private void browseMhs(ActionEvent event) {
        labelPathMhs.setText(mDao.getPath());
    }

    @FXML
    private void browseDosen(ActionEvent event) {
        labelPathDosen.setText(dDao.getPath());
    }

    @FXML
    private void addDosen(ActionEvent event) {
        String nama = namaDosenTF.getText();
        String nid = nidTF.getText();
        String jenisKelamin = (String) cboxJKDosen.getValue();
        String alamat = alamatDosenTA.getText();
        String emailAkademik = emailAkademikDosenTF.getText();
        String username = usernameDosenTF.getText();
        String password = passwordDosenTF.getText();
        String agama = agamaDosenTF.getText();
        String tanggalLahir = (String) (cboxBulanLahirDosen.getValue() + "/" + cboxTglLahirDosen.getValue() + "/" + cboxTahunLahirDosen.getValue());
        Dosen dosen = new Dosen(nama, nid, jenisKelamin, alamat, emailAkademik, username, password, agama, tanggalLahir);
        dDao.saveDosen(dosen, labelPathDosen.getText());
        awal();
    }

    @FXML
    private void addRoster(ActionEvent event) {
        int week = (Integer) cboxWeek.getValue();
        String kelas = (String) cboxKelasRoster.getValue();
        String hari = (String) cboxHari.getValue();
        String mataKuliah = mataKuliahTF.getText();
        String pukul = pukulTF.getText();
        String tempat = tempatTF.getText();
        String dosen = dosenPengajarTF.getText();
        String tanggal = (String) (((TextField) datePick.getEditor()).getText());
        Roster roster = new Roster(week, kelas, hari, mataKuliah, pukul, tempat, dosen, tanggal);
        rDao.saveRoster(roster);
        awal();
    }

    @FXML
    private void backHome(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parentDari = FXMLLoader.load(getClass().getResource("/org/kmsi/view/HomeAdmin.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parentDari);
        stage.setScene(scene);
        stage.show();
    }

}
