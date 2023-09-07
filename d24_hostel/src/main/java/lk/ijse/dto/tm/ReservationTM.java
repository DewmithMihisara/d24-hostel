package lk.ijse.dto.tm;



import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
@Data
@AllArgsConstructor
public class ReservationTM {
    private String resId;
    private String roomId;
    private String stdId;
    private String stdName;
    private Date date;
    private String keyMoney;
    private String sts;
    private Date exDate;
}
