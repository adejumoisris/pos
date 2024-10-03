package org.example.pos.service;

import org.example.pos.dto.request.CompanyRequest;
import org.example.pos.dto.response.CompanyResponse;
import org.example.pos.model.Company;

import java.util.List;

public interface CompanyService {
     public  CompanyResponse createComapny(CompanyRequest companyRequest);

     List<Company> getAllCompanies();

     Company getCompanyById(long id);
     // updating a company

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);

     void deleteCompany(long id);
     // saving a single company

    void  saveSingleCompany(Company company);

}
