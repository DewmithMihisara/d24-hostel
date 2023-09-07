package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.StudentDTO;

import java.util.List;

public interface ReservationBO extends SuperBo {
    List<ReservationDTO> getAllReservation();
}
