package lk.ijse.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "student_id")
    private int id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_id")
    private String address;
    @Column(name = "student_contact")
    private String contact;
    @Column(name = "student_dob")
    private Date dob;
    @Column(name = "student_gender")
    private String gender;
}
