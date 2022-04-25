package com.juliopredictor.api.Dashboard.Auth.Infrastructure.Repository.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Calendar;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "VERIFICATION_TOKEN")
public class VerificationTokenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VERIFICATION_TOKEN_SEQUENCE")
    @SequenceGenerator(name = "VERIFICATION_TOKEN_SEQUENCE", allocationSize = 1)
    private Long id;

    @Column(name = "TOKEN", nullable = false, unique = true)
    private String token;

    //@Column(name = "ID_USER", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_ID_USER", nullable = false)
    private UserEntity user;

    @Column(name = "EXPIRY_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar expiryDate;

    public VerificationTokenEntity(String token, UserEntity user, Calendar expiryDate) {
        this.token = token;
        this.user = user;
        this.expiryDate = expiryDate;
    }
}
