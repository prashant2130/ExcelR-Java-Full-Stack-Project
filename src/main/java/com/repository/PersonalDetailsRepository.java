package com.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import com.model.PersonalDetails;
import java.util.List;
public interface PersonalDetailsRepository extends JpaRepository<PersonalDetails, Long> {
    // Custom method to find employee by personal email

    // Custom method to find employee by personal email
    PersonalDetails findByPersonalMail(String personalMail);
//neww
    // Search by name or email (case-insensitive)
//    List<PersonalDetails> findByFullNameContainingIgnoreCaseOrCompanyMailContainingIgnoreCase(String fullName, String companyMail);
// Custom query to search by full name or email
@Query("SELECT p FROM PersonalDetails p WHERE p.fullName LIKE %:query% OR p.personalMail LIKE %:query%")
List<PersonalDetails> searchEmployeesByNameOrEmail(@Param("query") String query);
}
