package com.rep.oop;

public class ZipCodeTest{

    public static void main(String[] arguments) {
        ZipCode zip1 = new ZipCode("444344");
        ZipCode zip2 = new ZipCode("11111");
        if (zip1.getZipCode() != "") {
            System.out.println("Zip1: " + zip1.getZipCode());
        }/*ww  w. ja  v a  2s .com*/
        if (zip2.getZipCode() != "") {
            System.out.println("Zip2: " + zip2.getZipCode());
        }
    }
}

class ZipCode {
    private String zipCode = "";

    public ZipCode(String inZipCode) {
        setZipCode(inZipCode);
    }

    public void setZipCode(String inZipCode) {
        if ((inZipCode.length() == 5) | (inZipCode.length() == 9)) {
            zipCode = inZipCode;
        }
    }

    public String getZipCode() {
        return zipCode;
    }
}