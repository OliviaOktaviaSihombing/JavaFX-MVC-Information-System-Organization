package org.kmsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nama")
    private String nama;
    @Column(name = "nim")
    private String nim;
    @Column(name = "jenisKelamin")
    private String jenisKelamin;
    @Column(name = "alamat")
    private String alamat;
    @Column(name = "kelas")
    private String kelas;
    @Column(name = "dosenWali")
    private String dosenWali;
    @Column(name = "angkatan")
    private String angkatan;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "emailAkademik")
    private String emailAkademik;
    @Column(name = "agama")
    private String agama;
    @Column(name = "tempatLahir")
    private String tempatLahir;
    @Column(name = "tanggalLahir")
    private String tanggalLahir;
    @Column(name = "asalSekolah")
    private String asalSekolah;
    @Column(name = "foto")
    private byte[] foto;
    @Column(name = "lihat")
    private int lihat;

    public Mahasiswa() {
    }

    public Mahasiswa(String nama) {
        this.nama = nama;
    }

    public Mahasiswa(String nama, String nim, String jenisKelamin, String alamat, String kelas, String dosenWali, String angkatan, String username, String password, String emailAkademik, String agama, String tempatLahir, String tanggalLahir, String asalSekolah) {
        this.nama = nama;
        this.nim = nim;
        this.jenisKelamin = jenisKelamin;
        this.alamat = alamat;
        this.kelas = kelas;
        this.dosenWali = dosenWali;
        this.angkatan = angkatan;
        this.username = username;
        this.password = password;
        this.emailAkademik = emailAkademik;
        this.agama = agama;
        this.tempatLahir = tempatLahir;
        this.tanggalLahir = tanggalLahir;
        this.asalSekolah = asalSekolah;
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

    public int getLihat() {
        return lihat;
    }

    public void setLihat(int lihat) {
        this.lihat = lihat;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
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

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getDosenWali() {
        return dosenWali;
    }

    public void setDosenWali(String dosenWali) {
        this.dosenWali = dosenWali;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
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

    public String getEmailAkademik() {
        return emailAkademik;
    }

    public void setEmailAkademik(String emailAkademik) {
        this.emailAkademik = emailAkademik;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}
