package hackerrank.regular_expression;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _10_HackerRankLanguage {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<String> langList = Arrays.asList("C:CPP:JAVA:PYTHON:PERL:PHP:RUBY:CSHARP:HASKELL:CLOJURE:BASH:SCALA:ERLANG:CLISP:LUA:BRAINFUCK:JAVASCRIPT:GO:D:OCAML:R:PASCAL:SBCL:DART:GROOVY:OBJECTIVEC".split(":"));

        for( int i = 0; i < n; ++i ) {
            String input [] = sc.nextLine().split(" ");
            int apiId = Integer.parseInt(input[0]);
            if( apiId >= 10000 && apiId < 100000 && langList.contains(input[1]) ) {
                System.out.println("VALID");
            }
            else {
                System.out.println("INVALID");
            }
        }

    }
}