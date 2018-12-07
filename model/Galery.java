package org.kmsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "galery")
public class Galery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "deskripsi")
    private String deskripsi;
    @Column(name = "foto1")
    private byte[] foto1;
    @Column(name = "foto2")
    private byte[] foto2;
    @Column(name = "foto3")
    private byte[] foto3;

    public Galery() {
    }

    public Galery(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public byte[] getFoto1() {
        return foto1;
    }

    public void setFoto1(byte[] foto1) {
        this.foto1 = foto1;
    }

    public byte[] getFoto2() {
        return foto2;
    }

    public void setFoto2(byte[] foto2) {
        this.foto2 = foto2;
    }

    public byte[] getFoto3() {
        return foto3;
    }

    public void setFoto3(byte[] foto3) {
        this.foto3 = foto3;
    }
    
}
