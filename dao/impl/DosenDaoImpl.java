package org.kmsi.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.kmsi.dao.DosenDao;
import org.kmsi.model.Dosen;
import org.kmsi.model.Mahasiswa;
import org.kmsi.util.HibernateUtil;

public class DosenDaoImpl implements DosenDao {

    private String URL;

    @Override
    public void saveDosen(Dosen dosen, String pathFoto) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        File file = new File(pathFoto);//ini file fotonya disimpan dimana
        byte[] fileBytes = null;//tipe file yang dibrowse
        try {
            FileInputStream fis = new FileInputStream(file);
            fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            fis.close();
        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        dosen.setFoto(fileBytes);
        session.save(dosen);
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
    public void getFoto(String nid) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File("foto.jpg"));
            for (Dosen dosen : getAllDosen()) {
                if (dosen.getNid().equalsIgnoreCase(nid)) {
                    os.write(dosen.getFoto());
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
    public List<Dosen> getAllDosen() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Dosen> dosen = session.createCriteria(Dosen.class).list();
        session.getTransaction().commit();
        return dosen;
    }

    @Override
    public String getURLfoto() {
        return this.URL;
    }

    @Override
    public void setLihat(int id) {
        for (Dosen dosen : getAllDosen()) {
            if (dosen.getId() == id) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                dosen.setLihat(1);
                session.update(dosen);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public void defaultLihat() {// kalo mau lihat dosen, dosennya harus 1
        for (Dosen dosen : getAllDosen()) {
            if (dosen.getLihat() == 1) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                dosen.setLihat(0);
                session.update(dosen);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public Dosen getDosen(String nid) {
        Dosen dose = new Dosen();
        for (Dosen dosen : getAllDosen()) {
            if (dosen.getNid().equalsIgnoreCase(nid)) {
                dose = dosen;
            }
        }
        return dose;
    }

    @Override
    public Dosen getDetailDosen() {
        OutputStream os = null;
        Dosen dosen = new Dosen();
        try {
            os = new FileOutputStream(new File("foto.jpg"));
            for (Dosen dos : getAllDosen()) {
                if (dos.getLihat() == 1) {
                    dosen = dos;
                    os.write(dos.getFoto());
                    URL = os.toString();
                    os.close();
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

        return dosen;
    }

    @Override
    public void changePassword(String username, String pass) {
        for(Dosen dosen : getAllDosen()){
            if(dosen.getUsername().equalsIgnoreCase(username)){
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                dosen.setPassword(pass);
                session.update(dosen);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

}
