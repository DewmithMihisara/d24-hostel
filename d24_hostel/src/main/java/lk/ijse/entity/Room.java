package lk.ijse.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id",length = 50)
    private String id;
    @Column(name = "room_type")
    private String type;
    @Column(name = "room_key_money")
    private String key_money;
    @Column(name = "room_qty")
    private int qty;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "room")
    private List<Reservation> reservations = new ArrayList<>();

    public Room(String id, String type, String keyMoney, int qty) {
        this.id=id;
        this.type=type;
        this.key_money=keyMoney;
        this.qty=qty;
    }
}
