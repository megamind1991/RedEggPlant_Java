package com.rep.base;

import java.util.Arrays;
import java.util.EnumSet;

public class EnumDemo {
    public static void main(String[] args) {
        for (Level s : Level.values()) {
            String name = s.name();//w ww  .j  a v  a 2s  . c o  m
            int ordinal = s.ordinal();
            int days = s.getValue();
            System.out.println("name=" + name +
                    ", ordinal=" + ordinal + ", days=" + days);
        }

        for (Level1 s : Level1.values()) {
            String name = s.name();//from   ww  w.j  a v  a  2 s. com
            String desc = s.toString();
            int ordinal = s.ordinal();
            int projectedTurnaroundDays = s.getValue();
            double projectedCost = s.getProjectedCost();
            System.out.println("name=" + name + ", description=" + desc
                    + ", ordinal=" + ordinal + ", turnaround days="
                    + projectedTurnaroundDays + ", projected cost=" + projectedCost);
        }

        Person.Gender m = Person.Gender.MALE;
        Person.Gender f = Person.Gender.FEMALE;
        System.out.println(m);//from   www.  j a  v a  2 s.  c  o m
        System.out.println(f);

        for (Command cmd : CommandList.values()) {
            cmd.execute();
        }

        // Get all constants of the Day enum
        EnumSet<Day> allDays = EnumSet.allOf(Day.class);
        print(allDays, "All days: " );

        // Get all constants from MONDAY to FRIDAY of the Day enum
        EnumSet<Day> weekDays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        print(weekDays, "Weekdays: ");

        EnumSet<Day> weekends = EnumSet.complementOf(weekDays);
        print(weekends, "Weekends: ");


        Direction field = Direction.WEST;

        System.out.println("field.name(): " + field.name());
        System.out.println("field.ordinal(): " + field.ordinal());
        System.out.println("field.toString(): " + field.toString());
        System.out.println("field.isEqual(WEST): " + field.equals(Direction.WEST));
        System.out.println("field.isEqual(\"WEST\"'): " + field.equals("WEST"));

        System.out.println("field == WEST: " + (field == Direction.WEST));


        System.out.println("field.compareTo(WEST): " + field.compareTo(Direction.WEST));
        System.out.println("field.compareTo(PASSWORD): " + field.compareTo(Direction.East));

        System.out.println("field.valueOf(\"WEST\"): " + field.valueOf("WEST"));

        System.out.println("FieldType.values(): " + Arrays.toString(Direction.values()));

        System.out.println("All books:");

        // print all books in enum Book
        for (Book book : Book.values())
            System.out.printf("%-10s%-45s%s%n", book,
                    book.getTitle(), book.getCopyrightYear());

        System.out.printf("%nDisplay a range of enum constants:%n");

        // print first four books
        for (Book book : EnumSet.range(Book.Java, Book.Cpp))
            System.out.printf("%-10s%-45s%s%n", book,
                    book.getTitle(), book.getCopyrightYear());
    }

    public static void print(EnumSet<Day> days, String msg) {
        System.out.print(msg);
        for(Day d : days) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}

enum Book//from www. j  a  v a 2  s.co  m
{
    // declare constants of enum type
    Java("Java", "2015"),
    C("C", "2013"),
    Internet("Internet", "2012"),
    Cpp("C++", "2014"),
    VB("Visual Basic", "2014"),
    CSharp("Visual C#", "2014");

    // instance fields
    private final String title;
    private final String copyrightYear;

    // enum constructor
    Book(String title, String copyrightYear)
    {
        this.title = title;
        this.copyrightYear = copyrightYear;
    }

    // accessor for field title
    public String getTitle()
    {
        return title;
    }

    // accessor for field copyrightYear
    public String getCopyrightYear()
    {
        return copyrightYear;
    }
}


enum Direction {/*from ww w .  j  av a  2 s  .  c  om*/
    East, WEST, NORTH, SOUTH
}

enum Day {// w  ww  . j a va  2 s . co m
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

class Person {
    public enum Gender {
        MALE, FEMALE
    }
}

enum Level {
    LOW(30), MEDIUM(15), HIGH(7), URGENT(1);

    // Declare an instance variable  
    private int value;

    // Declare a private constructor  
    private Level(int a) {
        this.value = a;
    }

    // Declare a public method to get the turnaround days  
    public int getValue() {
        return value;
    }
}

enum Level1 {
    LOW("Low Priority", 30) {
        public double getProjectedCost() {
            return 1000.0;
        }
    },
    MEDIUM("Medium Priority", 15) {
        public double getProjectedCost() {
            return 2000.0;
        }
    },
    HIGH("High Priority", 7) {
        public double getProjectedCost() {
            return 3000.0;
        }
    },
    URGENT("Urgent Priority", 1) {
        public double getProjectedCost() {
            return 5000.0;
        }
    };

    // Declare instance variables
    private String description;
    private int value;

    // Declare a private constructor
    private Level1(String description, int a) {
        this.description = description;
        this.value = a;
    }

    // Declare a public method to get the turn around days
    public int getValue() {
        return value;
    }

    // Override the toString() method in the Enum class to return description
    @Override
    public String toString() {
        return this.description;
    }

    // Provide getProjectedCost() abstract method, so all constants override and
    // provide
    // implementation for it in their body
    public abstract double getProjectedCost();
}

enum CommandList implements Command {
    RUN {/* w  w  w  .j av  a2s .com*/
        public void execute() {
            System.out.println("Running...");
        }
    },
    JUMP {
        public void execute() {
            System.out.println("Jumping...");
        }
    };

    public abstract void execute();
}

interface Command {
    void execute();
}
