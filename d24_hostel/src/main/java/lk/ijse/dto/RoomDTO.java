package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomDTO {
    private String id;
    private String type;
    private int qty;
    private String keyMoney;
}
