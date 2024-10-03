package org.example.pos.model;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "company_data")
public class Company {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String companyName;
    private String  companyLocation;
    private String CompanyLogo;
    private String companyEmail;
    private String companyPhoneNumber;



}
