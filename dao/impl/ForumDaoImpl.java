package org.kmsi.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.kmsi.dao.ForumDao;
import org.kmsi.model.Forum;
import org.kmsi.model.Roster;
import org.kmsi.util.HibernateUtil;

public class ForumDaoImpl implements ForumDao {

    @Override
    public void saveForum(Forum forum) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(forum);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public String getTopik() {
        String str = null;
        for (Forum forum : getAllForum()) {
            if (forum.getDibaca() == 1) {
                str = forum.getTopik();
                break;
            }
        }
        return str;
    }

    @Override
    public String getPengirim() {
        String str = null;
        for (Forum forum : getAllForum()) {
            if (forum.getDibaca() == 1) {
                str = forum.getDari();
                break;
            }
        }
        return str;
    }

    @Override
    public void setDibaca(int id) {
        for (Forum forum : getAllForum()) {
            if (forum.getId() == id) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                forum.setDibaca(1);
                session.update(forum);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }

    }

    @Override
    public List<Forum> getAllForum() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Forum> forum = session.createCriteria(Forum.class).list();
        session.getTransaction().commit();
        return forum;
    }

    @Override
    public void defaultDibaca() {
        for (Forum forum : getAllForum()) {
            if (forum.getDibaca() == 1) {
                Session session = HibernateUtil.getSession();//mengkonekkan java ke database
                session.getTransaction().begin();//memulai query
                forum.setDibaca(0);//set dibaca 0
                session.update(forum);
                session.getTransaction().commit();//mengeksekusi query
                HibernateUtil.closeSession();//menutup koneksi ke database
                break;
            }
        }
    }

    @Override
    public int getId() {//id forum yang mana yang lagi dibaca, topik dan pengirim diambil berdasarkan id
        int id = 1;// kau mau ngambil sesuatu berdasarkan apa
        for (Forum forum : getAllForum()) {
            if (forum.getDibaca() == 1) {
                id = forum.getId();
                break;
            }
        }
        return id;
    }

    @Override
    public void incrementBanyakKomentar() {
        for (Forum forum : getAllForum()) {
            if (forum.getDibaca() == 1) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                forum.setBanyakKomentar(forum.getBanyakKomentar() + 1);//set banyak komentar terdahulu ditambah 1
                session.update(forum);//trus diupdate
                session.getTransaction().commit();//dieksekusi query update
                HibernateUtil.closeSession();//ditutup koneksi databasenya
                break;
            }
        }
    }

}
