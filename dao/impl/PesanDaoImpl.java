package org.kmsi.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.kmsi.dao.PesanDao;
import org.kmsi.model.Pengumuman;
import org.kmsi.model.Pesan;
import org.kmsi.util.HibernateUtil;

public class PesanDaoImpl implements PesanDao {

    @Override
    public void savePesan(Pesan pesan) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(pesan);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Pesan> getAllPesan() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Pesan> pesan = session.createCriteria(Pesan.class).list();
        session.getTransaction().commit();
        return pesan;
    }

    @Override
    public int getPesanBelumDibaca() {
        int banyak = 0;
        for (Pesan pesan : getAllPesan()) {
            if (pesan.getDibaca() == 0) {
                banyak++;
            }
        }
        return banyak;
    }

    @Override
    public void updatePesanDibaca(int id) {
        for (Pesan pesan : getAllPesan()) {
            if (pesan.getId() == id) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                pesan.setDibaca(1);
                session.update(pesan);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

}
