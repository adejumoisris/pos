package org.example.pos.service.implementation;

import lombok.RequiredArgsConstructor;
import org.example.pos.dto.request.CompanyRequest;
import org.example.pos.dto.response.CompanyResponse;
import org.example.pos.model.Company;
import org.example.pos.repository.CompanyRepository;
import org.example.pos.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
   private final CompanyRepository companyRepository;


    @Override
    public CompanyResponse createComapny(CompanyRequest companyRequest) {
        Company company = new Company();
        company.setCompanyEmail(companyRequest.getCompanyEmail());
        company.setCompanyName(companyRequest.getCompanyName());
        company.setCompanyLocation(companyRequest.getCompanyLocation());
        company.setCompanyLogo(companyRequest.getCompanyLogo());
        company.setCompanyPhoneNumber(companyRequest.getCompanyPhoneNumber());

       Company saveCompany =  companyRepository.save(company);

        return new CompanyResponse(saveCompany.getCompanyName());
    }


    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(long id) {
      Optional<Company> optional =  companyRepository.findById(id);
      Company company = null;
      if (optional.isPresent()){
          company = optional.get();
      }else {
          throw new RuntimeException("Company not found for id " + id);
      }

       return company;

    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company updatedCompany = companyRepository.findById(id).get();
        updatedCompany.setCompanyName(companyRequest.getCompanyName());
        updatedCompany.setCompanyLocation(companyRequest.getCompanyLocation());
        updatedCompany.setCompanyLogo(companyRequest.getCompanyLogo());
        updatedCompany.setCompanyPhoneNumber(companyRequest.getCompanyPhoneNumber());
        updatedCompany.setCompanyEmail(companyRequest.getCompanyEmail());
        Company newCompany =  companyRepository.save(updatedCompany);

        return new CompanyResponse(newCompany.getCompanyName());
    }



    @Override
    public void deleteCompany(long id) {

        companyRepository.deleteById(id);
    }

    @Override
    public void saveSingleCompany(Company company) {
        this.companyRepository.save(company);
    }


}
