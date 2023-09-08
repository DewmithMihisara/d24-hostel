package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;

import java.util.Arrays;
import java.util.List;

public interface RoomBO extends SuperBo {
    List<RoomDTO> getAll();

    boolean saveRoom(RoomDTO roomDTO);

    boolean updateRoom(RoomDTO roomDTO);

    RoomDTO getRoom(String rid);

    boolean deleteRoom(String text);

    String getNextId();
}
