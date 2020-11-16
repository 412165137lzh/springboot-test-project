package com.lzh.domain.course;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name="course")
//@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  cid;
    private String  cname;
//    private String test;

}
