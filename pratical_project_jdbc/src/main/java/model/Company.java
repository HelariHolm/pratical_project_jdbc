package model;

public class Company {

    private int companyId;
    private String companyName;
    private int regCode;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getRegCode() {
        return regCode;
    }

    public void setRegCode(int regCode) {
        this.regCode = regCode;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + companyId +
                ", company_name='" + companyName + '\'' +
                ", reg_code='" + regCode +
                '}';
    }
}
