package com.cognizant.loan.model;

public class Loan {
    private String number;
    private String type;
    private int loan;
    private int emi;
    private int tenure;

    public Loan(int tenure, int emi, String type, String number, int loan) {
        this.tenure = tenure;
        this.emi = emi;
        this.type = type;
        this.number = number;
        this.loan = loan;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public int getEmi() {
        return emi;
    }

    public void setEmi(int emi) {
        this.emi = emi;
    }
}
