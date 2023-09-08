package lk.ijse.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.bo.custom.UserBo;
import lk.ijse.configaration.SessionFactoryConfig;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public boolean save(User dto) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Serializable save = session.save(dto);
        transaction.commit();
        session.close();
        return save != null;
    }

    @Override
    public boolean update(User dto) {
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(dto);
            transaction.commit();
            return true;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            return false;
        }
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
        try (Session session = SessionFactoryConfig.getInstance().getSession()) {
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            transaction.commit();
            return user;
        }

    }
}
