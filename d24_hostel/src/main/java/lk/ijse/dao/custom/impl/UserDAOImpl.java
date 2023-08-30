package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User dto) {
        return false;
    }

    @Override
    public boolean update(User dto) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getItem(String id) {
        return null;
    }
}
