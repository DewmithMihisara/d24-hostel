package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDTO {
    private String resId;
    private Date date;
    private String stdId;
    private String roomId;
    private String sts;
    private String stdNameTxt;
    private String roomType;
    private String keyMoney;

}
