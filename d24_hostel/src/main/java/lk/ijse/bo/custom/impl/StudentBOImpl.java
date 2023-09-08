package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.StudentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class StudentBOImpl implements StudentBO {
    StudentDAO studentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public List<StudentDTO> getAll() {
        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (Student student : studentDAO.getAll()) {
            studentDTOS.add(new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getDob(),
                    student.getGender())
            );
        }
        return studentDTOS;
    }

    @Override
    public boolean saveStd(StudentDTO studentDTO) {
        return studentDAO.save(new Student(
                studentDTO.getSId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGen()
        ));
    }

    @Override
    public boolean updateStd(StudentDTO studentDTO) {
        return studentDAO.update(new Student(
                studentDTO.getSId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGen()
        ));
    }

    @Override
    public StudentDTO getStudent(String sid) {
        Student student = studentDAO.getItem(sid);
        if (student!=null){
            return new StudentDTO(
                    student.getId(),
                    student.getName(),
                    student.getAddress(),
                    student.getContact(),
                    student.getDob(),
                    student.getGender()
            );
        }
        return null;
    }

    @Override
    public boolean deleteStd(String text) {
        return studentDAO.delete(text);
    }

    @Override
    public String getNextId() {
        String id = studentDAO.getNextId();
        Integer newId = Integer.parseInt(id.replace("ST", "")) + 1;
        return String.format("ST%03d", newId);
    }
}
