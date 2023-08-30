package lk.ijse.dao;

import lk.ijse.bo.custom.impl.UserBoImpl;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return factory == null ? new DAOFactory() : factory;
    }

    public enum DAOTypes{
        USER
    }

    public <T extends SuperDAO>T getDAO(DAOTypes types){
        switch (types){
            case USER:
                return (T) new UserBoImpl();
            default:
                return null;
        }
    }
}
