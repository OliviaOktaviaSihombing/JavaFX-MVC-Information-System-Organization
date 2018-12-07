package org.kmsi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.kmsi.dao.KomentarDao;
import org.kmsi.model.Forum;
import org.kmsi.model.Komentar;
import org.kmsi.util.HibernateUtil;

public class KomentarDaoImpl implements KomentarDao {

    @Override
    public void saveKomentar(Komentar komentar) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(komentar);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Komentar> getAllKomentar() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Komentar> komentar = session.createCriteria(Komentar.class).list();
        session.getTransaction().commit();
        return komentar;
    }

    @Override
    public List<String> getKomentarForum(int idForum) {
        List<String> komentars = new ArrayList<>();
        for (Komentar komentar : getAllKomentar()) {
            if (komentar.getIdForum() == idForum) {
                komentars.add("("+komentar.getDari()+")  "+komentar.getIsiKomentar());
            }
        }
        return komentars;
    }

}
