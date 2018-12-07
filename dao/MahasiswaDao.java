package org.kmsi.dao;

import java.util.List;
import org.kmsi.model.Mahasiswa;

public interface MahasiswaDao {
    public void saveMahasiswa(Mahasiswa mahasiswa, String pathFoto);
    public String getPath();
    public void getFoto(String nim);
    public List<Mahasiswa> getAllMahasiswa();
    public String getURLfoto();
    public void setLihat(int id);
    public void defaultLihat();
    public List<Mahasiswa> getMahasiswaAngkatan(String angkatan);
    public List<Mahasiswa> getMahasiswaKelas(String kelas);
    public Mahasiswa getMahasiswa(String nim);
    public Mahasiswa getDetailMahasiswa();
    public void changePassword(String username, String pass);
}
