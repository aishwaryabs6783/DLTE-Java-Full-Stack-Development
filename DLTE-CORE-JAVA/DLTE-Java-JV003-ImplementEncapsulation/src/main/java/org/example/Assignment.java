package org.example;

public class Assignment {
    public static void main(String[] args) {
        customer deposits=new customer();
        deposits.openDeposits();
    }
}

// Inner Class as local member
class customer{
    public void openDeposits(){
        //int loanNumber=123;
        class request{
            private String customerName;
            private int PAN;
            private int Aadhaar;
            private String profession;
            private int cibil;
            private int contact;

            public String request() {
                return customerName;

            }

            public void setCustomerName(String customerName) {
                this.customerName = customerName;
            }

            public String getCustomerName() {
                return customerName;
            }

            public void setProfession(String profession ) {
                this.profession = profession;
            }
            public String getProfession() {
                return profession;
            }

            public int getAadhaar() {
                return Aadhaar;
            }

            public void setAadhaar(int Aadhaar) {
                this.Aadhaar = Aadhaar;
            }
            public int getCibil() {
                return cibil;
            }

            public void setCibil(int cibil) {
                this.cibil = cibil;
            }


            public int getPAN() {
                return PAN;
            }

            public void setPAN(int PAN) {
                this.PAN = PAN;
            }
            public int getContact() {
                return contact;
            }

            public void setContact(int Contact) {
                this.contact = contact;
            }


            // constructor overloading

            // default constructor
            public request(){}
            // parameterized constructor
            public request(String customerName,  int PAN,int Aadhaar,String profession,int cibil,int contact)
            {
                this.customerName=customerName;
                this.PAN=PAN;
                this.Aadhaar=Aadhaar;
                this.profession=profession;
                this.cibil=cibil;
                this.contact=contact;
            }
        }
        request fixed=new request();
        fixed.setCustomerName("arun ");
        fixed.setPAN(45678);
        fixed.setAadhaar(355453);
        fixed.setProfession("doctor");
        fixed.setCibil(1200);
        fixed.setContact(12345677);

        System.out.println(fixed.getCustomerName()+" "+fixed.getAadhaar()+" "+fixed.getProfession()+" "+" "+fixed.getCibil());

        request fde=new request("Arun",456778,34657,"engineer",74884,12345677);

        System.out.println(fde.getAadhaar()+" "+fde.getPAN()+" "+fde.getCustomerName());
        System.out.println("request for loan received");
    }
}

