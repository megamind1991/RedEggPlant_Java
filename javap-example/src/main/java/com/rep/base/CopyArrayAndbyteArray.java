package com.rep.base;

import java.util.Arrays;

public class CopyArrayAndbyteArray {
  public static void main(String[] args) {
    // Have an array with 5 elements
    int[] data = {1, 2, 3, 4, 5 };

    // Expand the data array to 7 elements
    int[] d1 = expandArray(data, 7);

    // Truncate the data array to 3 elements
    int[] d2 = expandArray(data, 3);

    System.out.println("Original Array: " + Arrays.toString(data));
    System.out.println("Expanded Array: " + Arrays.toString(d1));
    System.out.println("Truncated Array: " + Arrays.toString(d2));

    // Copy data array to new arrays
    d1 = new int[9];
    d2 = new int[2];
    System.arraycopy(data, 0, d1, 0, 5);
    System.arraycopy(data, 0, d2, 0, 2);
       //from   w ww  .ja va 2 s .co  m
    System.out.println("Original Array: " + Arrays.toString(data));
    System.out.println("Expanded Array: " + Arrays.toString(d1));
    System.out.println("Truncated Array: " + Arrays.toString(d2));


    // 字节数组比较
    byte[] byteArray1 = new byte[]{7,2,1};
    byte[] byteArray2 = new byte[]{7,2,1};
    /*from   www  .  jav a2 s. com*/
    boolean blnResult = Arrays.equals(byteArray1,byteArray2);
    System.out.println("Are two byte arrays equal ? : " + blnResult);


    // 字节数组搜索
    byte bArray[] = {1,2,4,5};

    Arrays.sort(bArray);// w  w  w .  j  a v a  2 s .co  m

    byte searchValue = 2;

    int intResult = Arrays.binarySearch(bArray,searchValue);
    System.out.println("Result of binary search of 2 is : " + intResult);

    searchValue = 3;
    intResult = Arrays.binarySearch(bArray,searchValue);
    System.out.println("Result of binary search of 3 is : " + intResult);
  }

  public static int[] expandArray(int[] oldArray, int newLength) {
    int originalLength = oldArray.length;   
    int[] newArray = new int[newLength];        
    int elementsToCopy = 0;
        
    if (originalLength > newLength) {
      elementsToCopy = newLength;
    } 
    else {
      elementsToCopy = originalLength;
    }

    for (int i = 0; i < elementsToCopy; i++) {
      newArray[i] = oldArray[i];
    }
    return newArray;
  }
}