package lk.ijse.dao.custom.impl;

import lk.ijse.configaration.SessionFactoryConfig;
import lk.ijse.dao.custom.ReservationDAO;
import lk.ijse.entity.Reservation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public boolean save(Reservation dto) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            Serializable save = session.save(dto);
            transaction.commit();
            return save != null;
        }
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
