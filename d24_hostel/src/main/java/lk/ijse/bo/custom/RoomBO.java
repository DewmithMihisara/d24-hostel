package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;

import java.util.List;

public interface RoomBO extends SuperBo {
    List<RoomDTO> getAll();
}
