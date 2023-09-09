package lk.ijse.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id",length = 50)
    private String id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "student_contact")
    private String contact;
    @Column(name = "student_dob")
    private Date dob;
    @Column(name = "student_gender")
    private String gender;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy =  "student")
    private List<Reservation> reservations = new ArrayList<>();

    public Student(String sId, String name, String address, String contact, Date dob, String gen) {
        this.name=name;
        this.id=sId;
        this.address=address;
        this.contact=contact;
        this.dob=dob;
        this.gender=gen;
    }
}
