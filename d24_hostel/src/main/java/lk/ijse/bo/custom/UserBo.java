package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBo;
import lk.ijse.dto.UserDTO;

public interface UserBo extends SuperBo {

    boolean saveUser(UserDTO userDTO);

    boolean getUser(UserDTO userDTO);
}
