package com.rep.base;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class CharTest {

  public static void main(String[] args) {

    int x = 0;/*w  w  w.  j  a va2s  .com*/
    for (int c = 0; c <= 0x10FFFF; c++) {
      if (Character.isDigit(c)) {
        ++x;
        System.out.printf(
            "Codepoint: 0x%04X\tCharacter: %c\tDigit: %d\tName: %s\n", c, c,
            Character.digit(c, 10), Character.getName(c));
      }
      if(x == 10){
        break;
      }
    }
    System.out.printf("Total digits: %d\n", x);


    String original = "software";
    StringBuilder result = new StringBuilder("hi");
    int index = original.indexOf('a');

    // original的第一个index位置的字符 设置在result为0的位置上
    // StringBuilder / StringBuffer 的特殊方法
    /*1*/result.setCharAt(0, original.charAt(0));
    System.out.println(result);
    /*2*/result.setCharAt(1, original.charAt(original.length() - 1));
    System.out.println(result);
    /*3*/
    result.insert(1, original.charAt(4));
    System.out.println(result);
    /*4*/
    result.append(original.substring(1, 4));
    System.out.println(result);
    /*5*/result
            .insert(3, (original.substring(index, index + 2) + " "));

    System.out.println(result);


    // java.text.CharacterIterator 的字符串迭代器
    CharacterIterator it = new StringCharacterIterator("abcd");

    // Iterate over the characters in the forward direction
    for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
      // Use ch ...
    }//from  ww  w . j a  va 2s.co m

    // Iterate over the characters in the backward direction
    for (char ch = it.last(); ch != CharacterIterator.DONE; ch = it.previous()) {
      // Use ch ...
    }

    // Other methods
    char ch = it.first(); // a
    ch = it.current(); // a
    ch = it.next(); // b
    ch = it.current(); // b
    System.out.println(ch);
    ch = it.last(); // d
    int pos = it.getIndex(); // 3
    System.out.println(ch);
    ch = it.next(); // DONE
    pos = it.getIndex(); // 4
    System.out.println(ch);
    ch = it.previous(); // d
    System.out.println(ch);
    ch = it.setIndex(1); // b

    // Change the characters
    ((StringCharacterIterator) it).setText("efgh");
    ch = it.current(); // e

    // Create an iterator on a substring (efgh)
    int begin = 5;
    int end = 9;
    pos = 6;
    it = new StringCharacterIterator("abcd efgh ijkl", begin, end, pos);
    ch = it.current();
    System.out.println(ch);

    ch = it.last();
    System.out.println(ch);
  }
}