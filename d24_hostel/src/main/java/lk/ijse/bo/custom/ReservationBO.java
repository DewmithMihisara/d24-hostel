package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;

import java.util.List;

public interface ReservationBO extends SuperBo {
    List<ReservationDTO> getAllReservation();

   List<String> getRoomIds();

    List<String> getStdId();

    RoomDTO getRoom(String value);

    StudentDTO getStd(String value);

    boolean saveRes(ReservationDTO reservationDTO);
}
