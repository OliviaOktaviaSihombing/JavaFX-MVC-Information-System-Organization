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
import org.kmsi.dao.GaleryDao;
import org.kmsi.model.Galery;
import org.kmsi.model.Mahasiswa;
import org.kmsi.util.HibernateUtil;

public class GaleryDaoImpl implements GaleryDao {

    private String url1, url2, url3;

    @Override
    public void saveGalery(Galery galery, String pathFoto1, String pathFoto2, String pathFoto3) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        File file1 = new File(pathFoto1);
        File file2 = new File(pathFoto2);
        File file3 = new File(pathFoto3);
        byte[] fileBytes1 = null;
        byte[] fileBytes2 = null;
        byte[] fileBytes3 = null;
        try {

            FileInputStream fis1 = new FileInputStream(file1);
            fileBytes1 = new byte[(int) file1.length()];
            fis1.read(fileBytes1);
            fis1.close();

            FileInputStream fis2 = new FileInputStream(file2);
            fileBytes2 = new byte[(int) file2.length()];
            fis2.read(fileBytes2);
            fis2.close();

            FileInputStream fis3 = new FileInputStream(file3);
            fileBytes3 = new byte[(int) file3.length()];
            fis3.read(fileBytes3);
            fis3.close();

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }
        galery.setFoto1(fileBytes1);
        galery.setFoto2(fileBytes2);
        galery.setFoto3(fileBytes3);
        session.save(galery);
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
    public List<Galery> getAllGalery() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Galery> galery = session.createCriteria(Galery.class).list();
        session.getTransaction().commit();
        return galery;
    }

    @Override
    public void getFoto(int id) {
        OutputStream os1 = null, os2 = null, os3 = null;
        try {
            os1 = new FileOutputStream(new File("foto1.jpg"));
            os2 = new FileOutputStream(new File("foto2.jpg"));
            os3 = new FileOutputStream(new File("foto3.jpg"));
            for (Galery galery : getAllGalery()) {
                if (galery.getId() == id) {
                    os1.write(galery.getFoto1());
                    url1 = os1.toString();
                    os1.close();

                    os2.write(galery.getFoto2());
                    url2 = os2.toString();
                    os2.close();

                    os3.write(galery.getFoto3());
                    url3 = os3.toString();
                    os3.close();
                    break;
                }
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

}
