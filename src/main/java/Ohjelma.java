
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Pair<String, Integer> pari = new Pair<>("yksi", 1);
        System.out.println(pari.getKey() + " -> " + pari.getValue());
    }

}
