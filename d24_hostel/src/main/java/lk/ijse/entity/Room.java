package lk.ijse.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "room_id")
    private String id;
    @Column(name = "room_type")
    private String type;
    @Column(name = "room_key_money")
    private String key_money;
    @Column(name = "room_qty")
    private int qty;
}
