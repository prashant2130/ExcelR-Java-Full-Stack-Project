package com.service;
import java.util.List;

import com.model.PersonalDetails;
import com.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PersonalDetailsService {
    @Autowired
    private PersonalDetailsRepository personalDetailsRepository;

    public void savePersonalDetails(PersonalDetails personalDetails) {
        personalDetailsRepository.save(personalDetails);
    }

    public PersonalDetails getPersonalDetailsById(Long id) {
        return personalDetailsRepository.findById(id).orElse(null);
    }
    //modified
    // Fetch all employees from the database
    public List<PersonalDetails> getAllEmployees() {
        return personalDetailsRepository.findAll();
    }



    public void updatePersonalDetails(PersonalDetails employee) {
        personalDetailsRepository.save(employee);
    }

    //new

    // Fetch employee details by personal email
    public PersonalDetails getPersonalDetailsByPersonalMail(String personalMail) {
        return personalDetailsRepository.findByPersonalMail(personalMail);
    }

    // Method to delete employee
    public void deleteEmployee(Long id) {
        personalDetailsRepository.deleteById(id);
    }


    //newww
//    public List<PersonalDetails> searchEmployees(String query) {
//        return personalDetailsRepository.findByFullNameContainingIgnoreCaseOrCompanyMailContainingIgnoreCase(query, query);
//    }
    public List<PersonalDetails> searchEmployees(String query) {
        // Call the repository method to search by name or email
        return personalDetailsRepository.searchEmployeesByNameOrEmail(query);
    }

//    public PersonalDetails getPersonalDetailsByEmail(String email) {
//        return personalDetailsRepository.findByCompanyMail(email);
//    }
}
