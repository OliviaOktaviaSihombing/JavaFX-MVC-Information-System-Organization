package org.kmsi.dao;

import java.util.List;
import org.kmsi.model.Komentar;

public interface KomentarDao {
    public void saveKomentar(Komentar komentar);
    public List<Komentar> getAllKomentar();
    public List<String> getKomentarForum(int idForum);
}
