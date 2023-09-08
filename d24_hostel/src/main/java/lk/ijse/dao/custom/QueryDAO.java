package lk.ijse.dao.custom;

import lk.ijse.dao.SuperDAO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.entity.Reservation;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<ReservationDTO> getAllReservation();
}
