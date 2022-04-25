package com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_SEQUENCE")
    @SequenceGenerator(name = "user_SEQUENCE", allocationSize = 1)
    private Long id;

    @Column(name="EMAIL",nullable = false, unique = true)
    private String email;

    @Column(name="PASSWORD",nullable = false)
    private String password;

    @Column(name="CREATED",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar created;

    @Column(name="ENABLE",nullable = false)
    private Boolean enable;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_USER_ROL", nullable = false)
    private UserRolEntity userRol;

    public UserEntity(String email, String password, Calendar created, Boolean enable, UserRolEntity userRol) {
        this.email = email;
        this.password = password;
        this.created = created;
        this.enable = enable;
        this.userRol = userRol;
    }
}