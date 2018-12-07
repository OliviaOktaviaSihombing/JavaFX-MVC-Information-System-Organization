package org.kmsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pesantoadmin")
public class Pesan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "isi")
    private String isi;
    @Column(name = "dari")
    private String dari;
    @Column(name = "dibaca")
    private int dibaca;

    public Pesan() {
    }

    public Pesan(String isi, String dari) {
        this.isi = isi;
        this.dari = dari;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getDibaca() {
        return dibaca;
    }

    public void setDibaca(int dibaca) {
        this.dibaca = dibaca;
    }
    
}
