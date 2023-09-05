package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RoomBO;
import lk.ijse.dto.StudentDTO;

import java.util.List;

public class RoomBOImpl implements RoomBO {
    @Override
    public List<StudentDTO> getAll() {
        return null;
    }

    @Override
    public boolean saveStd(StudentDTO studentDTO) {
        return false;
    }

    @Override
    public boolean updateStd(StudentDTO studentDTO) {
        return false;
    }

    @Override
    public StudentDTO getStudent(String sid) {
        return null;
    }

    @Override
    public boolean deleteStd(String text) {
        return false;
    }
}
