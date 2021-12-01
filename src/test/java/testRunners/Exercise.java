package testRunners;

import java.util.Arrays;

public class Exercise {

    static boolean areAnagram(String str1, String str2) {
        str1 = str1.toLowerCase();
        str1 = str1.replace(" ", "");
        str2 = str2.toLowerCase();
        str2 = str2.replace(" ", "");

        // check if length is same
        if (str1.length() == str2.length()) {

            // convert strings to char array
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();

            // sort the char array
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);

            // if sorted char arrays are same
            // then the string is anagram
            return  Arrays.equals(charArray1, charArray2);
        }
        return false;
    }

    static int findSmallestDistanceAndReturnFirstIndex(final int[] pArray) {
        int lMinimumDistance = Integer.MAX_VALUE;
        int index=0;
        for(int i = 1; i < pArray.length; i++) {
            int lDifference = pArray[i] - pArray[i - 1];
            if(lDifference < lMinimumDistance) {
                lMinimumDistance = lDifference;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        boolean isAnagram = areAnagram("Desperation", "A Rope Ends It");
        System.out.println("Are anagram?"+isAnagram);
        int[] myIntArray = {4,8,6,1,2,9,4};
        int firstIndex = findSmallestDistanceAndReturnFirstIndex(myIntArray);
        System.out.println(firstIndex);
    }
}
