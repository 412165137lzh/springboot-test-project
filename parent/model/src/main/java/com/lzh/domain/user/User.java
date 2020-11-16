package com.lzh.domain.user;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Entity
@Table(name="user")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
//@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class User {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String sex;
    @Column
    private Integer age;

    public User() {
    }

   public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public User(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        String str = "-1";
        Double d = new Double(str);
        int i = d.intValue();

        System.out.println(i+"");
    }

}
