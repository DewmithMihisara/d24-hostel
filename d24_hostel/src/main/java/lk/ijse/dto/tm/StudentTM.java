package lk.ijse.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;

@Data
@AllArgsConstructor
public class StudentTM {
   private String id;
   private String name;
   private Date dob;
   private String contact;
   private String address;
   private String gender;

}
