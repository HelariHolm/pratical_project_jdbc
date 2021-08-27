package model;

public class Company {

    private int company_id;
    private String company_name;
    private int reg_code;

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public int getReg_code() {
        return reg_code;
    }

    public void setReg_code(int reg_code) {
        this.reg_code = reg_code;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_id=" + company_id +
                ", company_name='" + company_name + '\'' +
                ", reg_code='" + reg_code +
                '}';
    }
}
