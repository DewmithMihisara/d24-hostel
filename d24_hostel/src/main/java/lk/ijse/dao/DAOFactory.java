package lk.ijse.dao;

import lk.ijse.bo.custom.impl.UserBoImpl;
import lk.ijse.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return factory == null ? new DAOFactory() : factory;
    }

    public enum DAOTypes {
        USER, STUDENT, ROOM, RESERVATION, QUERY
    }

    public <T extends SuperDAO> T getDAO(DAOTypes types) {
        switch (types) {
            case USER:
                return (T) new UserDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case ROOM:
                return (T) new RoomDAOImpl();
            case RESERVATION:
                return (T) new ReservationDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }
}
