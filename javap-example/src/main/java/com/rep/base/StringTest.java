package com.rep.base;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTest {
    static String LowerToUpper(String s) {
        String result = "";
        char c;// w ww . j ava 2 s . c om
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                c = (char) (s.charAt(i) - 32); // 32=2^5
            }
            else {
                c = s.charAt(i);
            }
            result += c; // concatenation, append c to result
        }
        return result;
    }

    public static boolean isPalindrome(String inputString) {
        // Check for null argument.
        if (inputString == null) {
            throw new IllegalArgumentException("String cannot be null.");
        }
        // Get the length of string
        int len = inputString.length();
        if (len <= 1) {
            return true;
        }

        // Convert the string into uppercase, so we can make the comparisons case insensitive
        String newStr = inputString.toUpperCase();

        // Initialize the result variable to true
        boolean result = true;

        // Get the number of comparison to be done
        int counter = len / 2;

        for (int i = 0; i < counter; i++) {
            if (newStr.charAt(i) != newStr.charAt(len - 1 - i)) {
                result = false;

                // Exit the loop
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(LowerToUpper("java2s.com")); // Create two string objects

        String str1 = new String();
        String str2 = new String("Hello");

        // Get the length of str1 and str2
        int len1 = str1.length();
        int len2 = str2.length();

        // Display the length of str1 and str2
        System.out.println("Length of \"" + str1 + "\" = " + len1);
        System.out.println("Length of \"" + str2 + "\" = " + len2);

        String str11 = "hello2olleh";
        boolean b1 = isPalindrome(str11);
        System.out.println(str11 + " is a palindrome: " + b1);

        String str22 = "noon";
        boolean b2 = isPalindrome(str22);
        System.out.println(str22 + " is a palindrome: " + b2);

        System.out.println("Comparision Using regionMatches");

        String sentence = "Java 8 is great!";
        String matchStr = "great";
        for (int i = 0; i <= sentence.length() - 1; i++) {
            if (sentence.regionMatches(i, matchStr, 0, matchStr.length())) {
                System.out
                    .println("The sentence: '" + sentence + "' matches: '" + matchStr + "' beginning at index: " + i);
            }
        }

        String myString = " This is a String that contains whitespace.   ";
        // from w ww . j av a 2s. c om
        System.out.println(myString);
        System.out.println(myString.trim());

        String str = "This String will change case.";
        // from w w w. j av a 2 s . c om
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println(str.toUpperCase(Locale.ITALIAN));
        System.out.println(str.toUpperCase(new Locale("it", "US")));
        System.out.println(str.toLowerCase(new Locale("fr", "CA")));

        String charstr = "Break down into chars";
        System.out.println(charstr);
        for (char chr : charstr.toCharArray()) {
            System.out.println(chr);
        }
        str = "Here";

        boolean result = str.matches("Here");
        System.out.println(result);// from w w w. j a v a 2s. c om

        result = str.matches("Here is a long String...");
        System.out.println(result);
        str = "true";
        // This will test against both upper & lower case "T"...this will be TRUE
        result = str.matches("[Tt]rue");
        System.out.println(result);// from w w w .jav a2 s. com

        str = "true";
        // This will test against both upper & lower case "T"...this will be TRUE
        result = str.matches("[Tt]rue|[Ff]alse]");
        System.out.println(result);// w ww. j av a 2 s.com

        str = "I love Java 8!";
        result = str.matches("I love Java [0-9]!");
        System.out.println(result);
        str = "";

        str = "I love Java 8!";

        result = str.matches("I love .*[ 0-9]!");
        System.out.println(result); /* w ww . j a v a2 s . c o m */

        // The following String also matches.
        str = "I love Jython 2.5.4!";
        result = str.matches("I love .*[ 0-9]!");

        System.out.println(result);

        str = "I love Java 9!";
        result = false;

        Pattern pattern = Pattern.compile("I love .*[ 0-9]!");
        Matcher matcher = pattern.matcher(str);
        result = matcher.matches(); /* from ww w . java 2 s .co m */

        System.out.println(result);
        str = "I love Java 8!  Java 8 is the 8th version.";

        pattern = Pattern.compile("[0-9]");
        matcher = pattern.matcher(str);

        System.out.println("Original: " + str);
        System.out.println(matcher.matches());
        System.out.println("Replacement: " + matcher.replaceAll("7"));

        String filename = "test.java";
        System.out.println("Finding file type of: " + filename);
        if (filename.endsWith(".txt")) {
            System.out.println("Text file");
        }
        else if (filename.endsWith(".doc")) {
            System.out.println("Document file");
        }
        else if (filename.endsWith(".xls")) {
            System.out.println("Excel file");
        }
        else if (filename.endsWith(".java")) {
            System.out.println("Java source file");
        }
        else {
            System.out.println("Other type of file");
        }

        double temperature = 8.6;
        String temperatureString = "The current temperature is %.1f degrees Fahrenheit.";

        String newString = String.format(temperatureString, temperature);
        System.out.println(newString);

        temperature = 101.2;

        System.out.println(String.format(temperatureString, temperature));

        String jaText = "this is a test 文字";
        String replaced = jaText.replaceFirst("\u6587\u5B57", "mojibake");
        System.out.printf("Replaced: %s\n", replaced);

        String[] fields = jaText.split("\\s", 3);
        for (String field : fields) {
            System.out.printf("Split: %s\n", field);
        } /* from w ww. j a va2s. co m */

        char[] charArray = {
            'b', 'i', 'r', 't', 'h', ' ', 'd', 'a', 'y'
        };
        String s = new String("hello");

        // use String constructors
        String s1 = new String();
        String s2 = new String(s);
        String s3 = new String(charArray);
        String s4 = new String(charArray, 6, 3);

        System.out.printf("s1 = %s\ns2 = %s\ns3 = %s\ns4 = %s\n", s1, s2, s3, s4);

        s1 = new String("hello");
        s2 = "this is a test";
        s3 = "Happy Birthday";
        s4 = "happy birthday";

        // test regionMatches (case sensitive)
        if (s3.regionMatches(0, s4, 0, 5))
            System.out.println("First 5 characters of s3 and s4 match");
        else
            System.out.println("First 5 characters of s3 and s4 do not match");

        // test regionMatches (ignore case)
        if (s3.regionMatches(true, 0, s4, 0, 5))
            System.out.println("First 5 characters of s3 and s4 match with case ignored");
        else
            System.out.println("First 5 characters of s3 and s4 do not match");

        int[] array = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };
        String results = someMethod(array, 0);
        System.out.println(results);

        String searchMe = "Green Eggs and Ham";
        String findMe = "Eggs";
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;
        for (int i = 0; i <= (searchMeLength - findMeLength); i++) {
            if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                foundIt = true;/* from ww w . j a v a 2s. c o m */
                System.out.println(searchMe.substring(i, i + findMeLength));
                break;
            }
        }
        if (!foundIt)
            System.out.println("No match found.");

    }

    // Returns a version of the input where all contiguous
    // whitespace characters are replaced with a single
    // space. Line terminators are treated like whitespace.
    public static CharSequence removeDuplicateWhitespace(CharSequence inputStr) {
        String patternStr = "\\s+";
        String replaceStr = " ";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(inputStr);
        return matcher.replaceAll(replaceStr);
    }/* from w w w .j av a2 s. co m */

    public static String someMethod(int[] array2, int x) {/* from w ww . j a v a 2 s. c o m */
        if (x < array2.length) {
            String format = String.format("%s %d ", someMethod(array2, x + 1), array2[x]);
            System.out.println(format);
            return format;
        }
        else
            return "";
    }

}