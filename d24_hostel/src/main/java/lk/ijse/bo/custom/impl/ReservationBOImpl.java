package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ReservationBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.ReservationDAO;
import lk.ijse.dao.custom.RoomDAO;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.ReservationDTO;
import lk.ijse.dto.RoomDTO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Reservation;
import lk.ijse.entity.Room;
import lk.ijse.entity.Student;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    RoomDAO roomDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ROOM);
    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);
    ReservationDAO reservationDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RESERVATION);

    @Override
    public List<ReservationDTO> getAllReservation() {
        return null;
    }

    @Override
    public List<String> getRoomIds() {
        List<String> roomIds = new ArrayList<>();
        for (Room room : roomDAO.getAll()) {
            roomIds.add(room.getId());
        }
        return roomIds;
    }

    @Override
    public List<String> getStdId() {
        List<String> stIds = new ArrayList<>();
        for (Student student : studentDAO.getAll()) {
            stIds.add(student.getId());
        }
        return stIds;
    }

    @Override
    public RoomDTO getRoom(String value) {
        Room room = roomDAO.getItem(value);
        return new RoomDTO(
                room.getId(),
                room.getType(),
                room.getQty(),
                room.getKey_money());
    }

    @Override
    public StudentDTO getStd(String value) {
        Student student = studentDAO.getItem(value);
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getAddress(),
                student.getContact(),
                student.getDob(),
                student.getGender()
        );
    }

    @Override
    public boolean saveRes(ReservationDTO reservationDTO) {
        Student student = studentDAO.getItem(reservationDTO.getStdId());
        Room room = roomDAO.getItem(reservationDTO.getRoomId());
        room.setQty(room.getQty() - 1);

        if (roomDAO.update(room)) {
            return reservationDAO.save(new Reservation(
                    reservationDTO.getResId(),
                    reservationDTO.getDate(),
                    reservationDTO.getSts(),
                    student,
                    room
            ));
        }
        return false;
    }
}
