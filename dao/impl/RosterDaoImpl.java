package org.kmsi.dao.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.kmsi.dao.MahasiswaDao;
import org.kmsi.dao.RosterDao;
import org.kmsi.model.Mahasiswa;
import org.kmsi.model.Roster;
import org.kmsi.util.HibernateUtil;

public class RosterDaoImpl implements RosterDao {

    @Override
    public void saveRoster(Roster roster) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(roster);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Roster> getAllRoster() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Roster> rosters = session.createCriteria(Roster.class).list();
        session.getTransaction().commit();
        return rosters;
    }

    @Override
    public List<Roster> getRoster(String username, String hari) {
        MahasiswaDao mDao = new MahasiswaDaoImpl();
        RosterDao rDao = new RosterDaoImpl();
        String kelas = null;
        List<Roster> rosters = new ArrayList<>();
        for (Mahasiswa mahasiswa : mDao.getAllMahasiswa()) {
            if (mahasiswa.getUsername().equalsIgnoreCase(username)) {
                kelas = mahasiswa.getKelas();
                break;
            }
        }
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("M/d/YYYY");
        String tanggal = dateFormat.format(date);
        int week = getWeek(tanggal);
        for (Roster roster : rDao.getAllRoster()) {
            if (roster.getWeek() == week && roster.getKelas().equalsIgnoreCase(kelas) && roster.getHari().equalsIgnoreCase(hari)) {
                rosters.add(roster);
            }
        }
        return rosters;
    }

    @Override
    public int getWeek(String tanggal) {
        int week = 0;
        RosterDao rDao = new RosterDaoImpl();
        for (Roster roster : rDao.getAllRoster()) {
            if (roster.getTanggal().equalsIgnoreCase(tanggal)) {
                week = roster.getWeek();
                break;
            }
        }
        return week;
    }

}
