package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.ReservationDAO;
import lk.ijse.entity.Reservation;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation dto) {
        return false;
    }

    @Override
    public boolean update(Reservation dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Reservation> getAll() {
        return null;
    }

    @Override
    public Reservation getItem(String id) {
        return null;
    }
}
