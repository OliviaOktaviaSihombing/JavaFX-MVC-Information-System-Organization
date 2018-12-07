package org.kmsi.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.kmsi.dao.MahasiswaDao;
import org.kmsi.model.Forum;
import org.kmsi.model.Mahasiswa;
import org.kmsi.util.HibernateUtil;

public class MahasiswaDaoImpl implements MahasiswaDao {

    private String URL;

    @Override
    public void saveMahasiswa(Mahasiswa mahasiswa, String pathFoto) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        File file = new File(pathFoto);
        byte[] fileBytes = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            fis.close();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        mahasiswa.setFoto(fileBytes);
        session.save(mahasiswa);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public String getPath() {
        String str = new String();
        FileChooser filechose = new FileChooser();
        File file;
        Stage stage = new Stage();
        file = filechose.showOpenDialog(stage);
        str = (String) file.getAbsolutePath();
        return str;
    }

    @Override
    public void getFoto(String nim) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("foto.jpg"));
            for (Mahasiswa mahasiswa : getAllMahasiswa()) {
                if (mahasiswa.getNim().equalsIgnoreCase(nim)) {
                    os.write(mahasiswa.getFoto());
                    URL = os.toString();
                    os.close();
                    break;
                }
            }
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
    }

    @Override
    public List<Mahasiswa> getAllMahasiswa() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Mahasiswa> mhs = session.createCriteria(Mahasiswa.class).list();
        session.getTransaction().commit();
        return mhs;
    }

    @Override
    public String getURLfoto() {
        return this.URL;
    }

    @Override
    public void setLihat(int id) {
        for (Mahasiswa mahasiswa : getAllMahasiswa()) {
            if (mahasiswa.getId() == id) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                mahasiswa.setLihat(1);
                session.update(mahasiswa);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void defaultLihat() {
        for (Mahasiswa mahasiswa : getAllMahasiswa()) {
            if (mahasiswa.getLihat() == 1) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                mahasiswa.setLihat(0);
                session.update(mahasiswa);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public List<Mahasiswa> getMahasiswaAngkatan(String angkatan) {
        List<Mahasiswa> mhs = new ArrayList<>();
        for (Mahasiswa mahasiswa : getAllMahasiswa()) {
            if (mahasiswa.getAngkatan().equalsIgnoreCase(angkatan)) {
                mhs.add(mahasiswa);
            }
        }
        return mhs;
    }

    @Override
    public List<Mahasiswa> getMahasiswaKelas(String kelas) {
        List<Mahasiswa> mhs = new ArrayList<>();
        for (Mahasiswa mahasiswa : getAllMahasiswa()) {
            if (mahasiswa.getKelas().equalsIgnoreCase(kelas)) {
                mhs.add(mahasiswa);
            }
        }
        return mhs;
    }

    @Override
    public Mahasiswa getMahasiswa(String nim) {
        Mahasiswa mhs = new Mahasiswa();
        for (Mahasiswa mahasiswa : getAllMahasiswa()) {
            if (mahasiswa.getNim().equalsIgnoreCase(nim)) {
                mhs = mahasiswa;
                break;
            }
        }
        return mhs;
    }

    @Override
    public Mahasiswa getDetailMahasiswa() {
        OutputStream os = null;
        Mahasiswa mahasiswa = new Mahasiswa();
        try {
            os = new FileOutputStream(new File("foto.jpg"));
            for (Mahasiswa mhs : getAllMahasiswa()) {
                if (mhs.getLihat() == 1) {
                    mahasiswa = mhs;
                    os.write(mhs.getFoto());
                    URL = os.toString();
                    os.close();
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return mahasiswa;
    }

    @Override
    public void changePassword(String username, String pass) {
        for (Mahasiswa mahasiswa : getAllMahasiswa()) {
            if (mahasiswa.getUsername().equalsIgnoreCase(username)) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                mahasiswa.setPassword(pass);
                session.update(mahasiswa);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

}
