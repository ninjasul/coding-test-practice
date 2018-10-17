package bjoj._01.basic.sort;

/*
국영수

문제
도현이네 반 학생 N명의 이름과 국어, 영어, 수학 점수가 주어진다.
이 때, 다음과 같은 조건으로 학생의 성적을 정렬하는 프로그램을 작성하시오.

국어 점수가 감소하는 순서로
국어 점수가 같으면 영어 점수가 증가하는 순서로
국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)

입력
첫째 줄에 도현이네 반의 학생의 수 N (1 ≤ N ≤ 100,000)이 주어진다.
둘째 줄부터 한 줄에 하나씩 각 학생의 이름, 국어, 영어, 수학 점수가 공백으로 구분해 주어진다.
점수는 1보다 크거나 같고, 100보다 작거나 같은 자연수이다. 이름은 알파벳 대소문자로 이루어진 문자열이고, 길이는 10자리를 넘지 않는다.

출력
문제에 나와있는 정렬 기준으로 정렬한 후 첫째 줄부터 N개의 줄에 걸쳐 각 학생의 이름을 출력한다.

예제 입력 1
12
Junkyu 50 60 100
Sangkeun 80 60 50
Sunyoung 80 70 100
Soong 50 60 90
Haebin 50 60 100
Kangsoo 60 80 100
Donghyuk 80 60 100
Sei 70 70 70
Wonseob 70 70 90
Sanghyun 70 70 80
nsj 80 80 80
Taewhan 50 60 90

예제 출력 1
Donghyuk
Sangkeun
Sunyoung
nsj
Wonseob
Sanghyun
Sei
Kangsoo
Haebin
Junkyu
Soong
Taewhan
*/

import java.util.*;

public class _10825_KorEngMath {

    private static class Student implements Comparable<Student> {

        private String name;
        private int kor;
        private int eng;
        private int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        public String getName() {
            return name;
        }

        public int getKor() {
            return kor;
        }

        public int getEng() {
            return eng;
        }

        public int getMath() {
            return math;
        }

        private int compare( int a, int b, int multiplier ) {
            if( a > b ) {
                return 1 * multiplier;
            }
            else if( a < b ) {
                return (-1) * multiplier;
            }
            else {
                return 0;
            }
        }

        @Override
        public int compareTo(Student o) {
            int [] compareArray = new int [] { kor, o.getKor(), -1, eng, o.getEng(), 1, math, o.getMath(), -1  };

            int result = 0;

            for( int i = 0; i < compareArray.length; i+=3 ) {
                result = Integer.compare( compareArray[i], compareArray[i+1] ) * (compareArray[i+2]);

                if( result != 0 ) break;
            }

            if( result != 0 ) return result;

            return name.compareTo(o.getName());


        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();

        List<Student> studentList = new ArrayList<Student>();
        for( int i = 0; i < cnt; ++i ) {
            String [] input = sc.nextLine().split(" ");
            studentList.add(new Student(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])));
        }

        Collections.sort(studentList);

        for( Student s : studentList ) {
            System.out.println(s.getName());
        }

    }
}