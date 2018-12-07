package org.kmsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pengumuman")
public class Pengumuman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "topik")
    private String topik;
    @Column(name = "isi")
    private String isi;
    @Column(name = "dari")
    private String dari;
    @Column(name = "tanggal")
    private String tanggal;

    public Pengumuman() {
    }

    public Pengumuman(String topik, String isi, String dari, String tanggal) {
        this.topik = topik;
        this.isi = isi;
        this.dari = dari;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopik() {
        return topik;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getDari() {
        return dari;
    }

    public void setDari(String dari) {
        this.dari = dari;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    
}
