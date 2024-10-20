package com.controller;

import com.model.PersonalDetails;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.ui.Model;
import javax.validation.Valid; // or jakarta.validation.Valid if using Spring 6+
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;



import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//new
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private PersonalDetailsService personalDetailsService;



    @PostMapping("/savePersonalDetails")
    @ResponseBody
    public String savePersonalDetails(@ModelAttribute PersonalDetails personalDetails) {
        personalDetailsService.savePersonalDetails(personalDetails);
        return "Personal details saved!";
    }


    //modified code




    // Method to view employee details
    @GetMapping("/view/{id}")
    public String viewEmployeeDetails(@PathVariable("id") Long id, Model model) {
        PersonalDetails personalDetails = personalDetailsService.getPersonalDetailsById(id);
        model.addAttribute("personalDetails", personalDetails);
        return "view";  // return the Thymeleaf view page
    }


    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        PersonalDetails employee = personalDetailsService.getPersonalDetailsById(id);
        model.addAttribute("employee", employee);
        return "updateform";  // Thymeleaf template name
    }

    @PostMapping("/update/{id}")
    public String updateEmployeeDetails(
            @PathVariable("id") Long id,
            @ModelAttribute("employee") PersonalDetails updatedEmployee,
            RedirectAttributes redirectAttributes) {

        // Fetch the existing employee by ID
        PersonalDetails existingEmployee = personalDetailsService.getPersonalDetailsById(id);

        if (existingEmployee != null) {
            // Update personal details
            existingEmployee.setFullName(updatedEmployee.getFullName());
            existingEmployee.setDob(updatedEmployee.getDob());
            existingEmployee.setGender(updatedEmployee.getGender());
            existingEmployee.setAge(updatedEmployee.getAge());
            existingEmployee.setCurrentCity(updatedEmployee.getCurrentCity());
            existingEmployee.setCurrentAddressLine1(updatedEmployee.getCurrentAddressLine1());
            existingEmployee.setCurrentAddressLine2(updatedEmployee.getCurrentAddressLine2());
            existingEmployee.setCurrentPincode(updatedEmployee.getCurrentPincode());
            existingEmployee.setPermanentCity(updatedEmployee.getPermanentCity());
            existingEmployee.setPermanentAddressLine1(updatedEmployee.getPermanentAddressLine1());
            existingEmployee.setPermanentAddressLine2(updatedEmployee.getPermanentAddressLine2());
            existingEmployee.setPermanentPincode(updatedEmployee.getPermanentPincode());
            existingEmployee.setMobile(updatedEmployee.getMobile());
            existingEmployee.setPersonalMail(updatedEmployee.getPersonalMail());
            existingEmployee.setEmergencyContactName(updatedEmployee.getEmergencyContactName());
            existingEmployee.setEmergencyContactMobile(updatedEmployee.getEmergencyContactMobile());

            // Update professional details
            existingEmployee.setEmploymentCode(updatedEmployee.getEmploymentCode());
            existingEmployee.setCompanyMail(updatedEmployee.getCompanyMail());
            existingEmployee.setPosition(updatedEmployee.getPosition());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            existingEmployee.setOfficePhone(updatedEmployee.getOfficePhone());
            existingEmployee.setOfficeCity(updatedEmployee.getOfficeCity());
            existingEmployee.setOfficeAddressLine1(updatedEmployee.getOfficeAddressLine1());
            existingEmployee.setOfficeAddressLine2(updatedEmployee.getOfficeAddressLine2());
            existingEmployee.setOfficePincode(updatedEmployee.getOfficePincode());
            existingEmployee.setReportingManager(updatedEmployee.getReportingManager());

            // Update project details
            existingEmployee.setProjectName(updatedEmployee.getProjectName());
            existingEmployee.setClientName(updatedEmployee.getClientName());
            existingEmployee.setProjectStartDate(updatedEmployee.getProjectStartDate());
            existingEmployee.setProjectEndDate(updatedEmployee.getProjectEndDate());
            existingEmployee.setProjectLocation(updatedEmployee.getProjectLocation());
            existingEmployee.setProjectRole(updatedEmployee.getProjectRole());
            existingEmployee.setReportingManagerProject(updatedEmployee.getReportingManagerProject());

            // Update finance details
            existingEmployee.setPanCard(updatedEmployee.getPanCard());
            existingEmployee.setAadharCard(updatedEmployee.getAadharCard());
            existingEmployee.setBankName(updatedEmployee.getBankName());
            existingEmployee.setBranch(updatedEmployee.getBranch());
            existingEmployee.setIfscCode(updatedEmployee.getIfscCode());
            existingEmployee.setCtcBreakup(updatedEmployee.getCtcBreakup());

            // Save the updated employee details
            personalDetailsService.updatePersonalDetails(existingEmployee);

            redirectAttributes.addFlashAttribute("msg", "Employee details updated successfully!");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Employee not found!");
        }
        return "redirect:/admin"; // Redirect back to the list page (or dashboard)

    }




    @GetMapping("/details")
    public String getEmployeeDetailsByEmail(@RequestParam("personalMail") String personalMail, Model model) {
        // Fetch employee details by personal email
        PersonalDetails personalDetails = personalDetailsService.getPersonalDetailsByPersonalMail(personalMail);

        if (personalDetails != null) {
            // Add employee details to the model
            model.addAttribute("personalDetails", personalDetails);
            return "userdetail"; // Renders userdetail.html
        } else {
            // Handle case when employee is not found
            model.addAttribute("error", "Employee not found with email: " + personalMail);
            return "error"; // Render an error page or show a message in the same form
        }
    }


    // Method to handle the delete request
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        // Fetch employee by ID
        PersonalDetails employee = personalDetailsService.getPersonalDetailsById(id);

        if (employee != null) {
            // Delete the employee
            personalDetailsService.deleteEmployee(id);
            // Add success message
            redirectAttributes.addFlashAttribute("msg", "Employee deleted successfully!");
        } else {
            // Add failure message if employee not found
            redirectAttributes.addFlashAttribute("msg", "Employee not found!");
        }

        return "redirect:/admin"; // Redirect back to admin dashboard
    }

