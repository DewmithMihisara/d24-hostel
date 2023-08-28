package lk.ijse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @Column(name = "res_id")
    private String id;
    @Column(name = "res_date")
    private Date date;
    @Column(name = "res_status")
    private String status;
}
