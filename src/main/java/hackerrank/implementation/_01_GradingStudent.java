package hackerrank.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
https://www.hackerrank.com/challenges/grading/problem
*/

public class _01_GradingStudent {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] grades = new int[n];


        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = sc.nextInt();
            grades[gradesItr] = gradesItem;
        }
        sc.nextLine();

        grades = gradingStudents(grades);

        for( int i : grades ) {
            System.out.println(i);
        }
    }

    static int[] gradingStudents(int[] grades) {
        int length = grades.length;

        for( int i = 0; i < length; ++i ) {
            if( grades[i] >= 38 ) {
                int quotient = ( grades[i] % 5 == 0 ) ? (grades[i]/5) : (grades[i]/5)+1;
                int nextMultipleOf5 = quotient*5;

                if( nextMultipleOf5 - grades[i] < 3 ) {
                    grades[i] = nextMultipleOf5;
                }
            }
        }

        return grades;
    }

}
