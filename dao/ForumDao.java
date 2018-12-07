package org.kmsi.dao;

import java.util.List;
import org.kmsi.model.Forum;

public interface ForumDao {
    public void saveForum(Forum forum);
    public String getTopik();
    public String getPengirim();
    public int getId();
    public void setDibaca(int id);
    public void defaultDibaca();
    public List<Forum> getAllForum();
    public void incrementBanyakKomentar();
}
