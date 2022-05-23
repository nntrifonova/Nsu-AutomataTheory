package ru.nsu.trifonova;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private Scanner scanner = new Scanner(System.in);
    private static HashSet<Character> N = new HashSet<Character>();
    private static HashSet<Character> T = new HashSet<Character>();
    private static Multimap<Character, char[]> P = ArrayListMultimap.create();
    private static Character S;

    public static void main (String[] args) {
        System.out.println("Enter Context Free Grammar:");

        Parser parser = new Parser();
        N = parser.parseN();
        T = parser.parseT(N);
        P = parser.parseP(N, T);
        S = parser.parseS(N);

        GrammarChecker storeMemoryMachine = new GrammarChecker(N,T,P,S);

        System.out.println("\nEnter a string to recognize from the characters of the set ∑");
        boolean result = storeMemoryMachine.checkIfLL1();
        System.out.println("\n____________________________________________");
        System.out.println(result ? "It's LL(1) grammar!" : "This grammar isn't LL(1)");
    }
}
