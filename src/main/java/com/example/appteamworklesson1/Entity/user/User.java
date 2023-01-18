package com.example.appteamworklesson1.Entity.user;

import com.example.appteamworklesson1.Entity.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User extends Auditable {

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number",unique = true)
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "balance",scale = 2)
    private Double balance=0.0;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role>roles=new HashSet<>();


    @OneToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Employer employer;

    @OneToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Expert expert;


}
