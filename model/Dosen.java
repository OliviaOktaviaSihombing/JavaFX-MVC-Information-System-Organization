package org.kmsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dosen")
public class Dosen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "nid")
    private String nid;
    @Column(name = "jenisKelamin")
    private String jenisKelamin;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "emailAkademik")
    private String emailAkademik;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "agama")
    private String agama;
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "tanggalLahir")
    private String tanggalLahir;
    @Column(name = "lihat")
    private int lihat;
    public Dosen() {
    }

    public Dosen(String nama, String nid, String jenisKelamin, String alamat, String emailAkademik, String username, String password, String agama, String tanggalLahir) {
        this.nama = nama;
        this.nid = nid;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.emailAkademik = emailAkademik;
        this.username = username;
        this.password = password;
        this.agama = agama;
        this.tanggalLahir = tanggalLahir;
    }

    public int getLihat() {
        return lihat;
    }

    public void setLihat(int lihat) {
        this.lihat = lihat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getEmailAkademik() {
        return emailAkademik;
    }

    public void setEmailAkademik(String emailAkademik) {
        this.emailAkademik = emailAkademik;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }
    

}
