package org.kmsi.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.kmsi.dao.AkunDao;
import org.kmsi.model.Akun;
import org.kmsi.model.Dosen;
import org.kmsi.model.Mahasiswa;
import org.kmsi.model.Pengumuman;
import org.kmsi.util.HibernateUtil;

public class AkunDaoImpl implements AkunDao {

    @Override
    public String login(String username, String password) {
        String str = "gagal";
        DosenDaoImpl dDao = new DosenDaoImpl();
        MahasiswaDaoImpl mDao = new MahasiswaDaoImpl();
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")) {
            str = "admin";
        }
        List<Dosen> dosens = dDao.getAllDosen();
        List<Mahasiswa> mahasiswas = mDao.getAllMahasiswa();
        for (Mahasiswa mahasiswa : mahasiswas) {
            if (mahasiswa.getUsername().equalsIgnoreCase(username) && mahasiswa.getPassword().equalsIgnoreCase(password)) {
                str = "mahasiswa";
                break;
            }
        }
        for (Dosen dosen : dosens) {
            if (dosen.getUsername().equalsIgnoreCase(username) && dosen.getPassword().equalsIgnoreCase(password)) {
                str = "dosen";
                break;
            }
        }
        return str;
    }

    @Override
    public void updateAkun(String user, String role) {
        for (Akun akun : getAllAkun()) {
            if (akun.getId() == 1) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                akun.setUsername(user);
                akun.setRole(role);
                session.update(akun);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public List<Akun> getAllAkun() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Akun> akuns = session.createCriteria(Akun.class).list();
        session.getTransaction().commit();
        return akuns;
    }

    @Override
    public String getRole() {
        String str = "belum ada";
        for (Akun akun : getAllAkun()) {
            if (akun.getId() == 1) {
                str = akun.getRole();
                break;
            }
        }
        return str;
    }

    @Override
    public String getUser() {
        String str = null;
        for (Akun akun : getAllAkun()) {
            if (akun.getId() == 1) {
                str = akun.getUsername();
                break;
            }
        }
        return str;
    }

}
