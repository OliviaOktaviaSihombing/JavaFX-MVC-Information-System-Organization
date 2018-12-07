package org.kmsi.dao;

import java.util.List;
import org.kmsi.model.Pengumuman;

public interface PengumumanDao {
    public void savePengumuman(Pengumuman pengumuman);
    public List<Pengumuman> getAllPengumuman();
    public List<Pengumuman> getAllPengumumanTerUpdate();
    
}
