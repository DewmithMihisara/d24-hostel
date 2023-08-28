package lk.ijse.entity;

import javax.persistence.*;
import java.util.Date;

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
            referencedColumnName = "student_id",
            insertable = false,
            updatable = false)
    private Student student;
    @ManyToOne
    @JoinColumn(name = "room_id",
            referencedColumnName = "room_id",
            insertable = false,
            updatable = false)
    private Room room;

}
