package com.example.appteamworklesson1.Entity.user;

import com.example.appteamworklesson1.Entity.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employer extends Auditable {


    @Column(name = "full_name")
    private String fullName;

    @OneToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private PhysicalPerson physicalPerson;


    @OneToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private LegalPerson legalPerson;


    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

}
