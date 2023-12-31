package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Student;

public interface StudentDAO extends CrudDAO<Student, String> {
    String getNextId();
}
