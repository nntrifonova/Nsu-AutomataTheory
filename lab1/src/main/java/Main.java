import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static HashSet<Character> N = Parser.parseN();
    private static HashSet<Character> T = Parser.parseT(N);
    private static Multimap<Character, char[]> P = Parser.parseP(N,T);
    private static Character S = Parser.parseS(N);

    public static void main (String[] args) {
        System.out.println("Enter Context Free Grammar:");


        StoreMemoryMachine storeMemoryMachine = new StoreMemoryMachine(N,T,P,S);

        System.out.println("\nEnter a string to recognize from the characters of the set ∑");
        String innerStr;
        while (true) {
            boolean flag = false;
            innerStr = scanner.nextLine();
            for (char c:innerStr.toCharArray()) {
                if (!T.contains(c)) {
                    System.out.println("∑ does not contain the specified character");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        boolean result = storeMemoryMachine.syntaxAnalyzer(innerStr);
        System.out.println("\n____________________________________________");
        System.out.println(result ? "YES" : "NO");

    }

}