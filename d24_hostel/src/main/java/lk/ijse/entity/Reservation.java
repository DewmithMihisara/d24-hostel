package lk.ijse.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name = "res_id",length = 50)
    private String id;
    @Column(name = "res_date")
    private Date date;
    @Column(name = "res_status")
    private String status;
    @ManyToOne
    @JoinColumn(name = "student_type_id",
            referencedColumnName = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "room_id",
            referencedColumnName = "room_id")
    private Room room;
}
