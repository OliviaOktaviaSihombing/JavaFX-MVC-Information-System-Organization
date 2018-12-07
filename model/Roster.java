package org.kmsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roster")
public class Roster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "week")
    private int week;
    @Column(name = "kelas")
    private String kelas;
    @Column(name = "hari")
    private String hari;
    @Column(name = "mataKuliah")
    private String mataKuliah;
    @Column(name = "pukul")
    private String pukul;
    @Column(name = "tempat")
    private String tempat;
    @Column(name = "dosen")
    private String dosen;
    @Column(name = "tanggal")
    private String tanggal;

    public Roster() {
    }

    public Roster(int week, String kelas, String hari, String mataKuliah, String pukul, String tempat, String dosen, String tanggal) {
        this.week = week;
        this.kelas = kelas;
        this.hari = hari;
        this.mataKuliah = mataKuliah;
        this.pukul = pukul;
        this.tempat = tempat;
        this.dosen = dosen;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(String mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getPukul() {
        return pukul;
    }

    public void setPukul(String pukul) {
        this.pukul = pukul;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
}
