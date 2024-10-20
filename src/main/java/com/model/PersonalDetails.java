//package com.model;
//
//import javax.persistence.*;
//import lombok.Data;
//
//@Entity
//@Data
//public class PersonalDetails {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String fullName;
//    private String dob;
//    private String gender;
//    private int age;
//    private String currentCity;
//    private String currentAddressLine1;
//    private String currentAddressLine2;
//    private String currentPincode;
//    private String permanentCity;
//    private String permanentAddressLine1;
//    private String permanentAddressLine2;
//    private String permanentPincode;
//    private String mobile;
//    private String personalMail;
//    private String emergencyContactName;
//    private String emergencyContactMobile;
//    public String getPermanentPincode() {
//        return permanentPincode;
//    }
//
//    public void setPermanentPincode(String permanentPincode) {
//        this.permanentPincode = permanentPincode;
//    }
//
//
//
//
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public String getDob() {
//        return dob;
//    }
//
//    public void setDob(String dob) {
//        this.dob = dob;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public String getCurrentCity() {
//        return currentCity;
//    }
//
//    public void setCurrentCity(String currentCity) {
//        this.currentCity = currentCity;
//    }
//
//    public String getCurrentAddressLine1() {
//        return currentAddressLine1;
//    }
//
//    public void setCurrentAddressLine1(String currentAddressLine1) {
//        this.currentAddressLine1 = currentAddressLine1;
//    }
//
//    public String getCurrentAddressLine2() {
//        return currentAddressLine2;
//    }
//
//    public void setCurrentAddressLine2(String currentAddressLine2) {
//        this.currentAddressLine2 = currentAddressLine2;
//    }
//
//    public String getCurrentPincode() {
//        return currentPincode;
//    }
//
//    public void setCurrentPincode(String currentPincode) {
//        this.currentPincode = currentPincode;
//    }
//
//    public String getPermanentCity() {
//        return permanentCity;
//    }
//
//    public void setPermanentCity(String permanentCity) {
//        this.permanentCity = permanentCity;
//    }
//
//    public String getPermanentAddressLine1() {
//        return permanentAddressLine1;
//    }
//
//    public void setPermanentAddressLine1(String permanentAddressLine1) {
//        this.permanentAddressLine1 = permanentAddressLine1;
//    }
//
//    public String getPermanentAddressLine2() {
//        return permanentAddressLine2;
//    }
//
//    public void setPermanentAddressLine2(String permanentAddressLine2) {
//        this.permanentAddressLine2 = permanentAddressLine2;
//    }
//
//    public String getMobile() {
//        return mobile;
//    }
//
//    public void setMobile(String mobile) {
//        this.mobile = mobile;
//    }
//
//    public String getPersonalMail() {
//        return personalMail;
//    }
//
//    public void setPersonalMail(String personalMail) {
//        this.personalMail = personalMail;
//    }
//
//    public String getEmergencyContactName() {
//        return emergencyContactName;
//    }
//
//    public void setEmergencyContactName(String emergencyContactName) {
//        this.emergencyContactName = emergencyContactName;
//    }
//
//    public String getEmergencyContactMobile() {
//        return emergencyContactMobile;
//    }
//
//    public void setEmergencyContactMobile(String emergencyContactMobile) {
//        this.emergencyContactMobile = emergencyContactMobile;
//    }
//
//
//}


package com.model;
import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class PersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String dob;
    private String gender;
    private int age;
    private String currentCity;
    private String currentAddressLine1;
    private String currentAddressLine2;
    private String currentPincode;
    private String permanentCity;
    private String permanentAddressLine1;
    private String permanentAddressLine2;
    private String permanentPincode;
    private String mobile;
    private String personalMail;
    private String emergencyContactName;

    public String getPermanentCity() {
        return permanentCity;
    }

    public void setPermanentCity(String permanentCity) {
        this.permanentCity = permanentCity;
    }



    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getCurrentAddressLine1() {
        return currentAddressLine1;
    }

    public void setCurrentAddressLine1(String currentAddressLine1) {
        this.currentAddressLine1 = currentAddressLine1;
    }

    public String getCurrentAddressLine2() {
        return currentAddressLine2;
    }

    public void setCurrentAddressLine2(String currentAddressLine2) {
        this.currentAddressLine2 = currentAddressLine2;
    }

    public String getCurrentPincode() {
        return currentPincode;
    }

    public void setCurrentPincode(String currentPincode) {
        this.currentPincode = currentPincode;
    }

    public String getPermanentAddressLine1() {
        return permanentAddressLine1;
    }

    public void setPermanentAddressLine1(String permanentAddressLine1) {
        this.permanentAddressLine1 = permanentAddressLine1;
    }

    public String getPermanentAddressLine2() {
        return permanentAddressLine2;
    }

    public void setPermanentAddressLine2(String permanentAddressLine2) {
        this.permanentAddressLine2 = permanentAddressLine2;
    }

    public String getPermanentPincode() {
        return permanentPincode;
    }

    public void setPermanentPincode(String permanentPincode) {
        this.permanentPincode = permanentPincode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPersonalMail() {
        return personalMail;
    }

    public void setPersonalMail(String personalMail) {
        this.personalMail = personalMail;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactMobile() {
        return emergencyContactMobile;
    }

    public void setEmergencyContactMobile(String emergencyContactMobile) {
        this.emergencyContactMobile = emergencyContactMobile;
    }

    private String emergencyContactMobile;


    private String employmentCodeProfessional;
    private String companyMail;
    private String position;
    private String department;
    private String officePhone;

    public String getOfficeCity() {
        return officeCity;
    }

    public void setOfficeCity(String officeCity) {
        this.officeCity = officeCity;
    }



    public String getEmploymentCodeProfessional() {
        return employmentCodeProfessional;
    }

    public void setEmploymentCodeProfessional(String employmentCodeProfessional) {
        this.employmentCodeProfessional = employmentCodeProfessional;
    }

    public String getCompanyMail() {
        return companyMail;
    }

    public void setCompanyMail(String companyMail) {
        this.companyMail = companyMail;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getOfficeAddressLine1() {
        return officeAddressLine1;
    }

    public void setOfficeAddressLine1(String officeAddressLine1) {
        this.officeAddressLine1 = officeAddressLine1;
    }

    public String getOfficeAddressLine2() {
        return officeAddressLine2;
    }

    public void setOfficeAddressLine2(String officeAddressLine2) {
        this.officeAddressLine2 = officeAddressLine2;
    }

    public String getOfficePincode() {
        return officePincode;
    }

    public void setOfficePincode(String officePincode) {
        this.officePincode = officePincode;
    }

    private String officeCity;
    private String officeAddressLine1;
    private String officeAddressLine2;
    private String officePincode;


    public String getReportingManager() {
        return ReportingManager;
    }

    public void setReportingManager(String reportingManager) {
        ReportingManager = reportingManager;
    }

    private  String ReportingManager;



    private String projectCode;

    public String getProjectStartDate() {
        return projectStartDate;
    }

    public void setProjectStartDate(String projectStartDate) {
        this.projectStartDate = projectStartDate;
    }



    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectEndDate() {
        return projectEndDate;
    }

    public void setProjectEndDate(String projectEndDate) {
        this.projectEndDate = projectEndDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getReportingManagerProject() {
        return reportingManagerProject;
    }

    public void setReportingManagerProject(String reportingManagerProject) {
        this.reportingManagerProject = reportingManagerProject;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public String getProjectRole() {
        return ProjectRole;
    }

    public void setProjectRole(String projectRole) {
        ProjectRole = projectRole;
    }

    public String ProjectRole;
    private String ProjectName;
    private String projectStartDate;
    private String projectEndDate;
    private String clientName;
    private String reportingManagerProject;
    public String getEmploymentCode() {
        return EmploymentCode;
    }

    public void setEmploymentCode(String employmentCode) {
        EmploymentCode = employmentCode;
    }

    private  String EmploymentCode;

    public String getProjectLocation() {
        return ProjectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        ProjectLocation = projectLocation;
    }

    private String ProjectLocation;




    private String panCard;
    private String aadharCard;
    private String bankName;

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }



    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getCtcBreakup() {
        return ctcBreakup;
    }

    public void setCtcBreakup(String ctcBreakup) {
        this.ctcBreakup = ctcBreakup;
    }

    private String branch;
    private String ifscCode;
    private String ctcBreakup;
}

