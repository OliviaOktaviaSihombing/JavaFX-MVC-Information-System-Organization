package org.kmsi.dao;

import java.util.List;
import org.kmsi.model.Roster;

public interface RosterDao {
    public void saveRoster(Roster roster);
    public List<Roster> getAllRoster();
    public List<Roster> getRoster(String username,String hari);
    public int getWeek(String tanggal);
}
