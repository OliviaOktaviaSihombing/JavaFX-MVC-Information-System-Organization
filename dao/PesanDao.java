package org.kmsi.dao;

import java.util.List;
import org.kmsi.model.Pesan;

public interface PesanDao {
    public void savePesan(Pesan pesan);
    public List<Pesan> getAllPesan();
    public int getPesanBelumDibaca();
    public void updatePesanDibaca(int id);
}
