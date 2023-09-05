package lk.ijse.bo;

import lk.ijse.bo.custom.impl.StudentBOImpl;
import lk.ijse.bo.custom.impl.UserBoImpl;

public class BoFactory {
    private static BoFactory factory;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return factory == null ? new BoFactory() : factory;
    }

    public enum BOTypes{
        USER, STUDENT
    }
    public <T extends SuperBo>T getBo(BOTypes types){
        switch (types){
            case USER:
                return (T) new UserBoImpl();
            case STUDENT:
                return (T) new StudentBOImpl();
            default:
                return null;
        }
    }
}
