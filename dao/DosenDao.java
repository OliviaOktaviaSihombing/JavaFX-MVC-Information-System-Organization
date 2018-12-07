package org.kmsi.dao;

import java.util.List;
import org.kmsi.model.Dosen;
import org.kmsi.model.Mahasiswa;

public interface DosenDao {
    public void saveDosen(Dosen dosen, String pathFoto);
    public String getPath();
    public void getFoto(String nim);
    public List<Dosen> getAllDosen();
    public String getURLfoto();
    public void setLihat(int id);
    public void defaultLihat();
    public Dosen getDosen(String nid);
    public Dosen getDetailDosen();
    public void changePassword(String username , String pass);
}
