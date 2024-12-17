import java.io.Serializable;

class Faculty implements Serializable {
    private String name;
    private String fatherName;
    private String address;
    private String email;
    private String dob;
    private String empID;
    private String phone;
    private String matricMarks;
    private String interMarks;
    private String qualification;
    private String department;
    private String cnic;

    public Faculty(String name, String fatherName, String address, String email, String dob, String empID, String phone, String matricMarks, String interMarks, String qualification, String department, String cnic) {
        this.name = name;
        this.fatherName = fatherName;
        this.address = address;
        this.email = email;
        this.dob = dob;
        this.empID = empID;
        this.phone = phone;
        this.matricMarks = matricMarks;
        this.interMarks = interMarks;
        this.qualification = qualification;
        this.department = department;
        this.cnic = cnic;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getEmpID() {
        return empID;
    }

    public String getPhone() {
        return phone;
    }

    public String getMatricMarks() {
        return matricMarks;
    }

    public String getInterMarks() {
        return interMarks;
    }

    public String getQualification() {
        return qualification;
    }

    public String getDepartment() {
        return department;
    }

    public String getCnic() {
        return cnic;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", empID='" + empID + '\'' +
                ", phone='" + phone + '\'' +
                ", matricMarks='" + matricMarks + '\'' +
                ", interMarks='" + interMarks + '\'' +
                ", qualification='" + qualification + '\'' +
                ", department='" + department + '\'' +
                ", cnic='" + cnic + '\'' +
                '}';
    }
}
