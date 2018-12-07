package org.kmsi.dao;

import java.util.List;
import org.kmsi.model.Galery;

public interface GaleryDao {
    public void saveGalery(Galery galery, String pathFoto1, String pathFoto2, String pathFoto3);
    public String getPath();
    public List<Galery> getAllGalery();
    public void getFoto(int id);
}
