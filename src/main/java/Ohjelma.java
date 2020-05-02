
import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        HashMap<String, Integer> values = new HashMap<>();

        values.add("uno", 1);
        values.add("dos", 2);
        System.out.println(values.get("dos"));

        values.add("uno", 3);
        System.out.println(values.get("uno"));

        values.remove("dos");
        System.out.println(values.get("dos"));
    }

}
