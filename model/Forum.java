package org.kmsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forum")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "tanggal")
    private String tanggal;
    @Column(name = "topik")
    private String topik;
    @Column(name = "dari")
    private String dari;
    @Column(name = "banyakKomentar")
    private int banyakKomentar;
    @Column(name = "dibaca")
    private int dibaca;

    public Forum() {
    }

    public Forum(String tanggal, String topik, String dari) {
        this.tanggal = tanggal;
        this.topik = topik;
        this.dari = dari;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getTopik() {
        return topik;
    }

    public void setTopik(String topik) {
        this.topik = topik;
    }

    public String getDari() {
        return dari;
    }

    public void setDari(String dari) {
        this.dari = dari;
    }

    public int getBanyakKomentar() {
        return banyakKomentar;
    }

    public void setBanyakKomentar(int banyakKomentar) {
        this.banyakKomentar = banyakKomentar;
    }

    public int getDibaca() {
        return dibaca;
    }

    public void setDibaca(int dibaca) {
        this.dibaca = dibaca;
    }
    
}
