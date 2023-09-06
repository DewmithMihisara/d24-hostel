package lk.ijse.bo;

import lk.ijse.bo.custom.RoomBO;
import lk.ijse.bo.custom.impl.ReservationBOImpl;
import lk.ijse.bo.custom.impl.RoomBOImpl;
import lk.ijse.bo.custom.impl.StudentBOImpl;
import lk.ijse.bo.custom.impl.UserBoImpl;

public class BoFactory {
    private static BoFactory factory;

    private BoFactory(){}

    public static BoFactory getInstance(){
        return factory == null ? new BoFactory() : factory;
    }

    public enum BOTypes{
        USER, STUDENT, ROOM, RESERVATION
    }
    public <T extends SuperBo>T getBo(BOTypes types){
        switch (types){
            case USER:
                return (T) new UserBoImpl();
            case STUDENT:
                return (T) new StudentBOImpl();
            case ROOM:
                return (T) new RoomBOImpl();
            case RESERVATION:
                return (T) new ReservationBOImpl();
            default:
                return null;
        }
    }
}
