package Razaktask;

import java.util.Date;

public class Loan {
    private int loannum;

    public int getLoannum() {
        return loannum;
    }

    public void setLoannum(int loannum) {
        this.loannum = loannum;
    }

    public String getBorrowername() {
        return borrowername;
    }

    public void setBorrowername(String borrowername) {
        this.borrowername = borrowername;
    }

    public String getLoantype() {
        return loantype;
    }

    public void setLoantype(String loantype) {
        this.loantype = loantype;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public Date getIssuedate() {
        return issuedate;
    }

    public void setIssuedate(Date issuedate) {
        this.issuedate = issuedate;
    }

    private String borrowername;
    private String loantype;
    private double amt;
    private Date issuedate;

}
