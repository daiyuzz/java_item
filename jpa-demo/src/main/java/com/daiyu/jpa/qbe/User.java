package com.daiyu.jpa.qbe;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;

/**
 * Created by dyx on 2021/11/28
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "address")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @Enumerated(value = EnumType.STRING)
    private SexEnum sex;

    private Integer age;

    private Instant createTime;

    private Date updateTime;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserAddress> address;

}


