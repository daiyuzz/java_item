package com.daiyu.jpa.qbe;

import lombok.*;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by dyx on 2021/11/28
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private User user;
}
