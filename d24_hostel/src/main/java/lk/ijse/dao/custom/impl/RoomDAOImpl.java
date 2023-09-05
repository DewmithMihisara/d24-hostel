package lk.ijse.dao.custom.impl;

import lk.ijse.configaration.SessionFactoryConfig;
import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.entity.Room;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Room> query = criteriaBuilder.createQuery(Room.class);
            query.from(Room.class);
            List<Room> resultList = session.createQuery(query).getResultList();
            transaction.commit();
            return resultList;
        }
    }

    @Override
    public Room getItem(String id) {
        return null;
    }
}
