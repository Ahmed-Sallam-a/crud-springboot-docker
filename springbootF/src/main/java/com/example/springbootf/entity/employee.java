package com.example.springbootf.entity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "employees")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String emp_first_name;
    @Column (name = "last_name")
    private String emp_last_name;

    //private String emp_dept;
    //private String emp_job;
    @Column (name= "email_id")
    private String emp_email;


    //private String emp_phone;

}
