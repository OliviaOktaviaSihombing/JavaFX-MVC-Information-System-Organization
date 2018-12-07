package org.kmsi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.kmsi.dao.PengumumanDao;
import org.kmsi.model.Pengumuman;
import org.kmsi.util.HibernateUtil;

public class PengumumanDaoImpl implements PengumumanDao {

    @Override
    public void savePengumuman(Pengumuman pengumuman) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(pengumuman);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Pengumuman> getAllPengumuman() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Pengumuman> pengumuman = session.createCriteria(Pengumuman.class).list();
        session.getTransaction().commit();        
        return pengumuman;
    }

    @Override
    public List<Pengumuman> getAllPengumumanTerUpdate()
    {
        List<Pengumuman> pengumumanTerUpdate = new ArrayList<>();
        for (int i = getAllPengumuman().size()-1; i >= 0; i--)
        {
            pengumumanTerUpdate.add(getAllPengumuman().get(i));
        }
        return pengumumanTerUpdate;
    }

}
