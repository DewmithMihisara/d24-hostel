package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.entity.Room;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public boolean save(Room dto) {
        return false;
    }

    @Override
    public boolean update(Room dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Room> getAll() {
        return null;
    }

    @Override
    public Room getItem(String id) {
        return null;
    }
}
