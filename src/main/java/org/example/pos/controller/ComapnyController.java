package org.example.pos.controller;

import lombok.RequiredArgsConstructor;
import org.example.pos.dto.request.CompanyRequest;
import org.example.pos.dto.response.CompanyResponse;
import org.example.pos.model.Company;
import org.example.pos.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping( "/register")
@RequiredArgsConstructor
public class ComapnyController {
    private final CompanyService companyService;

    @PostMapping(name = "/save")
    public CompanyResponse createComapny(@RequestBody @Validated CompanyRequest companyRequest) {
         companyService.createComapny(companyRequest);
         return new CompanyResponse(companyRequest.getCompanyName());
    }

//
//    @GetMapping(path = "/allcompanies")
//    public String getAllCompanies(Model model){
//        List<Company>  companies =  companyService.getAllCompanies();
//        model.addAttribute("companies", companies);
//        return "companies";
//    }
    @GetMapping(path = "/allcompanies")
    public String getAllCompanyDatas(Model model){
        List<Company> companies = companyService.getAllCompanies();
        model.addAttribute("companies", companies);
        return "companies";
    }


    @GetMapping(path = "/{id}")
    public  Company getCompanyById(@PathVariable long id){
      return   companyService.getCompanyById(id);

      // Updating URLS
    }

    @PutMapping("/{id}")
    public  CompanyResponse UpdateCompany(@PathVariable long id , @RequestBody CompanyRequest companyRequest){
        companyService.updateCompany(id, companyRequest);
        return new CompanyResponse(companyRequest.getCompanyName());
    }



    @DeleteMapping("{id}/company")
    public void deleteCompanyById(@PathVariable long id){
        companyService.deleteCompany(id);
    }
    // This is method Handler
    @GetMapping("/showNewCompanyForm")
    public String showNewCompanyForm(Model model){
        Company company = new Company();
        model.addAttribute("company", company);
        return "newCompany";

    }
    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute("company") Company company){
        companyService.saveSingleCompany(company);
        return "redirect:/register/allcompanies";

    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model ){
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "updateCompany";

    }



}
