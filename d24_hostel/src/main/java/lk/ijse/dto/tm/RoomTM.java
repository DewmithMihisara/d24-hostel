package lk.ijse.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomTM {
    private String id;
    private String type;
    private int qty;
    private String keyMoney;
}