//newww
    @GetMapping("/search")
    public String searchEmployees(@RequestParam("query") String query, Model model) {
        // Fetch employees that match the search query (e.g., by name or email)
        List<PersonalDetails> personalDetails = personalDetailsService.searchEmployees(query);

        // Add the employees list to the model
        model.addAttribute("employees", personalDetails);
        model.addAttribute("query", query); // To display search query on the result page

        // Return the updated view with the search results
        return "admin/dashboard"; // Assuming the dashboard page shows the employee list
    }

    // Method to download employee details

@GetMapping("/download/{id}")
public void downloadEmployeeDetailsPdf(@PathVariable("id") Long id, HttpServletResponse response) throws DocumentException, IOException {
    // Set response content type to PDF
    response.setContentType("application/pdf");

    // Set the file name and headers
    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=employee_" + id + "_details.pdf";
    response.setHeader(headerKey, headerValue);

    // Fetch the employee details
    PersonalDetails personalDetails = personalDetailsService.getPersonalDetailsById(id);

    if (personalDetails == null) {
        // Handle the case where employee details are not found
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Employee not found");
        return;
    }

    // Create a PDF document
    Document document = new Document();
    PdfWriter.getInstance(document, response.getOutputStream());

    document.open();

    // Add title
    Paragraph title = new Paragraph("Employee Details", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 24));
    title.setAlignment(Element.ALIGN_CENTER);
    document.add(title);
    document.add(new Paragraph("\n")); // Add some space

    // Add Personal Details Section
    addSectionTitle(document, "Personal Details");
    addPersonalDetailsTable(document, personalDetails);

    // Add Professional Details Section
    addSectionTitle(document, "Professional Details");
    addProfessionalDetailsTable(document, personalDetails);

    // Add Project Details Section
    addSectionTitle(document, "Project Details");
    addProjectDetailsTable(document, personalDetails);

    // Add Finance Details Section
    addSectionTitle(document, "Finance Details");
    addFinanceDetailsTable(document, personalDetails);

    // Close the document
    document.close();
}

    private void addSectionTitle(Document document, String title) throws DocumentException {
        // Create a title for the section
        Paragraph sectionTitle = new Paragraph(title, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
        sectionTitle.setSpacingBefore(20f);
        sectionTitle.setSpacingAfter(10f);
        document.add(sectionTitle);
    }

    private void addPersonalDetailsTable(Document document, PersonalDetails personalDetails) throws DocumentException {
        PdfPTable personalTable = new PdfPTable(2);
        personalTable.setWidthPercentage(100);
        personalTable.setSpacingBefore(10f);
        personalTable.setSpacingAfter(10f);

        // Add rows for personal details
        personalTable.addCell("Full Name");
        personalTable.addCell(personalDetails.getFullName());

        personalTable.addCell("Date of Birth");
        personalTable.addCell(personalDetails.getDob());

        personalTable.addCell("Gender");
        personalTable.addCell(personalDetails.getGender());

        personalTable.addCell("Age");
        personalTable.addCell(String.valueOf(personalDetails.getAge()));

        personalTable.addCell("Current City");
        personalTable.addCell(personalDetails.getCurrentCity());

        personalTable.addCell("Current Address");
        personalTable.addCell(personalDetails.getCurrentAddressLine1() + ", " + personalDetails.getCurrentAddressLine2() + ", " + personalDetails.getCurrentPincode());

        personalTable.addCell("Permanent City");
        personalTable.addCell(personalDetails.getPermanentCity());

        personalTable.addCell("Permanent Address");
        personalTable.addCell(personalDetails.getPermanentAddressLine1() + ", " + personalDetails.getPermanentAddressLine2() + ", " + personalDetails.getPermanentPincode());

        personalTable.addCell("Mobile");
        personalTable.addCell(personalDetails.getMobile());

        personalTable.addCell("Personal Email");
        personalTable.addCell(personalDetails.getPersonalMail());

        personalTable.addCell("Emergency Contact Name");
        personalTable.addCell(personalDetails.getEmergencyContactName());

        personalTable.addCell("Emergency Contact Mobile");
        personalTable.addCell(personalDetails.getEmergencyContactMobile());

        // Add the personal details table to the document
        document.add(personalTable);
    }

    private void addProfessionalDetailsTable(Document document, PersonalDetails personalDetails) throws DocumentException {
        PdfPTable professionalTable = new PdfPTable(2);
        professionalTable.setWidthPercentage(100);
        professionalTable.setSpacingBefore(10f);
        professionalTable.setSpacingAfter(10f);

        // Add rows for professional details
        professionalTable.addCell("Employment Code");
        professionalTable.addCell(personalDetails.getEmploymentCode());

        professionalTable.addCell("Company Email");
        professionalTable.addCell(personalDetails.getCompanyMail());

        professionalTable.addCell("Position");
        professionalTable.addCell(personalDetails.getPosition());

        professionalTable.addCell("Department");
        professionalTable.addCell(personalDetails.getDepartment());

        professionalTable.addCell("Office Phone");
        professionalTable.addCell(personalDetails.getOfficePhone());

        professionalTable.addCell("Office Address");
        professionalTable.addCell(personalDetails.getOfficeAddressLine1() + ", " + personalDetails.getOfficeAddressLine2() + ", " + personalDetails.getOfficePincode());

        professionalTable.addCell("Office City");
        professionalTable.addCell(personalDetails.getOfficeCity());

        professionalTable.addCell("Reporting Manager");
        professionalTable.addCell(personalDetails.getReportingManager());

        // Add the professional details table to the document
        document.add(professionalTable);
    }

    private void addProjectDetailsTable(Document document, PersonalDetails personalDetails) throws DocumentException {
        PdfPTable projectTable = new PdfPTable(2);
        projectTable.setWidthPercentage(100);
        projectTable.setSpacingBefore(10f);
        projectTable.setSpacingAfter(10f);

        // Add rows for project details


        projectTable.addCell("Project Name");
        projectTable.addCell(personalDetails.getProjectName());

        projectTable.addCell("Client Name");
        projectTable.addCell(personalDetails.getClientName());

        projectTable.addCell("Start Date");
        projectTable.addCell(personalDetails.getProjectStartDate());

        projectTable.addCell("End Date");
        projectTable.addCell(personalDetails.getProjectEndDate());

        projectTable.addCell("Project Location");
        projectTable.addCell(personalDetails.getProjectLocation());

        projectTable.addCell("Project Role");
        projectTable.addCell(personalDetails.getProjectRole());

        projectTable.addCell("Reporting Manager (Project)");
        projectTable.addCell(personalDetails.getReportingManagerProject());

        // Add the project details table to the document
        document.add(projectTable);
    }

    private void addFinanceDetailsTable(Document document, PersonalDetails personalDetails) throws DocumentException {
        PdfPTable financeTable = new PdfPTable(2);
        financeTable.setWidthPercentage(100);
        financeTable.setSpacingBefore(10f);
        financeTable.setSpacingAfter(10f);

        // Add rows for finance details
        financeTable.addCell("PAN");
        financeTable.addCell(personalDetails.getPanCard());

        financeTable.addCell("Aadhar");
        financeTable.addCell(personalDetails.getAadharCard());

        financeTable.addCell("Bank Name");
        financeTable.addCell(personalDetails.getBankName());

        financeTable.addCell("Branch");
        financeTable.addCell(personalDetails.getBranch());

        financeTable.addCell("IFSC Code");
        financeTable.addCell(personalDetails.getIfscCode());

        financeTable.addCell("CTC Breakup");
        financeTable.addCell(personalDetails.getCtcBreakup());

        // Add the finance details table to the document
        document.add(financeTable);
    }
}
//

