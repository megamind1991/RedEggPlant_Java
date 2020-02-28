package com.rep.statictest;

public class StaticVariableEmployeeCountDemoMain {
    public static void main(String[] args) {// from ww w . j a v a2 s . c o m
                                            // show that count is 0 before creating Employees
        System.out.printf("Employees before instantiation: %d%n", Employee.getCount());

        // create two Employees; count should be 2
        Employee e1 = new Employee("Ana", "Bates");
        Employee e2 = new Employee("Mary", "Lady");

        // show that count is 2 after creating two Employees
        System.out.printf("%nEmployees after instantiation:%n");
        System.out.printf("via e1.getCount(): %d%n", e1.getCount());
        System.out.printf("via e2.getCount(): %d%n", e2.getCount());
        System.out.printf("via Employee.getCount(): %d%n", Employee.getCount());

        // get names of Employees
        System.out.printf("%nEmployee 1: %s %s%nEmployee 2: %s %s%n", e1.getFirstName(), e1.getLastName(),
            e2.getFirstName(), e2.getLastName());
    }
}

class Employee {
    private static int count = 0; // number of Employees created

    private String firstName;

    private String lastName;

    // initialize Employee, add 1 to static count and
    // output String indicating that constructor was called
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        ++count; // increment static count of employees
        System.out.printf("Employee constructor: %s %s; count = %d%n", firstName, lastName, count);
    }

    // get first name
    public String getFirstName() {
        return firstName;
    }

    // get last name
    public String getLastName() {
        return lastName;
    }

    // static method to get static count value
    public static int getCount() {
        return count;
    }
}