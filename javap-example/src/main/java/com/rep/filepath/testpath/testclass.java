package com.rep.filepath.testpath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class testclass {
    public static void main(String[] args) {
        System.out.println(humpToLine("extCert2_cert_type99"));
        // f_parent_no_leader
    }

    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]|\\d+", "_$0").toLowerCase();
    }
}
