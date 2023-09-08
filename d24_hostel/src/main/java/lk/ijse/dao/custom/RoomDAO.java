package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Room;
import java.util.List;

public interface RoomDAO extends CrudDAO<Room, String> {
    String getNextId();
}
