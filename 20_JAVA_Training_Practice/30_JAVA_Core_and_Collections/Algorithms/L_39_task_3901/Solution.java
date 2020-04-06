package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
Уникальные подстроки
Реализуй метод lengthOfLongestUniqueSubstring таким образом, чтобы он возвращал длину самой длинной подстроки без
повторяющихся символов, найденной в строке полученной в качестве параметра.
Например, для строки "a123bcbcqwe" - 6, а для строки "ttttwt" - 2.
Если анализируемая строка пуста или равна null - верни 0.

Требования:
•	Метод lengthOfLongestUniqueSubstring должен возвращать длину подстроки с максимальным количеством уникальных символов.
•	Метод lengthOfLongestUniqueSubstring должен возвращать 0 для пустой строки, или строки равной null.
•	Метод lengthOfLongestUniqueSubstring должен быть публичным.
•	Метод lengthOfLongestUniqueSubstring должен быть статическим.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter your string: ");
        String s = bufferedReader.readLine();

        System.out.println("The longest unique substring length is: \n" + lengthOfLongestUniqueSubstring(s));
    }

    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();

        for (int k = 0; k < s.length(); k++) {
            String substring = s.substring(k);

            StringBuffer unique = new StringBuffer();
            unique.append(substring.charAt(0));
            point:
            for (int i = 1; i < substring.length(); i++) {
                for (int j = 0; j < unique.length(); j++)
                    if (unique.charAt(j) == substring.charAt(i))
                        break point;

                unique.append(substring.charAt(i));
            }
            list.add(unique.toString().length());
        }

        return Collections.max(list);
    }
}
