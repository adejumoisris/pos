package org.example.pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequest {
    private String companyName;
    private String  companyLocation;
    private String CompanyLogo;
    private String companyEmail;
    private String companyPhoneNumber;
}
