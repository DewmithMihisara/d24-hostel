package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ReservationBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.QueryDAO;
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
    QueryDAO queryDAO=DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    @Override
    public List<ReservationDTO> getAllReservation() {
        List<ReservationDTO> reservationDTOS = queryDAO.getAllReservation();
        return reservationDTOS;
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

    @Override
    public boolean updateRes(ReservationDTO reservationDTO) {
        Reservation reservation=reservationDAO.getItem(reservationDTO.getResId());
        reservation.setStatus(reservationDTO.getSts());
        reservation.setDate(reservationDTO.getDate());
        return reservationDAO.update(reservation);
    }

    @Override
    public boolean deleteRes(String text) {
        return reservationDAO.delete(text);
    }

    @Override
    public ReservationDTO getResevertion(String rid) {
        Reservation reservation = queryDAO.getItem(rid);
        if (reservation!=null){
            return new ReservationDTO(
                    reservation.getId(),
                    reservation.getDate(),
                    reservation.getStudent().getId(),
                    reservation.getRoom().getId(),
                    reservation.getStatus(),
                    reservation.getStudent().getName(),
                    reservation.getRoom().getType(),
                    reservation.getRoom().getKey_money()
            );
        }
        return null;
    }
}
