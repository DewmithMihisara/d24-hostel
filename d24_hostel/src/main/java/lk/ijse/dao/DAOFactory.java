package lk.ijse.dao;

import lk.ijse.bo.custom.impl.UserBoImpl;
import lk.ijse.dao.custom.impl.StudentDAOImpl;
import lk.ijse.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return factory == null ? new DAOFactory() : factory;
    }

    public enum DAOTypes{
        USER, STUDENT
    }

    public <T extends SuperDAO>T getDAO(DAOTypes types){
        switch (types){
            case USER:
                return (T) new UserDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            default:
                return null;
        }
    }
}
