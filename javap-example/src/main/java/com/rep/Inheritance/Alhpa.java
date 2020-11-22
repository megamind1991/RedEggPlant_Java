package com.rep.Inheritance;

import lombok.Getter;
import lombok.Setter;

public class Alhpa {
    // 这是个，。。。八百年
    private String str1 = "1";

    String str2 = "2";

    protected String str3 = "3";

    public String str4 = "4";

    public Alhpa() {
        System.out.println("父类构造器");
    }

    public void publicMethod() {
        System.out.println("私有方法");
    }

    private void privteehtod() {
        System.out.println("私有方法");
    }

    void packageMehtod() {
        System.out.println("包访问方法");
    }

    protected void protectMethod() {
        System.out.println("保护方法");
    }

    public static void main(String[] args) {
        Alhpa alhpa = new Alhpa();
        System.out.println(alhpa.str1);
    }
}

@Getter
@Setter
class AlphaTwo extends Alhpa {

    public AlphaTwo() {
        System.out.println("子类构造器");
    }

    public static void main(String[] args) {
        Alhpa alhpa = new Alhpa();
        alhpa.publicMethod();
        alhpa.protectMethod();
        alhpa.packageMehtod();
//        alhpa.privteehtod();

//        System.out.println(alhpa.str1);
        System.out.println(alhpa.str2);
        System.out.println(alhpa.str3);
        System.out.println(alhpa.str4);

        AlphaTwo alphaTwo = new AlphaTwo();

        alphaTwo.publicMethod();
        alphaTwo.protectMethod();
        alphaTwo.packageMehtod();
//        alphaTwo.privteehtod();

//        System.out.println(alphaTwo.str1);
        System.out.println(alphaTwo.str2);
        System.out.println(alphaTwo.str3);
        System.out.println(alphaTwo.str4);
    }
}
