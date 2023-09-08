package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;

public interface UserBo extends SuperBo {

    boolean saveUser(UserDTO userDTO);

    UserDTO getUser(UserDTO userDTO);

    boolean uptdUsr(UserDTO userDTO);
}
