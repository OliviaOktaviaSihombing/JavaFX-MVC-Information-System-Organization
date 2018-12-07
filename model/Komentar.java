package org.kmsi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "komentarforum")
public class Komentar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "idForum")
    private int idForum;
    @Column(name = "isiKomentar")
    private String isiKomentar;
    @Column(name = "dari")
    private String dari;

    public Komentar() {
    }

    public Komentar(int idForum, String isiKomentar, String dari) {
        this.idForum = idForum;
        this.isiKomentar = isiKomentar;
        this.dari = dari;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdForum() {
        return idForum;
    }

    public void setIdForum(int idForum) {
        this.idForum = idForum;
    }

    public String getIsiKomentar() {
        return isiKomentar;
    }

    public void setIsiKomentar(String isiKomentar) {
        this.isiKomentar = isiKomentar;
    }

    public String getDari() {
        return dari;
    }

    public void setDari(String dari) {
        this.dari = dari;
    }
    
}
